package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.model.Task;
import com.hexagonal.tasks.domain.ports.in.CreateTask;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateTaskUsecaseImpl implements CreateTask {

    private final TaskRepositoryPort port;


    @Override
    public Task createTask(Task task) {
        return port.save(task);
    }
}
