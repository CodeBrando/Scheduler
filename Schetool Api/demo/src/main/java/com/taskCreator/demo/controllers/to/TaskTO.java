package com.taskCreator.demo.controllers.to;


import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class TaskTO {

    private Long id;

    @Size(min = 1, max = 50)
    @NotNull(message = "Name value is required")
    private String name;

    @Size(max = 500)
    private String description;

    @Size(min = 1, max = 12)
    private double start;

    @Size(min = 1, max = 12)
    private double duration;
}
