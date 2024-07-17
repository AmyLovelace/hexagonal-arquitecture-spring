package com.hexagonal.tasks.domain.ports.out;

import com.hexagonal.tasks.domain.model.AdditionalTasksInfo;

public interface ExternalServicePort {

    AdditionalTasksInfo getAdditionalTasksInfo(Long taskId);
}
