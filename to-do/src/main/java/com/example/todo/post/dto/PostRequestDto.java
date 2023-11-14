package com.example.todo.post.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {

    private boolean isCompleted=false;
    private String content;
}
