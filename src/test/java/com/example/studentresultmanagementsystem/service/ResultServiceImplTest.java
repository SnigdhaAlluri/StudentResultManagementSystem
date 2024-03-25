package com.example.studentresultmanagementsystem.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.example.studentresultmanagementsystem.dto.ResultDTO;
import com.example.studentresultmanagementsystem.exception.ResultException;
import com.example.studentresultmanagementsystem.mapper.ResultMapper;
import com.example.studentresultmanagementsystem.model.Result;
import com.example.studentresultmanagementsystem.repository.ResultRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ResultServiceImplTest {

    @Mock
    private ResultRepository resultRepository;

    @InjectMocks
    private ResultServiceImpl resultService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddResult() throws ResultException {
        // Create a mock result
        Result mockResult = new Result();
        mockResult.setCourseName("JAVA");
        mockResult.setStudentName("John Doe");
        mockResult.setScore("A");
        when(resultRepository.save(any(Result.class))).thenReturn(mockResult);

        ResultDTO resultDTO = resultService.addResult(mockResult);

        assertEquals(mockResult.getCourseName(), resultDTO.getCourseName());
        assertEquals(mockResult.getStudentName(), resultDTO.getStudentName());
        assertEquals(mockResult.getScore(), resultDTO.getScore());
    }

    @Test
    public void testGetAllResults() throws ResultException {
        List<Result> mockResults = new ArrayList<>();
        Result result = new Result();
        result.setCourseName("Python");
        result.setStudentName("Jane");
        result.setScore("C");
        Result result1 = new Result();
        result1.setCourseName("Python");
        result1.setStudentName("Jane");
        result1.setScore("C");
        mockResults.add(result);
        mockResults.add(result1);


        when(resultRepository.findAll()).thenReturn(mockResults);


        List<ResultDTO> resultDTOList = resultService.getAllResults();

        assertEquals(mockResults.size(), resultDTOList.size());

    }
}
