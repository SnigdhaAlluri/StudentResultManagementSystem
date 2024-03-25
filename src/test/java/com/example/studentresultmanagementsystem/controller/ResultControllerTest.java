package com.example.studentresultmanagementsystem.controller;

import com.example.studentresultmanagementsystem.dto.ResultDTO;
import com.example.studentresultmanagementsystem.exception.ResultException;
import com.example.studentresultmanagementsystem.model.Result;
import com.example.studentresultmanagementsystem.service.ResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ResultControllerTest {

    @Mock
    private ResultService resultService;

    @InjectMocks
    private ResultController resultController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddResult() throws ResultException {

        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCourseName("Math");
        resultDTO.setStudentName("John Doe");
        resultDTO.setScore("A");
        when(resultService.addResult(any(Result.class))).thenReturn(resultDTO);

        ResponseEntity<ResultDTO> response = resultController.addResult(resultDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        assertNotNull(response.getBody());
        assertEquals(resultDTO, response.getBody());
        verify(resultService, times(1)).addResult(any(Result.class));
    }

    @Test
    void testGetAllResults() throws ResultException {
        List<ResultDTO> resultDTOList = new ArrayList<>();
        ResultDTO resultDTO1 = new ResultDTO();
        resultDTO1.setCourseName("Math");
        resultDTO1.setStudentName("John Doe");
        resultDTO1.setScore("A");
        resultDTOList.add(resultDTO1);

        ResultDTO resultDTO2 = new ResultDTO();
        resultDTO2.setCourseName("Science");
        resultDTO2.setStudentName("Alice Smith");
        resultDTO2.setScore("B");
        resultDTOList.add(resultDTO2);

        when(resultService.getAllResults()).thenReturn(resultDTOList);

        ResponseEntity<List<ResultDTO>> response = resultController.getAllResults();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(resultDTOList, response.getBody());

        verify(resultService, times(1)).getAllResults();
    }
}
