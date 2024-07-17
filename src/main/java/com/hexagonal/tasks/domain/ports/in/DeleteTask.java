package com.hexagonal.tasks.domain.ports.in;


public interface DeleteTask {

    boolean deleteTasks(Long taskId);

}
