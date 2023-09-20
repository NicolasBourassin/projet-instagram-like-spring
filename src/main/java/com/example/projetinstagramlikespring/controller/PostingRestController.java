package com.example.projetinstagramlikespring.controller;

import com.example.projetinstagramlikespring.model.Posting;
import com.example.projetinstagramlikespring.model.User;
import com.example.projetinstagramlikespring.repository.PostingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PostingRestController {
    private PostingRepository postingRepository;

    public PostingRestController(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;
    }

    @PostMapping("/posting")
    Posting newPosting(@RequestBody Posting newPosting) {
        return postingRepository.save(newPosting);
    }

    @GetMapping("/postings")
    List<Posting> getAllPostings(){
        return postingRepository.findAll();
    }
}
