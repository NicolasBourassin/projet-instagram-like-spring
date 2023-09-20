package com.example.projetinstagramlikespring.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User author;
    private String textualComment;

    public Comment() {
    }

    public Comment(Long id, User author, String textualComment) {
        this.id = id;
        this.author = author;
        this.textualComment = textualComment;
    }

    public Comment(User author, String textualComment) {
        this.author = author;
        this.textualComment = textualComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTextualComment() {
        return textualComment;
    }

    public void setTextualComment(String textualComment) {
        this.textualComment = textualComment;
    }
}
