package com.example.studentresultmanagementsystem.controller;
import com.example.studentresultmanagementsystem.dto.StudentDTO;
import com.example.studentresultmanagementsystem.exception.StudentException;
import com.example.studentresultmanagementsystem.exception.StudentNotFoundException;
import com.example.studentresultmanagementsystem.mapper.StudentMapper;
import com.example.studentresultmanagementsystem.model.Student;
import com.example.studentresultmanagementsystem.repository.StudentRepository;
import com.example.studentresultmanagementsystem.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllStudents() throws StudentException {
        // Given
        List<StudentDTO> expectedDTOs = new ArrayList<>();
        when(studentService.getAllStudents()).thenReturn(expectedDTOs);

        // When
        ResponseEntity<List<StudentDTO>> response = studentController.getAllStudents();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedDTOs, response.getBody());
    }
    @Test
    void testCreateStudent() throws StudentException {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName("John");
        studentDTO.setLastName("Doe");
        studentDTO.setDateOfBirth(LocalDate.of(2000, 1, 1));
        studentDTO.setEmail("john@example.com");
        Student student = StudentMapper.convertToEntity(studentDTO);
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        when(studentService.createStudent(any(Student.class))).thenReturn(studentDTO);
        ResponseEntity<StudentDTO> response = studentController.createStudent(studentDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        assertNotNull(response.getBody());
        assertEquals(studentDTO.getFirstName(), response.getBody().getFirstName());
        assertEquals(studentDTO.getLastName(), response.getBody().getLastName());
        assertEquals(studentDTO.getDateOfBirth(), response.getBody().getDateOfBirth());
        assertEquals(studentDTO.getEmail(), response.getBody().getEmail());
    }


    @Test
    void testDeleteStudent() throws StudentNotFoundException, StudentException {
        // Given
        long id = 123L;

        // When
        ResponseEntity<Void> response = studentController.deleteStudent(id);

        // Then
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(studentService, times(1)).deleteStudent(id);
    }
}
