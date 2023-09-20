package com.example.projetinstagramlikespring.repository;

import com.example.projetinstagramlikespring.repository.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository extends JpaRepository<Posting, Long> {
}
