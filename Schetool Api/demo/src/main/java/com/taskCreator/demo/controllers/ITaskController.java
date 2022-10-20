package com.taskCreator.demo.controllers;

import com.taskCreator.demo.controllers.to.ResponseTO;
import com.taskCreator.demo.controllers.to.TaskTO;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

//@CrossOrigin(allowedHeaders = "*", allowCredentials = "*", origins = "*", originPatterns = "*")
@RequestMapping("/api/v1/tasks")
public interface ITaskController {

    String APPLICATION_JSON = "application/json";

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @Operation(summary = "Saves a new task")
//    @CrossOrigin(allowedHeaders = "*", allowCredentials = "*", origins = "*", originPatterns = "*")
    @PostMapping(value = "/create", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    ResponseEntity<ResponseTO> saveTask(@ApiParam(value = "Task to create", required = true)
                                        @Valid @RequestBody TaskTO taskTO);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @Operation(summary = "Obtains all tasks")
//    @CrossOrigin(allowedHeaders = "*", allowCredentials = "*", origins = "*", originPatterns = "*")
    @GetMapping(value = "/obtain", produces = APPLICATION_JSON)
    ResponseEntity<?> obtainTasks();
}
