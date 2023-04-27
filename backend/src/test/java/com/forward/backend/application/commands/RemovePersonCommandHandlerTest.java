package com.forward.backend.application.commands;

import com.forward.backend.application.commands.RemovePersonCommand;
import com.forward.backend.application.commands.RemovePersonCommandHandler;
import com.forward.backend.application.exceptions.PersonNotFoundException;
import com.forward.backend.domain.models.Person;
import com.forward.backend.domain.repositories.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RemovePersonCommandHandlerTest {
    @Mock
    private PersonRepository repository;

    @Autowired
    private RemovePersonCommandHandler handler;

    @Test
    public void testRemovePersonCommand() {
        // Given
        var id = 1;
        var command = new RemovePersonCommand(id);
        when(repository.getById(anyInt())).thenReturn(Optional.of(new Person()));
        doNothing().when(repository).deleteById(id);

        // When
        assertDoesNotThrow(() -> handler.handle(command));
        // Then
        verify(repository).deleteById(id);
        verify(repository).getById(id);
    }

    @Test
    public void testRemovePersonCommandWhenPersonNotFound() {
        // Given
        var id = 1;
        var command = new RemovePersonCommand(id);

        when(repository.getById(anyInt())).thenReturn(Optional.empty());
        doNothing().when(repository).deleteById(anyInt());

        // When
        PersonNotFoundException exception = assertThrows(
                PersonNotFoundException.class,
                () -> handler.handle(command));

        // Then
        assertEquals("Person with ID " + id + " not found.", exception.getMessage());
        verify(repository).getById(id);
        verify(repository, never()).deleteById(anyInt());
    }

}
