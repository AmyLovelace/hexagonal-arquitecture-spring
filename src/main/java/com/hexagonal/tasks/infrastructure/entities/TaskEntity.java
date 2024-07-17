package com.hexagonal.tasks.infrastructure.entities;

import com.hexagonal.tasks.domain.model.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime creationDate;

    private boolean completed;
    public TaskEntity(Long id, String title, String description, LocalDateTime creationDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = LocalDateTime.now();
        this.completed = completed;
    }

    public static TaskEntity fromDomain(Task task){
        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreationDate(),
                task.isCompleted()
        );
    }

    public Task toDomain(){
        return new Task(id, title, description, creationDate, completed);
    }
}
