package com.forward.backend.application.expositions.mappers;

import com.forward.backend.application.expositions.dto.PersonDTO;
import com.forward.backend.domain.models.Person;
import org.mapstruct.*;


@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        uses = {},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface PersonDtoMapper extends GenericDTOMapper<Person, PersonDTO> {

}
