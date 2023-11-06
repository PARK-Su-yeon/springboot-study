package com.example.music.post.controller;


import com.example.music.post.dto.PostRequestDto;
import com.example.music.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RequestMapping("/api/v1/")
@RestController
public class postController {

    @Autowired
    PostService postservice;

    @PostMapping("/posts")
    public ResponseEntity<?> posting(@RequestBody PostRequestDto dto, Principal principal) {
        String email=principal.getName();
        return ResponseEntity.ok(postservice.createPost(dto, email));

    }

    @GetMapping("/posts")
    public ResponseEntity<?> postList(@PageableDefault(size = 10) final Pageable pageable) {
        return ResponseEntity.ok( postservice.pageList(pageable));

    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id , Principal principal) {
        return ResponseEntity.ok( postservice.getPost(id));

    }

    @PostMapping("/posts/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id,@RequestBody PostRequestDto dto, Principal principal) {
        String email=principal.getName();
        return ResponseEntity.ok( postservice.update(id,dto,email));

    }


    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id, Principal principal ) {
        String email=principal.getName();
        return ResponseEntity.ok( postservice.delete(id,email));


    }

}
