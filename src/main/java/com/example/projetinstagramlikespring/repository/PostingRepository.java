package com.example.projetinstagramlikespring.repository;

import com.example.projetinstagramlikespring.model.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository extends JpaRepository<Posting, Long> {
}
