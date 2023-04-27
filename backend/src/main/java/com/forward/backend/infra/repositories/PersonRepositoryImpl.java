package com.forward.backend.infra.repositories;

import com.forward.backend.domain.models.Person;
import com.forward.backend.domain.repositories.PersonRepository;
import com.forward.backend.infra.repositories.jpa.PersonJPARepository;
import com.forward.backend.infra.repositories.jpa.mappers.PersonJPAMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public record PersonRepositoryImpl(PersonJPARepository jpaRepository,
                                   PersonJPAMapper mapper) implements PersonRepository {

    @Override
    public Person create(Person person) {
        return mapper.toDomain(jpaRepository.save(mapper.toRepository(person)));
    }

    @Override
    public List<Person> getAll() {
        return mapper.toDomain(jpaRepository.findAll());
    }

    @Override
    public Optional<Person> getById(Integer id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Person update(Person person) {
        return mapper.toDomain(jpaRepository.save(mapper.toRepository(person)));
    }

    @Override
    public void deleteById(Integer id) {
        jpaRepository.deleteById(id);
    }
}
