package com.hexagonal.tasks.infrastructure.adapters;

import com.hexagonal.tasks.domain.model.AdditionalTasksInfo;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class ExternalServiceAdapter implements ExternalServicePort {


    private final RestTemplate restTemplate;

    public ExternalServiceAdapter(){
        restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTasksInfo getAdditionalTasksInfo(Long taskId) {

        String apiUrlTodo = "https://jsonplaceholder.typicode.com/todos/";
        String Url =  apiUrlTodo +taskId;
        ResponseEntity<JsonPlaceholderTodo> res = restTemplate.getForEntity(Url,JsonPlaceholderTodo.class);
        JsonPlaceholderTodo todo = res.getBody();

        if(todo == null){
            return null;
        }

        String apiUrlUsers = "https://jsonplaceholder.typicode.com/users/";
        String UrlUsers = apiUrlUsers +todo.getUserId();
        ResponseEntity<JsonPlaceholderUser> resUser = restTemplate.getForEntity(UrlUsers,JsonPlaceholderUser.class);
        JsonPlaceholderUser user = resUser.getBody();
        if(user == null){
            return null;
        }
        return new AdditionalTasksInfo(user.getId(),user.getName(),user.getEmail());
    }


    @Getter
    @Setter
    @AllArgsConstructor
    private static class JsonPlaceholderTodo{
        private Long id;
        private Long userId;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class JsonPlaceholderUser{
        private Long id;
        private String name;
        private String email;

    }

}
