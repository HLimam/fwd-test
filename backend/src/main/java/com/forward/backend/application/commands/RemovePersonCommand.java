package com.forward.backend.application.commands;

import com.forward.backend.kernel.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemovePersonCommand implements Command {
    private Integer id;
}
