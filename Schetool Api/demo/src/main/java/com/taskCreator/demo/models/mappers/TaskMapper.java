package com.taskCreator.demo.models.mappers;

import com.taskCreator.demo.controllers.to.TaskTO;
import com.taskCreator.demo.models.bo.TaskBO;
import com.taskCreator.demo.models.de.TaskDE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskMapper {
    public static TaskDE convertBOToDE(TaskBO taskBO){
        return TaskDE.builder()
                .id(Objects.isNull(taskBO.getId()) ? null : taskBO.getId())
                .name(taskBO.getName())
                .description(taskBO.getDescription())
                .start(taskBO.getStart())
                .duration(taskBO.getDuration())
                .build();
    }

    public static TaskBO convertDEToBO(TaskDE taskDE){
        return TaskBO.builder()
                .id(Objects.isNull(taskDE.getId()) ? null : taskDE.getId())
                .name(taskDE.getName())
                .description(taskDE.getDescription())
                .start(taskDE.getStart())
                .duration(taskDE.getDuration())
                .build();
    }

    public static TaskBO convertTOToBO(TaskTO taskTO){
        return TaskBO.builder()
                .id(Objects.isNull(taskTO.getId()) ? null : taskTO.getId())
                .name(taskTO.getName())
                .description(taskTO.getDescription())
                .start(taskTO.getStart())
                .duration(taskTO.getDuration())
                .build();


    }

    public static TaskTO convertBOToTO(TaskBO taskBO){
        return TaskTO.builder()
                .id(Objects.isNull(taskBO.getId()) ? null : taskBO.getId())
                .name(taskBO.getName())
                .description((taskBO.getDescription()))
                .start(taskBO.getStart())
                .duration(taskBO.getDuration())
                .build();
    }

    public static List<TaskBO> convertDEListToBOList(List<TaskDE> taskDEList){
        List<TaskBO> taskBOList = new ArrayList<>();
        taskDEList.forEach(taskDE -> taskBOList.add(convertDEToBO(taskDE)));
        return taskBOList;
    }

    public static List<TaskTO> convertBOListToTOList(List<TaskBO> tasksBO){
        List<TaskTO> taskTOList = new ArrayList<>();
        tasksBO.forEach(taskBO -> taskTOList.add(convertBOToTO(taskBO)));
        return taskTOList;
    }
}
