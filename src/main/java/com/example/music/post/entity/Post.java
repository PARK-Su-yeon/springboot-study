package com.example.music.post.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long postId;

    private String title;
    private String content;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
}
