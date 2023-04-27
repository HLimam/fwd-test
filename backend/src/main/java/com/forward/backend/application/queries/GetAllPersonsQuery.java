package com.forward.backend.application.queries;


import com.forward.backend.kernel.Query;
import lombok.Builder;

@Builder
public record GetAllPersonsQuery() implements Query {

}