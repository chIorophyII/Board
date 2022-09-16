package com.example.board.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시글 생성

    @PostMapping("/post")
    public Post writePost (@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    // 게시글 전체 조회
    @GetMapping("/post")
    public List<Post> readPost() {
        return postService.readPost();
    }
}
