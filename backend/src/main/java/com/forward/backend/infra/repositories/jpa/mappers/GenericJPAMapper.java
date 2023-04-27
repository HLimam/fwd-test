package com.forward.backend.infra.repositories.jpa.mappers;

import java.util.Collection;
import java.util.List;

public interface GenericJPAMapper<D, R> {
    R toRepository(D domain);

    D toDomain(R repository);

    List<R> toRepository(Collection<D> domain);

    List<D> toDomain(Collection<R> repository);
}
