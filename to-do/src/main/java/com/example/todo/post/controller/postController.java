package com.example.todo.post.controller;



import com.example.todo.post.dto.PostRequestDto;
import com.example.todo.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/")
@RestController
public class postController {

    private final PostService postservice;

    @Autowired
    public postController(PostService postservice) {
        this.postservice = postservice;
    }


    @PostMapping("/posts")
    public ResponseEntity<?> posting(@RequestBody PostRequestDto dto) {
        return ResponseEntity.ok(postservice.createPost(dto));

    }

    @GetMapping("/posts")
    public ResponseEntity<?> postList(@PageableDefault(size = 10) final Pageable pageable) {
        return ResponseEntity.ok( postservice.pageList(pageable));

    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {
        return ResponseEntity.ok( postservice.getPost(id));

    }

    @PostMapping("/posts/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id,@RequestBody PostRequestDto dto) {
        return ResponseEntity.ok( postservice.update(dto,id));

    }


    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        return ResponseEntity.ok( postservice.delete(id));


    }

}
