package com.example.javabloglite.repository;

import com.example.javabloglite.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}