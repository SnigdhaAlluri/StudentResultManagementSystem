package com.example.studentresultmanagementsystem.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.studentresultmanagementsystem.dto.StudentDTO;
import com.example.studentresultmanagementsystem.exception.StudentException;
import com.example.studentresultmanagementsystem.exception.StudentNotFoundException;
import com.example.studentresultmanagementsystem.model.Student;
import com.example.studentresultmanagementsystem.repository.StudentRepository;

import org.junit.Before;
import org.junit.Test;

public class StudentServiceImplTest {

    private StudentRepository studentRepositoryMock;
    private StudentServiceImpl studentService;

    @Before
    public void setUp() {
        studentRepositoryMock = mock(StudentRepository.class);
        studentService = new StudentServiceImpl(studentRepositoryMock);
    }

    @Test
    public void testGetAllStudents_Success() throws StudentException {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        Student student1 = new Student();
        student.setFirstName("Jane");
        student.setLastName("Smith");
        student.setDateOfBirth(LocalDate.of(2017, 4, 14));
        student.setEmail("jane.smith@example.com");
        student1.setFirstName("Jane");
        student1.setLastName("Smith");
        student1.setDateOfBirth(LocalDate.of(2017, 4, 14));
        student1.setEmail("jane.smith@example.com");
        students.add(student);
        students.add(student1);
        when(studentRepositoryMock.findAll()).thenReturn(students);
        List<StudentDTO> studentDTOs = studentService.getAllStudents();
        assertEquals(students.size(), studentDTOs.size());

    }


    @Test
    public void testCreateStudent_Success() throws StudentException {

        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Smith");
        student.setDateOfBirth(LocalDate.of(2017, 4, 14));
        student.setEmail("jane.smith@example.com");

        when(studentRepositoryMock.save(any(Student.class))).thenReturn(student);
        StudentDTO studentDTO = studentService.createStudent(student);
        assertEquals(student.getFirstName(), studentDTO.getFirstName());
        assertEquals(student.getLastName(), studentDTO.getLastName());
        assertEquals(student.getEmail(), studentDTO.getEmail());
    }

    @Test
    public void testDeleteStudent_Success() throws StudentNotFoundException, StudentException {

        Long studentId = 1L;
        when(studentRepositoryMock.existsById(studentId)).thenReturn(true);
        studentService.deleteStudent(studentId);
        verify(studentRepositoryMock, times(1)).deleteById(studentId);
    }

    @Test(expected = StudentNotFoundException.class)
    public void testDeleteStudent_NotFound() throws StudentNotFoundException, StudentException {
        Long studentId = 1L;
        when(studentRepositoryMock.existsById(studentId)).thenReturn(false);
        studentService.deleteStudent(studentId);
    }

}
