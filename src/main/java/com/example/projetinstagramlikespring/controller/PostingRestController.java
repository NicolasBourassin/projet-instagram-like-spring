package com.example.projetinstagramlikespring.controller;

import com.example.projetinstagramlikespring.model.Posting;
import com.example.projetinstagramlikespring.repository.PostingRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostingRestController {
    private PostingRepository postingRepository;

    public PostingRestController(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;
    }

    @PostMapping("/posting")
    Posting newPosting(@RequestBody Posting newPosting) {
        return postingRepository.save(newPosting);
    }
}
