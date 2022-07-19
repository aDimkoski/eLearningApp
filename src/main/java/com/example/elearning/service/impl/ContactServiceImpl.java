package com.example.elearning.service.impl;

import com.example.elearning.model.ContactMessages;
import com.example.elearning.repository.ContactRepository;
import com.example.elearning.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<ContactMessages> findAll() {
        return this.contactRepository.findAll();
    }

    @Override
    public ContactMessages save(String fullName, String email, String phonenumber, String message) {
        return this.contactRepository.save(new ContactMessages(fullName,email,phonenumber,message));
    }
}
