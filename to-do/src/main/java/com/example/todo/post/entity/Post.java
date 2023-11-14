package com.example.todo.post.entity;

import com.example.todo.post.dto.PostRequestDto;
import com.example.todo.post.dto.PostResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long postId;

    private boolean isCompleted ;
    private String content;


    public void update(PostRequestDto dto){
        content= dto.getContent();
        isCompleted=dto.isCompleted();
    }

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
}
