package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.model.AdditionalTasksInfo;
import com.hexagonal.tasks.domain.ports.in.AdditionalTask;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class GetAdditionalTaskInfoUsecaseImpl implements AdditionalTask {

    private final ExternalServicePort port;


    @Override
    public AdditionalTasksInfo getAdditionalTasksInfo(Long taskId) {
        return port.getAdditionalTasksInfo(taskId);
    }
}
