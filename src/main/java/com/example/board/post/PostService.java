package com.example.board.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Post createPost(PostDto postDto) {

        Post post = new Post(postDto);

        postRepository.save(post);
        return post;
    }

    public List<Post> readPost() {
        List<Post> postList = postRepository.findAll();
        return postList;
    }
}
