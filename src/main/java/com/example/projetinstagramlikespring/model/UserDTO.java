package com.example.projetinstagramlikespring.model;

public class UserDTO {
    private Long id;
    private String username;
    private String photoUrl;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String photoUrl) {
        this.id = id;
        this.username = username;
        this.photoUrl = photoUrl;
    }

    public UserDTO(String username, String photoUrl) {
        this.username = username;
        this.photoUrl = photoUrl;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}