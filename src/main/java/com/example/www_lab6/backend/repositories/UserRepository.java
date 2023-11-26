package com.example.www_lab6.backend.repositories;

import com.example.www_lab6.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
