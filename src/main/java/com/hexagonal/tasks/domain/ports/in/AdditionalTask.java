package com.hexagonal.tasks.domain.ports.in;


import com.hexagonal.tasks.domain.model.AdditionalTasksInfo;

public interface AdditionalTask {

    AdditionalTasksInfo getAdditionalTasksInfo(Long taskId);

}
