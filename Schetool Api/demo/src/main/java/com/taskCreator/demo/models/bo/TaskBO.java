package com.taskCreator.demo.models.bo;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class TaskBO {
    private Long id;
    private String name;
    private String description;
    private Double start;
    private Double duration;

}
