package com.hexagonal.tasks.infrastructure.config;

import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.application.usecases.*;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.adapters.ExternalServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort port , GetAdditionalTaskInfoUsecaseImpl additionalTask){
        return new TaskService(
                new CreateTaskUsecaseImpl(port),
                new UpdateTaskUsecaseImpl(port),
                new DeleteTaskUsecaseImpl(port),
                new GetTaskUsecaseImpl(port),
                additionalTask
        );
    }



    @Bean
    public GetAdditionalTaskInfoUsecaseImpl getAdditionalTaskInfoUsecase(ExternalServicePort port){
        return new GetAdditionalTaskInfoUsecaseImpl(port);
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();

    }



}
