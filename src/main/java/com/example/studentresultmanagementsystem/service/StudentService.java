package com.example.studentresultmanagementsystem.service;

import com.example.studentresultmanagementsystem.dto.StudentDTO;
import com.example.studentresultmanagementsystem.exception.StudentException;
import com.example.studentresultmanagementsystem.exception.StudentNotFoundException;
import com.example.studentresultmanagementsystem.model.Student;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents() throws StudentException;

    StudentDTO createStudent(Student student) throws StudentException;

    void deleteStudent(Long id) throws StudentNotFoundException,StudentException;
}
