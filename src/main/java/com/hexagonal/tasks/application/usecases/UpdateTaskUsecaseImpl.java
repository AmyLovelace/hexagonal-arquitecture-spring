package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.model.Task;
import com.hexagonal.tasks.domain.ports.in.UpdateTask;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.Optional;
@AllArgsConstructor
public class UpdateTaskUsecaseImpl implements UpdateTask {

    private final TaskRepositoryPort port;

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return port.update(updateTask);
    }
}
