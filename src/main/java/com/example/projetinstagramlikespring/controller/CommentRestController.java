package com.example.projetinstagramlikespring.controller;
import com.example.projetinstagramlikespring.repository.CommentRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentRestController {
    private CommentRepository commentRepository;

    public CommentRestController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
