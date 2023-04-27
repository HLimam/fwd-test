package com.forward.backend.application.expositions.mappers;

import java.util.Collection;
import java.util.List;

public interface GenericDTOMapper<D, T> {
    T toDto(D domain);

    D toDomain(T dto);

    List<T> toDto(Collection<D> domain);

    List<D> toDomain(Collection<T> dto);
}
