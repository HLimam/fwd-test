package com.forward.backend.application.queries;

import com.forward.backend.kernel.Query;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPersonByIdQuery implements Query {
   private Integer personId;
}