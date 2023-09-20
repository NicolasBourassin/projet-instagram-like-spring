package com.example.projetinstagramlikespring.repository;

import com.example.projetinstagramlikespring.repository.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>  {
}
