package com.example.music.post.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponseDto {

    private Long PostId;
    private String title;
    private String content;




}

