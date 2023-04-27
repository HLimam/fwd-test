package com.forward.backend.infra.repositories.jpa.projections;

import java.time.LocalDate;

public interface PersonProjection {
    Integer getId();
    String getFirstName();
    String getLastName();
    String getEmail();
    LocalDate getBirthDate();
    String getPhoto();
}
