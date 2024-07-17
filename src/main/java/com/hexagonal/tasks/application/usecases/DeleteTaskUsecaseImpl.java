package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.ports.in.DeleteTask;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteTaskUsecaseImpl implements DeleteTask {

   private final TaskRepositoryPort port;

    @Override
    public boolean deleteTasks(Long taskId) {
        return port.deleteById(taskId);
    }
}
