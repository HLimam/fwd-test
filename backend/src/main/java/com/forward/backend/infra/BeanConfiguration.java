package com.forward.backend.infra;


import com.forward.backend.application.commands.*;
import com.forward.backend.application.queries.GetAllPersonsQuery;
import com.forward.backend.application.queries.GetAllPersonsQueryHandler;
import com.forward.backend.application.queries.GetPersonByIdQuery;
import com.forward.backend.application.queries.GetPersonByIdQueryHandler;
import com.forward.backend.domain.repositories.PersonRepository;
import com.forward.backend.kernel.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final PersonRepository repository;
    private final CreatePersonCommandHandler createPersonCommandHandler;
    private final RemovePersonCommandHandler removePersonCommandHandler;
    private final UpdatePersonCommandHandler updatePersonCommandHandler;
    private final GetAllPersonsQueryHandler getAllPersonsQueryHandler;
    private final GetPersonByIdQueryHandler getPersonByIdQueryHandler;


    @Bean
    public CommandBus getCommandBus(){
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreatePersonCommand.class, createPersonCommandHandler);
        commandHandlerMap.put(UpdatePersonCommand.class, updatePersonCommandHandler);
        commandHandlerMap.put(RemovePersonCommand.class, removePersonCommandHandler);
        return  new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus getQueryBus(){
        Map<Class<? extends Query>, QueryHandler> queryHandlerMap  = new HashMap<>();
        queryHandlerMap.put(GetAllPersonsQuery.class, getAllPersonsQueryHandler);
        queryHandlerMap.put(GetPersonByIdQuery.class, getPersonByIdQueryHandler);
        return new SimpleQueryBus(queryHandlerMap);
    }


}
