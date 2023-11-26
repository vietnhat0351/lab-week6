package com.example.www_lab6.backend.repositories;

import com.example.www_lab6.backend.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
