package com.example.studentresultmanagementsystem.controller;

import com.example.studentresultmanagementsystem.dto.ResultDTO;
import com.example.studentresultmanagementsystem.exception.ResultException;
import com.example.studentresultmanagementsystem.mapper.ResultMapper;
import com.example.studentresultmanagementsystem.model.Result;
import com.example.studentresultmanagementsystem.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@CrossOrigin
public class ResultController {
    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping("/addResult")
    public ResponseEntity<ResultDTO> addResult(@RequestBody ResultDTO result) throws ResultException {
        System.out.println("Result" + result.toString());
        return new ResponseEntity<>(resultService.addResult(ResultMapper.convertToEntity(result)), HttpStatus.CREATED);
    }

    @GetMapping("/getAllResults")
    public ResponseEntity<List<ResultDTO>> getAllResults() throws ResultException {
        return new ResponseEntity<>(resultService.getAllResults(), HttpStatus.OK);
    }
}
