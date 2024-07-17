package com.hexagonal.tasks.infrastructure.controllers;


import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.domain.model.AdditionalTasksInfo;
import com.hexagonal.tasks.domain.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService service;


    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task createdTask = service.createTask(task);

        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId){
        return service.getTask(taskId)
                .map(task-> new ResponseEntity<>(task,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask(){
        List<Task> tasks = service.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task updateTask){
        return service.updateTask(taskId, updateTask)
                .map(task-> new ResponseEntity<>(task,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId){
        if(service.deleteTasks(taskId)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{taskId}/additionalInfo")
    public ResponseEntity<AdditionalTasksInfo> getAdditionalTask(@PathVariable Long taskId){
        AdditionalTasksInfo additionalTasksInfo = service.getAdditionalTasksInfo(taskId);
        return new ResponseEntity<>(additionalTasksInfo, HttpStatus.OK);
    }

}
