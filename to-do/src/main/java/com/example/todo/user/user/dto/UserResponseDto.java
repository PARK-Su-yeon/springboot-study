package com.example.todo.user.user.dto;

import com.example.todo.user.domain.user.Users;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String email;
    private String username;

    public UserResponseDto(Users users){
        this.email = users.getUserEmail();
        this.username = users.getUsername();
    }
}
