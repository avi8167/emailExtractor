package com.emailTracker.emailExtractor.controller;

import com.emailTracker.emailExtractor.entity.EmailData;
import com.emailTracker.emailExtractor.service.EmailService;

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

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        emailService.extractAndSaveEmails(file);

        return "Emails extracted and saved successfully!";
    }

    @GetMapping("/emails")
    public List<EmailData> getAllEmails() {
        return emailService.getAllEmails();
    }
}