package com.hexagonal.tasks.infrastructure.repositories;

import com.hexagonal.tasks.domain.model.Task;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.entities.TaskEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository repository;
    @Override
    public Task save(Task task) {
        TaskEntity entity = TaskEntity.fromDomain(task);
        TaskEntity saveEntity = repository.save(entity);
        return saveEntity.toDomain();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return repository.findById(id).map(TaskEntity::toDomain);
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll().stream().map(TaskEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Task> update(Task task) {
        if(repository.existsById(task.getId())) {
            TaskEntity taskEntity = TaskEntity.fromDomain(task);
            TaskEntity updateTaskEntity = repository.save(taskEntity);
            return Optional.of(updateTaskEntity.toDomain());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if(repository.existsById(id) ){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
