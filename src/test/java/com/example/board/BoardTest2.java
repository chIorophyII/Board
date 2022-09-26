package com.example.board;

import com.example.board.post.Post;
import com.example.board.post.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BoardTest2 {
    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("게시판 글 작성")
    void writePost(){
        // given
        String title = "new title";
        String content = "new content";

        Post postSave = new Post(title, content);
        postRepository.save(postSave);

        // when
        Post posty = postRepository.findByTitle(title);
//        List<Post> postList = postRepository.findAll();

        // then
        Assertions.assertThat(posty).isNotNull();
//        Post post = postList.get(0);
//        Assertions.assertThat(post.getTitle()).isEqualTo(title);
//        Assertions.assertThat(post.getContent()).isEqualTo(content);

    }
}