package com.forward.backend.application.queries;

import com.forward.backend.application.exceptions.PersonNotFoundException;
import com.forward.backend.domain.models.Person;
import com.forward.backend.domain.repositories.PersonRepository;
import com.forward.backend.kernel.QueryHandler;
import org.springframework.stereotype.Service;

@Service
public record GetPersonByIdQueryHandler(PersonRepository repository) implements QueryHandler<GetPersonByIdQuery, Person> {

    @Override
    public Person handle(GetPersonByIdQuery query) {
        return repository.getById(query.getPersonId())
                .orElseThrow(() -> new PersonNotFoundException(query.getPersonId()));
    }
}
