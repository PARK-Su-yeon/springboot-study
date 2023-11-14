package com.example.todo.post.dto;

import com.example.todo.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostMapper {


    public PostResponseDto toResponseDto(Post entity) {
        return PostResponseDto.builder()
                .PostId(entity.getPostId()) // PostId
                .content(entity.getContent())
                .isCompleted(entity.isCompleted())
                .build();
    }

    public Page<PostResponseDto> toDtoPageList(Page<Post> postList) {
        return postList.map(this::toResponseDto);
    }

}