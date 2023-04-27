package com.forward.backend.application.commands;

import com.forward.backend.application.exceptions.PersonNotFoundException;
import com.forward.backend.domain.repositories.PersonRepository;
import com.forward.backend.kernel.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public record RemovePersonCommandHandler(PersonRepository repository) implements CommandHandler<RemovePersonCommand, Void> {
    @Override
    public Void handle(RemovePersonCommand command) {
        repository.getById(command.getId()).orElseThrow(() -> new PersonNotFoundException(command.getId()));
        repository.deleteById(command.getId());
        return null;
    }
}
