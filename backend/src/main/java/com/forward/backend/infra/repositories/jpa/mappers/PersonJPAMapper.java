package com.forward.backend.infra.repositories.jpa.mappers;


import com.forward.backend.domain.models.Person;
import com.forward.backend.infra.repositories.jpa.entities.PersonJPA;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        uses = {},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface PersonJPAMapper extends GenericJPAMapper<Person, PersonJPA> {

}
