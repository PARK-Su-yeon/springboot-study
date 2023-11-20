package com.example.todo.user.filter;

import com.example.todo.user.domain.user.Role;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class AuthenticateUser {
    @NotNull
    private String email;
    private Set<Role> roles;
}
