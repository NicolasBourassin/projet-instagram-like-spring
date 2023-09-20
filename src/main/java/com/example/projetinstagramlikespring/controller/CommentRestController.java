package com.example.projetinstagramlikespring.controller;
import com.example.projetinstagramlikespring.repository.entity.Comment;
import com.example.projetinstagramlikespring.repository.CommentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CommentRestController {
    private CommentRepository commentRepository;

    public CommentRestController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping("/comment")
    Comment newComment(@RequestBody Comment newComment) {
        return commentRepository.save(newComment);
    }

    @GetMapping("/comments")
    List<Comment> getAllComments(){
        return commentRepository.findAll();
    }
}
