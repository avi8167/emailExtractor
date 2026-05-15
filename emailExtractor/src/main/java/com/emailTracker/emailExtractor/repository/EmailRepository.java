package com.example.emailextractor.repository;

import com.example.emailextractor.entity.EmailData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailRepository extends JpaRepository<EmailData, Long> {

    Optional<EmailData> findByEmail(String email);
}