package com.example.projetinstagramlikespring.controller;

import com.example.projetinstagramlikespring.model.UserDTO;
import com.example.projetinstagramlikespring.repository.UserRepository;
import com.example.projetinstagramlikespring.repository.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class UserRestController {
    private UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    UserDTO newUser(@RequestBody UserDTO newUserDTO) {
        User newUser = new User();
        // conversion user to dto :
        BeanUtils.copyProperties(newUserDTO, newUser);

        User savedUser = userRepository.save(newUser);

        UserDTO savedUserDTO = new UserDTO();
        BeanUtils.copyProperties(savedUser, savedUserDTO);

        return savedUserDTO;
    }

    @GetMapping("/users")
    List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO();
                    BeanUtils.copyProperties(user, userDTO);
                    return userDTO;
                })
                .collect(Collectors.toList());
    }
}