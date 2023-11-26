package com.example.www_lab6.backend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "t_post")

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private Post post;
    private String title;
    private String metaTitle;
    private String summary;
    private boolean publish;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate createAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate updateAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate publishAt;
    private String content;

    public Post() {
    }

    public Post(long id, User user, Post post, String title, String metaTitle, String summary, boolean publish, LocalDate createAt, LocalDate updateAt, LocalDate publishAt, String content) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.publish = publish;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.publishAt = publishAt;
        this.content = content;
    }

    public Post(User user, Post post, String title, String metaTitle, String summary, boolean publish, LocalDate createAt, LocalDate updateAt, LocalDate publishAt, String content) {
        this.user = user;
        this.post = post;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.publish = publish;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.publishAt = publishAt;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDate getPublishAt() {
        return publishAt;
    }

    public void setPublishAt(LocalDate publishAt) {
        this.publishAt = publishAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", post=" + post +
                ", title='" + title + '\'' +
                ", metaTitle='" + metaTitle + '\'' +
                ", summary='" + summary + '\'' +
                ", publish=" + publish +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", publishAt=" + publishAt +
                ", content='" + content + '\'' +
                '}';
    }
}
