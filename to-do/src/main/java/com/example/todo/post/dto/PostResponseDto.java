package com.example.todo.post.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponseDto {

    private Long PostId;
    private boolean isCompleted;
    private String content;




}

