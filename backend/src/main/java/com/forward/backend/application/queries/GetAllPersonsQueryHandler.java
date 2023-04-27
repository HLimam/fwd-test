package com.forward.backend.application.queries;

import com.forward.backend.domain.models.Person;
import com.forward.backend.domain.repositories.PersonRepository;
import com.forward.backend.kernel.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public record GetAllPersonsQueryHandler(PersonRepository repository) implements QueryHandler<GetAllPersonsQuery,List<Person>> {

    @Override
    public List<Person> handle(GetAllPersonsQuery query) {
        return repository.getAll();
    }
}
