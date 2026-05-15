package com.example.emailextractor.service;

import com.example.emailextractor.entity.EmailData;
import com.example.emailextractor.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;

    public String extractEmails(MultipartFile file) {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(file.getInputStream()));

            String line;

            String regex =
                    "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

            Pattern pattern = Pattern.compile(regex);

            while ((line = reader.readLine()) != null) {

                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {

                    String email = matcher.group();

                    boolean exists =
                            repository.findByEmail(email).isPresent();

                    if (!exists) {

                        EmailData emailData =
                                new EmailData(email, file.getOriginalFilename());

                        repository.save(emailData);
                    }
                }
            }

            return "Emails Extracted Successfully";

        } catch (Exception e) {
            e.printStackTrace();
            return "Failed";
        }
    }
}