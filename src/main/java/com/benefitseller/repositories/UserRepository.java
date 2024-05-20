package com.benefitseller.repositories;

import com.benefitseller.models.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CardHolder, Long> {
    Optional<CardHolder> findByUsername(String username);
}
