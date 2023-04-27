package com.forward.backend.domain.repositories;


import com.forward.backend.domain.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Person create(Person person);
    List<Person> getAll();
    Optional<Person> getById(Integer id);
    Person update(Person person);
    void deleteById(Integer id);

}
