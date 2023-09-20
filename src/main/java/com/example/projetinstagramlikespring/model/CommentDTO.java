package com.example.projetinstagramlikespring.model;

import com.example.projetinstagramlikespring.repository.entity.User;
import jakarta.persistence.ManyToOne;

public class CommentDTO {
    private Long id;
    private UserDTO author;
    private String textualComment;

    public CommentDTO() {
    }

    public CommentDTO(Long id, UserDTO author, String textualComment) {
        this.id = id;
        this.author = author;
        this.textualComment = textualComment;
    }

    public CommentDTO(UserDTO author, String textualComment) {
        this.author = author;
        this.textualComment = textualComment;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", author=" + author.getUsername() +
                ", textualComment='" + textualComment + '\'' +
                '}';
    }
}
