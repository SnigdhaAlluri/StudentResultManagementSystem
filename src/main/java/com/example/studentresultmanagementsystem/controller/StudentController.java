package com.example.studentresultmanagementsystem.controller;

import com.example.studentresultmanagementsystem.dto.StudentDTO;
import com.example.studentresultmanagementsystem.exception.StudentException;
import com.example.studentresultmanagementsystem.exception.StudentNotFoundException;
import com.example.studentresultmanagementsystem.mapper.StudentMapper;
import com.example.studentresultmanagementsystem.model.Student;
import com.example.studentresultmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getStudents")
    public ResponseEntity<List<StudentDTO>> getAllStudents() throws StudentException {
        List<StudentDTO> studentDTOs = studentService.getAllStudents();
        return new ResponseEntity<>(studentDTOs, HttpStatus.OK);
    }

    // Create a new student
    @PostMapping("/addStudent")
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDTO) throws StudentException {
        return new ResponseEntity<>(studentService.createStudent(StudentMapper.convertToEntity(studentDTO)), HttpStatus.CREATED);

    }


    // Delete a student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) throws StudentNotFoundException, StudentException {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}