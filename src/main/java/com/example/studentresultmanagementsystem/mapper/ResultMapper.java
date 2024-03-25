package com.example.studentresultmanagementsystem.mapper;

import com.example.studentresultmanagementsystem.dto.ResultDTO;
import com.example.studentresultmanagementsystem.model.Result;

public class ResultMapper {
    public static Result convertToEntity(ResultDTO resultDTO) {
        Result result = new Result();
        result.setCourseName(resultDTO.getCourseName());
        result.setStudentName(resultDTO.getStudentName());
        result.setScore(resultDTO.getScore());
        return result;
    }

    public static ResultDTO convertToDto(Result result) {
        ResultDTO resultDto = new ResultDTO();
        resultDto.setCourseName(result.getCourseName());
        resultDto.setStudentName(result.getStudentName());
        resultDto.setScore(result.getScore());
        return resultDto;
    }
}
