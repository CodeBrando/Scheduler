package com.taskCreator.demo.controllers;


import com.taskCreator.demo.controllers.to.ResponseTO;
import com.taskCreator.demo.controllers.to.TaskTO;
import com.taskCreator.demo.models.mappers.TaskMapper;
import com.taskCreator.demo.services.TaskService;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@Log4j2
public class TaskController implements ITaskController{

    @Autowired
    TaskService taskService;

    @Override
    public ResponseEntity<ResponseTO> saveTask(TaskTO taskTO){
        log.info("TRYING TO SAVE TASK...");
        ResponseEntity<ResponseTO> response;
        try{
            taskService.saveTask(TaskMapper.convertTOToBO(taskTO));
            response = new ResponseEntity<>(ResponseTO.builder()
                    .message(HttpStatus.CREATED.name())
                    .build(), HttpStatus.CREATED);
            log.info("TASK SUCCESSFULLY CREATED");
        } catch(EntityExistsException e){
            log.error("THERE HAS BEEN AN ERROR WHILE SAVING THE TASK" + e);
            response = new ResponseEntity<>(ResponseTO.builder()
                    .message(e.getMessage())
                    .build(), HttpStatus.BAD_REQUEST);
        }
    return response;
    }

    @Override
    public ResponseEntity<?> obtainTasks(){
        log.info("TRYING TO OBTAIN ALL TASKS...");
        ResponseEntity<?> response;
        try{
            List<TaskTO> allTasks = TaskMapper.convertBOListToTOList(taskService.obtainAllTasks());
            response = new ResponseEntity<>(allTasks, HttpStatus.OK);
            log.info("ALL TASKS SUCCESSFULLY RETRIEVED");
        } catch (EntityNotFoundException e){
            log.error("THERE HAS BEEN AN ERROR WHILE OBTAINING ALL TASKS");
            response = new ResponseEntity<>(ResponseTO.builder().message(e.getMessage()).build(),HttpStatus.NOT_FOUND);
        }
    return response;
    }


}
