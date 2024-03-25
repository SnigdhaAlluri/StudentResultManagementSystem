package com.example.studentresultmanagementsystem.mapper;

import com.example.studentresultmanagementsystem.dto.StudentDTO;
import com.example.studentresultmanagementsystem.model.Student;

public class StudentMapper {
    public static Student convertToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        student.setEmail(studentDTO.getEmail());
        return student;
    }

    public static StudentDTO convertToDTO(Student student) {
        StudentDTO studentDto = new StudentDTO();

        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setDateOfBirth(student.getDateOfBirth());
        studentDto.setEmail(student.getEmail());
        return studentDto;
    }
}
