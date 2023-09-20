package com.example.projetinstagramlikespring.repository;

import com.example.projetinstagramlikespring.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>  {
}
