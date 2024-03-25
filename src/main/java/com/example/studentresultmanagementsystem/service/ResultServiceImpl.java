package com.example.studentresultmanagementsystem.service;

import com.example.studentresultmanagementsystem.dto.ResultDTO;
import com.example.studentresultmanagementsystem.exception.ResultException;
import com.example.studentresultmanagementsystem.exception.StudentException;
import com.example.studentresultmanagementsystem.mapper.ResultMapper;
import com.example.studentresultmanagementsystem.model.Result;
import com.example.studentresultmanagementsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public ResultDTO addResult(Result result) throws ResultException {
        try {
            return ResultMapper.convertToDto(resultRepository.save(result));
        } catch (DataAccessException e) {
            throw new ResultException("Error while adding the Results: " + e.getMessage());
        }
    }

    @Override
    public List<ResultDTO> getAllResults() throws ResultException {
        try {
            List<Result> results = resultRepository.findAll();
            return results.stream()
                    .map(ResultMapper::convertToDto)
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new ResultException("Error while retrieving the Results: " + e.getMessage());
        }
    }
}
