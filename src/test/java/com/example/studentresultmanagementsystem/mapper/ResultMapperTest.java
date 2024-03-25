package com.example.studentresultmanagementsystem.mapper;

import com.example.studentresultmanagementsystem.dto.ResultDTO;
import com.example.studentresultmanagementsystem.model.Result;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResultMapperTest {

        @Test
        public void testConvertToEntity() {

            ResultDTO resultDTO = new ResultDTO();
            resultDTO.setCourseName("JAVA");
            resultDTO.setStudentName("John Doe");
            resultDTO.setScore("A");

            Result result = ResultMapper.convertToEntity(resultDTO);

            assertEquals(resultDTO.getCourseName(), result.getCourseName());
            assertEquals(resultDTO.getStudentName(), result.getStudentName());
            assertEquals(resultDTO.getScore(), result.getScore());
        }

        @Test
        public void testConvertToDto() {

            Result result = new Result();
            result.setCourseName("Python");
            result.setStudentName("Jane");
            result.setScore("C");
            ResultDTO resultDTO = ResultMapper.convertToDto(result);
            assertEquals(result.getCourseName(), resultDTO.getCourseName());
            assertEquals(result.getStudentName(), resultDTO.getStudentName());
            assertEquals(result.getScore(), resultDTO.getScore());
        }
    }
