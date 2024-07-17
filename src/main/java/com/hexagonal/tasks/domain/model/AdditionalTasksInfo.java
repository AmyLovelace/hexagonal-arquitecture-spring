package com.hexagonal.tasks.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdditionalTasksInfo {

    private final Long userId;
    private final String userName;
    private final String userEmail;

}
