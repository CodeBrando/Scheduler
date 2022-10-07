package com.taskCreator.demo.models.bo;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.bytebuddy.implementation.bind.annotation.Super;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class TaskBO {
    private Long id;
    private String name;
    private String description;
    private Float time;
    private Float duration;

}
