package com.hexagonal.tasks.application.services;

import com.hexagonal.tasks.domain.model.AdditionalTasksInfo;
import com.hexagonal.tasks.domain.model.Task;
import com.hexagonal.tasks.domain.ports.in.*;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
public class TaskService implements CreateTask, DeleteTask, GetTask, UpdateTask, AdditionalTask {

    private final CreateTask createTask;
    private final UpdateTask updateTaskInterface;
    private final DeleteTask deleteTask;
    private final GetTask getTask;
    private final AdditionalTask additionalTask;


    @Override
    public AdditionalTasksInfo getAdditionalTasksInfo(Long taskId) {

        return additionalTask.getAdditionalTasksInfo(taskId);
    }

    @Override
    public Task createTask(Task task) {

        return createTask.createTask(task);

    }

    @Override
    public boolean deleteTasks(Long taskId) {

        return deleteTask.deleteTasks(taskId);
    }

    @Override
    public Optional<Task> getTask(Long id) {

        return getTask.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {

        return getTask.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {

        return updateTaskInterface.updateTask(id, updateTask);
    }
}
