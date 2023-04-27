package com.forward.backend.application.expositions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String photo;
}
