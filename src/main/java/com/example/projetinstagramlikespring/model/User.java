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

    public User(Long id, String username, String password, List<Posting> postingList, List<Posting> likedPostingList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.postingList = postingList;
        this.likedPostingList = likedPostingList;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Posting> getPostingList() {
        return postingList;
    }

    public void setPostingList(List<Posting> postingList) {
        this.postingList = postingList;
    }

    public List<Posting> getLikedPostingList() {
        return likedPostingList;
    }

    public void setLikedPostingList(List<Posting> likedPostingList) {
        this.likedPostingList = likedPostingList;
    }
}
