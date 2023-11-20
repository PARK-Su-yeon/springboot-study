package com.example.todo.user.user.dto;

import com.example.todo.user.domain.user.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRegisterDto {
    private String userEmail;

    private String password;

    private String username;

    public Users toEntity(){
        return Users.builder()
                .username(username)
                .email(userEmail)
                .password(password)
                .build();
    }
}
