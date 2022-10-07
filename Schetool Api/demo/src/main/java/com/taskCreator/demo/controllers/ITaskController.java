package com.taskCreator.demo.controllers;

import com.taskCreator.demo.controllers.to.ResponseTO;
import com.taskCreator.demo.controllers.to.TaskTO;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/v1/task")
public interface ITaskController {

    String APPLICATION_JSON = "application/json";

    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @Operation(summary = "Saves a new task")
    @PostMapping(value = "/create-task", produces = APPLICATION_JSON)
    ResponseEntity<ResponseTO> saveTask(@ApiParam(value = "Task to create", required = true) @Valid @RequestBody TaskTO taskTO);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Retrieved Successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @Operation(summary = "Obtains all tasks")
    @GetMapping(value = "/obtain-tasks", produces = APPLICATION_JSON)
    ResponseEntity<?> obtainTasks();
}
