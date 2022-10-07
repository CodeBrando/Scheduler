package com.taskCreator.demo.services;

import com.taskCreator.demo.controllers.to.TaskTO;
import com.taskCreator.demo.models.bo.TaskBO;
import com.taskCreator.demo.models.de.TaskDE;
import com.taskCreator.demo.models.mappers.TaskMapper;
import com.taskCreator.demo.repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    ITaskRepository repository;

//    public TaskDE saveTask(TaskBO taskBO){
//        return repository.save(TaskMapper.convertBOToDE(taskBO));
//    }

    public TaskDE saveTask(TaskBO taskBO){
        return repository.save(TaskMapper.convertBOToDE(taskBO));
    }

//    public List<TaskTO> returnAllTasks(String name) throws EntityNotFoundException {
//        TaskDE taskDEByName = repository.findByName(name)
//                .orElseThrow(() -> new EntityNotFoundException("Cannot find task with name " + name));
//        List<TaskDE> allTasksDE = new ArrayList<>();
//        List<TaskBO> allTasksBO = new ArrayList<>();
//        allTasksDE.add(taskDEByName);
//        allTasksDE.forEach(taskDE -> allTasksBO.add(TaskMapper.convertDEToBO(taskDE)));
//        return TaskMapper.convertBOListToTOList(allTasksBO);

    public List<TaskBO> obtainAllTasks(){
        return TaskMapper.convertDEListToBOList(repository.findAll());
    }
}
