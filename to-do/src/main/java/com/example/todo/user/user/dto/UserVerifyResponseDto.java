package com.example.todo.user.user.dto;

import com.example.todo.user.domain.user.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class UserVerifyResponseDto {
    private boolean isValid;
    private Set<Role> userRole;
}
