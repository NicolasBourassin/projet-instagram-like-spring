package com.example.projetinstagramlikespring.controller;

import com.example.projetinstagramlikespring.model.PostingDTO;
import com.example.projetinstagramlikespring.repository.PostingRepository;
import com.example.projetinstagramlikespring.repository.UserRepository;
import com.example.projetinstagramlikespring.repository.entity.Posting;
import com.example.projetinstagramlikespring.repository.entity.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class PostingRestController {
    private PostingRepository postingRepository;
    private UserRepository userRepository;

    public PostingRestController(PostingRepository postingRepository, UserRepository userRepository) {
        this.postingRepository = postingRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/posting")
    PostingDTO newPosting(@RequestBody PostingDTO newPostingDTO) {
        Posting newPosting = new Posting();

        System.out.println("Received newPostingDTO: " + newPostingDTO.toString());

        BeanUtils.copyProperties(newPostingDTO, newPosting);

        // Retrieve the author based on authorId from the DTO
        User author = userRepository.findById(newPostingDTO.getAuthor().getId())
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));

        System.out.println("Retrieved author: " + author.toString());
        newPosting.setAuthor(author);

        Posting savedPosting = postingRepository.save(newPosting);

        PostingDTO savedPostingDTO = new PostingDTO();
        BeanUtils.copyProperties(savedPosting, savedPostingDTO);

        return savedPostingDTO;
    }
    @GetMapping("/postings")
    List<PostingDTO> getAllPostings() {
        List<Posting> postings = postingRepository.findAll();

        return postings.stream()
                .map(posting -> {
                    PostingDTO postingDTO = new PostingDTO();
                    BeanUtils.copyProperties(posting, postingDTO);
                    return postingDTO;
                })
                .collect(Collectors.toList());
    }
}