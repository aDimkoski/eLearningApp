package com.example.elearning.repository;

import com.example.elearning.model.ContactMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactMessages,Long> {
}
