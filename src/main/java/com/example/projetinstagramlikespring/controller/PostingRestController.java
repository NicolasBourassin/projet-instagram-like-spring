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

        // Retrieve the author based on authorId from the DTO ==> maybe another way more straightforward ???
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
    } // TODO : check tuto on stream to re-use on fil rouge

    // TODO finish to manage like postings :

    @PostMapping("/posting/like/{postId}/{userId}")
    PostingDTO likeOrUnlikePosting(@PathVariable Long postId, @PathVariable Long userId) {
        // Find posting and user by ID
        Posting posting = postingRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Posting not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        // case where the user has already liked the posting -> unlike the post !
        if (posting.getLikingUserList().contains(user)) {
            posting.getLikingUserList().remove(user);
            user.getLikedPostingList().remove(posting);

            // Update the likesCounter of the posting based on the likingUserList size
            // fixme : counter was probably not necessary ... I should have used only size() of the likingUserList()
            posting.setLikesCounter(posting.getLikingUserList().size());

            posting = postingRepository.save(posting);
            user = userRepository.save(user);
        } else {
            // case where posting wasn't liked : LIKE IT
            posting.getLikingUserList().add(user);

            user.getLikedPostingList().add(posting);
            posting.setLikesCounter(posting.getLikingUserList().size());

            posting = postingRepository.save(posting);
            user = userRepository.save(user);
        }
        PostingDTO savedPostingDTO = new PostingDTO();
        BeanUtils.copyProperties(posting, savedPostingDTO);
        return savedPostingDTO;
    }
}