package com.example.projetinstagramlikespring.controller;

import com.example.projetinstagramlikespring.model.CommentDTO;
import com.example.projetinstagramlikespring.repository.CommentRepository;
import com.example.projetinstagramlikespring.repository.entity.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class CommentRestController {
    private CommentRepository commentRepository;

    public CommentRestController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping("/comment")
    CommentDTO newComment(@RequestBody CommentDTO newCommentDTO) {
        Comment newComment = new Comment();
        BeanUtils.copyProperties(newCommentDTO, newComment);

        Comment savedComment = commentRepository.save(newComment);

        CommentDTO savedCommentDTO = new CommentDTO();
        BeanUtils.copyProperties(savedComment, savedCommentDTO);

        return savedCommentDTO;
    }

    @GetMapping("/comments")
    List<CommentDTO> getAllComments() {
        List<Comment> comments = commentRepository.findAll();

        return comments.stream()
                .map(comment -> {
                    CommentDTO commentDTO = new CommentDTO();
                    BeanUtils.copyProperties(comment, commentDTO);
                    return commentDTO;
                })
                .collect(Collectors.toList());
    }
}