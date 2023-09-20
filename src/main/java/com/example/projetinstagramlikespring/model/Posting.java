package com.example.projetinstagramlikespring.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="postings")
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private String urlContent;
    private Boolean isAVideo; //if false, this is a picture
    private Integer likesCounter;
    @OneToMany
    private List<Comment> commentList;

    @ManyToMany
    @JoinColumn(name = "user_id")
    private List<User> likingUserList;
}
