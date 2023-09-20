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

    public Posting() {
    }

    public Posting(Long id, User author, String urlContent, Boolean isAVideo, Integer likesCounter,
                   List<Comment> commentList, List<User> likingUserList) {
        this.id = id;
        this.author = author;
        this.urlContent = urlContent;
        this.isAVideo = isAVideo;
        this.likesCounter = likesCounter;
        this.commentList = commentList;
        this.likingUserList = likingUserList;
    }

    public Posting(User author, String urlContent, Boolean isAVideo, Integer likesCounter) {
        this.author = author;
        this.urlContent = urlContent;
        this.isAVideo = isAVideo;
        this.likesCounter = likesCounter;
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

    public String getUrlContent() {
        return urlContent;
    }

    public void setUrlContent(String urlContent) {
        this.urlContent = urlContent;
    }

    public Boolean getAVideo() {
        return isAVideo;
    }

    public void setAVideo(Boolean AVideo) {
        isAVideo = AVideo;
    }

    public Integer getLikesCounter() {
        return likesCounter;
    }

    public void setLikesCounter(Integer likesCounter) {
        this.likesCounter = likesCounter;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<User> getLikingUserList() {
        return likingUserList;
    }

    public void setLikingUserList(List<User> likingUserList) {
        this.likingUserList = likingUserList;
    }
}
