package com.emailTracker.emailExtractor.repository;

import com.emailTracker.emailExtractor.entity.EmailData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailData, Long> {
}