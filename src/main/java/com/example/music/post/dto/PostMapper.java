package com.example.music.post.dto;

import com.example.music.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostMapper {


    public PostResponseDto toResponseDto(Post entity) {
        return PostResponseDto.builder()
                .PostId(entity.getPostId()) // PostId
                .title(entity.getTitle())
                .content(entity.getContent())
                .build();
    }

    public Page<PostResponseDto> toDtoPageList(Page<Post> postList) {
        return postList.map(this::toResponseDto);
    }

}