package com.example.studentresultmanagementsystem.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.studentresultmanagementsystem.dto.StudentDTO;
import com.example.studentresultmanagementsystem.model.Student;

import java.time.LocalDate;

public class StudentMapperTest {

    @Test
    public void testConvertToEntity() {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName("John");
        studentDTO.setLastName("Doe");
        studentDTO.setDateOfBirth(LocalDate.of(1990, 1, 1));
        studentDTO.setEmail("john.doe@example.com");
        Student student = StudentMapper.convertToEntity(studentDTO);

        assertEquals(studentDTO.getFirstName(), student.getFirstName());
        assertEquals(studentDTO.getLastName(), student.getLastName());
        assertEquals(studentDTO.getDateOfBirth(), student.getDateOfBirth());
        assertEquals(studentDTO.getEmail(), student.getEmail());
    }

    @Test
    public void testConvertToDTO() {

        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Smith");
        student.setDateOfBirth(LocalDate.of(2017, 4, 14));
        student.setEmail("jane.smith@example.com");

        StudentDTO studentDTO = StudentMapper.convertToDTO(student);

        assertEquals(student.getFirstName(), studentDTO.getFirstName());
        assertEquals(student.getLastName(), studentDTO.getLastName());
        assertEquals(student.getDateOfBirth(), studentDTO.getDateOfBirth());
        assertEquals(student.getEmail(), studentDTO.getEmail());
    }
}
