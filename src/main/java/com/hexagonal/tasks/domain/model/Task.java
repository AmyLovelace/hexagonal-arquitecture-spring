package com.hexagonal.tasks.domain.model;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Task {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime creationDate;

    private boolean isCompleted;

    public Task(Long id, String title, String description, LocalDateTime creationDate, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = LocalDateTime.now();
        this.isCompleted = isCompleted;
    }
}
