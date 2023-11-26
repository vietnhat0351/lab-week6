package com.example.www_lab6.backend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "t_post_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private PostComment postComment;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private String title;
    private boolean publish;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate crateAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate publishedAt;
    private String content;

    public PostComment() {
    }
}
