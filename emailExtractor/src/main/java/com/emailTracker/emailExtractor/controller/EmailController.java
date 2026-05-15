package com.example.emailextractor.controller;

import com.example.emailextractor.entity.EmailData;
import com.example.emailextractor.repository.EmailRepository;
import com.example.emailextractor.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailRepository repository;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        return emailService.extractEmails(file);
    }

    @GetMapping("/emails")
    public List<EmailData> getAllEmails() {

        return repository.findAll();
    }
}