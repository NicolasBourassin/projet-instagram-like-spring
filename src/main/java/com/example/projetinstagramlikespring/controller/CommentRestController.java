package com.example.projetinstagramlikespring.controller;
import com.example.projetinstagramlikespring.model.Comment;
import com.example.projetinstagramlikespring.repository.CommentRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
public class CommentRestController {
    private CommentRepository commentRepository;

    public CommentRestController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping("/comment")
    Comment newComment(@RequestBody Comment newComment) {
        return commentRepository.save(newComment);
    }
}
