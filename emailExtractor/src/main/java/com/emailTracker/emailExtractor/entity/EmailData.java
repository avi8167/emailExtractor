package com.emailTracker.emailExtractor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emails")
public class EmailData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    @Column(name = "sourse_file")
    private String sourceFile;

    public EmailData() {
    }

    public EmailData(String email) {
        this.email = email;
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
}
