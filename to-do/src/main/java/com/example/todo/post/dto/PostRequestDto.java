package com.example.todo.post.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
public class PostRequestDto {

    private boolean isCompleted=false;
    @Max(500)
    @NotNull
    private String content;
}
