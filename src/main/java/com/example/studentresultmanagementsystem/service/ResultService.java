package com.example.studentresultmanagementsystem.service;

import com.example.studentresultmanagementsystem.dto.ResultDTO;
import com.example.studentresultmanagementsystem.exception.ResultException;
import com.example.studentresultmanagementsystem.model.Result;

import java.util.List;

public interface ResultService {
    public ResultDTO addResult(Result result) throws ResultException;
    public List<ResultDTO> getAllResults() throws ResultException;
}
