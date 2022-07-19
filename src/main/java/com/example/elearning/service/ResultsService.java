package com.example.elearning.service;

import com.example.elearning.model.Results;

import java.util.List;

public interface ResultsService {

    List<Results> findAll();
    Results save(String Name, String points, String courseName);
}
