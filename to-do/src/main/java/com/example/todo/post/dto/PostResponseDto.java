package com.example.todo.post.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponseDto {
    @NotNull
    private Long PostId;
    @NotNull
    private boolean isCompleted;
    @NotNull
    private String content;




}

