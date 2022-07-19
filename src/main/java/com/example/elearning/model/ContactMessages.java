package com.example.elearning.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ContactMessages {

    @Id
    @GeneratedValue
    private Long id;

    private String fullName;

    private String email;

    private String phonenumber;

    private String message;

    public ContactMessages(String fullName, String email, String phonenumber, String message) {
        this.fullName = fullName;
        this.email = email;
        this.phonenumber = phonenumber;
        this.message = message;
    }

    public ContactMessages() {

    }
}
