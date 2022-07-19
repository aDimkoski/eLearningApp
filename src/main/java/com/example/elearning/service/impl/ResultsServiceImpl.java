package com.example.elearning.service.impl;

import com.example.elearning.model.Results;
import com.example.elearning.repository.ResultsRepository;
import com.example.elearning.service.ResultsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultsServiceImpl implements ResultsService {
    private final ResultsRepository resultsRepository;

    public ResultsServiceImpl(ResultsRepository resultsRepository) {
        this.resultsRepository = resultsRepository;
    }

    @Override
    public List<Results> findAll() {
        return this.resultsRepository.findAll();
    }

    @Override
    public Results save(String Name,String points, String courseName) {
        return this.resultsRepository.save(new Results(Name,points,courseName));
    }
}
