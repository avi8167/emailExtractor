package com.emailTracker.emailExtractor.service;

import com.emailTracker.emailExtractor.entity.EmailData;
import com.emailTracker.emailExtractor.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public void extractAndSaveEmails(MultipartFile file) {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(file.getInputStream()));

            String line;

            Pattern pattern =
                    Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

            while ((line = reader.readLine()) != null) {

                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {

                    String email = matcher.group();

                    EmailData emailData = new EmailData(email);

                    emailRepository.save(emailData);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<EmailData> getAllEmails() {
        return emailRepository.findAll();
    }
}