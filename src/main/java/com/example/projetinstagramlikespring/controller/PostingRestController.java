package com.example.projetinstagramlikespring.controller;

import com.example.projetinstagramlikespring.model.PostingDTO;
import com.example.projetinstagramlikespring.repository.PostingRepository;
import com.example.projetinstagramlikespring.repository.entity.Posting;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class PostingRestController {
    private PostingRepository postingRepository;

    public PostingRestController(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;
    }

    @PostMapping("/posting")
    PostingDTO newPosting(@RequestBody PostingDTO newPostingDTO) {
        Posting newPosting = new Posting();
        BeanUtils.copyProperties(newPostingDTO, newPosting);

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