package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.model.Task;
import com.hexagonal.tasks.domain.ports.in.GetTask;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class GetTaskUsecaseImpl implements GetTask {

    private final TaskRepositoryPort port;

    @Override
    public Optional<Task> getTask(Long id) {
        return port.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return port.findAll();
    }
}
