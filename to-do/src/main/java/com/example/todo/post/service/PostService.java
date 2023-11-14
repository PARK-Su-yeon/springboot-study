package com.example.todo.post.service;


import com.example.todo.post.dto.PostMapper;
import com.example.todo.post.dto.PostRequestDto;
import com.example.todo.post.dto.PostResponseDto;
import com.example.todo.post.entity.Post;
import com.example.todo.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class PostService {


    private final PostRepository postRepository;

//    private UserRepository userRepository;
    private final PostMapper postMapper;


    public Post createPost(PostRequestDto dto){
        return postRepository.save(Post.builder()
                .isCompleted(dto.isCompleted())
                .content(dto.getContent())
                .build());
    }


    public List<PostResponseDto> pageList(Pageable pageable) {
        Page<Post> postList = postRepository.findAll(pageable);
        return postMapper.toDtoPageList(postList).getContent();
    }

    public Post getPost(Long id) {
            return postRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("not found"));
        }

    public Object update(PostRequestDto dto,long id) {

        Post entity= postRepository.findById(id).get();
        entity.update(dto);
        return entity;
    }


    public Object delete(Long id) {
        Post entity = postRepository.findById(id).get();
        postRepository.deleteById(entity.getPostId());
        return "삭제  성공했습니다";
//        if (entity.getUser().getEmail().equals(email)) {
//            if (postRepository.existsById(id)) {
//                postRepository.deleteById(id);
//                return "삭제  성공했습니다";
//
//            }
//        }
      //  return "삭제 실패";
    }
}

