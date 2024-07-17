package com.hexagonal.tasks.domain.ports.in;

import com.hexagonal.tasks.domain.model.Task;
import java.util.Optional;

public interface UpdateTask {
    Optional<Task> updateTask(Long id, Task updateTask);

}
