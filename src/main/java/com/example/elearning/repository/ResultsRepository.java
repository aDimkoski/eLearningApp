package com.example.elearning.repository;

import com.example.elearning.model.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepository extends JpaRepository<Results,Long> {
}
