package com.example.www_lab6.backend.repositories;

import com.example.www_lab6.backend.entities.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment,Long> {
}
