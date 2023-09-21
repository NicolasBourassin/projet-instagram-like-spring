package com.example.projetinstagramlikespring.model;

import java.util.ArrayList;
import java.util.List;

public class PostingDTO {
        private Long id;
        private UserDTO author;
        private String urlContent;
        private Boolean videoType;
        private Integer likesCounter;
        private List<CommentDTO> commentList=new ArrayList<>();
        private List<UserDTO> likedUserList=new ArrayList<>();

        public PostingDTO() {
        }

        public PostingDTO(Long id, UserDTO author, String urlContent, Boolean videoType, Integer likesCounter, List<CommentDTO> commentList, List<UserDTO> likedUserList) {
                this.id = id;
                this.author = author;
                this.urlContent = urlContent;
                this.videoType = videoType;
                this.likesCounter = likesCounter;
                this.commentList = commentList;
                this.likedUserList = likedUserList;
        }

        public PostingDTO(UserDTO author, String urlContent, Boolean videoType) {
                this.author = author;
                this.urlContent = urlContent;
                this.videoType = videoType;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public UserDTO getAuthor() {
                return author;
        }

        public void setAuthor(UserDTO author) {
                this.author = author;
        }

        public String getUrlContent() {
                return urlContent;
        }

        public void setUrlContent(String urlContent) {
                this.urlContent = urlContent;
        }

        public Boolean getVideoType() {
                return videoType;
        }

        public void setVideoType(Boolean videoType) {
                this.videoType = videoType;
        }

        public Integer getLikesCounter() {
                return likesCounter;
        }

        public void setLikesCounter(Integer likesCounter) {
                this.likesCounter = likesCounter;
        }

        public List<CommentDTO> getCommentList() {
                return commentList;
        }

        public void setCommentList(List<CommentDTO> commentList) {
                this.commentList = commentList;
        }

        public List<UserDTO> getLikedUserList() {
                return likedUserList;
        }

        public void setLikedUserList(List<UserDTO> likedUserList) {
                this.likedUserList = likedUserList;
        }

        @Override
        public String toString() {
                return "PostingDTO{" +
                        "author=" + author.getUsername() +
                        ", urlContent='" + urlContent + '\'' +
                        ", videoType=" + videoType +
                        ", likesCounter=" + likesCounter +
                        ", commentList size=" + commentList.size() +
                        ", likedUserList size=" + likedUserList.size() +
                        '}';
        }
}

