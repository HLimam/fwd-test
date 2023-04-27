package com.forward.backend.application.commands;


import com.forward.backend.domain.models.Person;
import com.forward.backend.domain.repositories.PersonRepository;
import com.forward.backend.kernel.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public record CreatePersonCommandHandler(PersonRepository repository) implements CommandHandler<CreatePersonCommand, Person> {
    @Override
    public Person handle(CreatePersonCommand command) {
        var person = Person.builder()
                .lastName(command.getLastName())
                .firstName(command.getFirstName())
                .email(command.getEmail())
                .birthDate(command.getBirthDate())
                .photo(command.getPhoto())
                .build();
        return repository.create(person);
    }
}
