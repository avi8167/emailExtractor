
package com.emailTracker.emailExtractor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emails")
public class EmailData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(name = "source_file")
    private String sourceFile;

    // Default Constructor
    public EmailData() {
    }

    // Constructor For Email Only
    public EmailData(String email) {
        this.email = email;
    }

    // Constructor For Email + Source File
    public EmailData(String email, String sourceFile) {
        this.email = email;
        this.sourceFile = sourceFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }
}

//package com.emailTracker.emailExtractor.service;
//
//import com.emailTracker.emailExtractor.entity.EmailData;
//import com.emailTracker.emailExtractor.repository.EmailRepository;
//
//import org.apache.poi.ss.usermodel.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private EmailRepository emailRepository;
//
//    // Extract Emails
//    public void extractAndSaveEmails(MultipartFile file) {
//
//        try {
//
//            String fileName =
//                    file.getOriginalFilename();
//
//            if(fileName.endsWith(".xlsx")
//                    || fileName.endsWith(".xls")) {
//
//                extractFromExcel(file, fileName);
//
//            } else {
//
//                extractFromText(file, fileName);
//            }
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//    }
//
//    // TEXT FILE
//    private void extractFromText(
//            MultipartFile file,
//            String fileName
//    ) {
//
//        try {
//
//            BufferedReader reader =
//                    new BufferedReader(
//                            new InputStreamReader(
//                                    file.getInputStream()
//                            )
//                    );
//
//            String line;
//
//            Pattern pattern =
//                    Pattern.compile(
//                            "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
//                    );
//
//            while ((line = reader.readLine()) != null) {
//
//                Matcher matcher =
//                        pattern.matcher(line);
//
//                while (matcher.find()) {
//
//                    String email =
//                            matcher.group();
//
//                    EmailData emailData =
//                            new EmailData(
//                                    email,
//                                    fileName
//                            );
//
//                    emailRepository.save(emailData);
//                }
//            }
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//    }
//
//    // EXCEL FILE
//    private void extractFromExcel(
//            MultipartFile file,
//            String fileName
//    ) {
//
//        try {
//
//            Workbook workbook =
//                    WorkbookFactory.create(
//                            file.getInputStream()
//                    );
//
//            Sheet sheet =
//                    workbook.getSheetAt(0);
//
//            Pattern pattern =
//                    Pattern.compile(
//                            "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
//                    );
//
//            for (Row row : sheet) {
//
//                for (Cell cell : row) {
//
//                    String value =
//                            cell.toString();
//
//                    Matcher matcher =
//                            pattern.matcher(value);
//
//                    while (matcher.find()) {
//
//                        String email =
//                                matcher.group();
//
//                        EmailData emailData =
//                                new EmailData(
//                                        email,
//                                        fileName
//                                );
//
//                        emailRepository.save(emailData);
//                    }
//                }
//            }
//
//            workbook.close();
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//    }
//
//    // Get All Emails
//    public List<EmailData> getAllEmails() {
//
//        return emailRepository.findAll();
//    }
//
//    // Delete One Email
//    public void deleteEmail(Long id) {
//
//        emailRepository.deleteById(id);
//    }
//
//    // Delete All Emails
//    public void deleteAllEmails() {
//
//        emailRepository.deleteAll();
//    }
//}
