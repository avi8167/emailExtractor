package com.example.emailextractor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emails")
public class EmailData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String sourceFile;

    public EmailData() {
    }

    public EmailData(String email, String sourceFile) {
        this.email = email;
        this.sourceFile = sourceFile;
    }

    public Long getId() {
        return id;
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