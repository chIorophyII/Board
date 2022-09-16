package com.example.board.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String title;
    private String content;

    public Post(PostDto postDto) {
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
