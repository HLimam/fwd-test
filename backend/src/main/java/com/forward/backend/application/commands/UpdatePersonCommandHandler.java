package com.forward.backend.application.commands;


import com.forward.backend.application.exceptions.PersonNotFoundException;
import com.forward.backend.domain.models.Person;
import com.forward.backend.domain.repositories.PersonRepository;
import com.forward.backend.kernel.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public record UpdatePersonCommandHandler(PersonRepository repository) implements CommandHandler<UpdatePersonCommand, Person> {
    @Override
    public Person handle(UpdatePersonCommand command) {
        var person = repository.getById(command.getId()).orElseThrow(() -> new PersonNotFoundException(command.getId()));
        person.setFirstName(command.getFirstName());
        person.setLastName(command.getLastName());
        person.setEmail(command.getEmail());
        person.setBirthDate(command.getBirthDate());
        person.setPhoto(command.getPhoto());
        return repository.update(person);
    }
}
