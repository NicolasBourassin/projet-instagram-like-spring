package com.example.projetinstagramlikespring.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @OneToMany(mappedBy = "author")
    private List<Posting> postingList;
    @ManyToMany
    private List<Posting> likedPostingList;


    public User() {
    }
}
