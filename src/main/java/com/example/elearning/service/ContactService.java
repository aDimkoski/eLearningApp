package com.example.elearning.service;

import com.example.elearning.model.ContactMessages;

import java.util.List;

public interface ContactService {

    List<ContactMessages> findAll();
    ContactMessages save(String fullName,String email,String phonenumber,String message);

}
