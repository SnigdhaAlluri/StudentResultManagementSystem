package com.example.studentresultmanagementsystem.service;

import com.example.studentresultmanagementsystem.dto.StudentDTO;
import com.example.studentresultmanagementsystem.exception.ResourceNotFoundException;
import com.example.studentresultmanagementsystem.exception.StudentException;
import com.example.studentresultmanagementsystem.exception.StudentNotFoundException;
import com.example.studentresultmanagementsystem.mapper.StudentMapper;
import com.example.studentresultmanagementsystem.model.Student;
import com.example.studentresultmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents() throws StudentException {
        try {
            List<Student> students = studentRepository.findAll();
            return students.stream()
                    .map(StudentMapper::convertToDTO)
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new StudentException("Error while retrieving the Students: " + e.getMessage());
        }
    }

    @Override
    public StudentDTO createStudent(Student student) throws StudentException {
        try {
            return StudentMapper.convertToDTO(studentRepository.save(student));
        } catch (DataAccessException e) {
            throw new StudentException("Error while Adding the Student " + e.getCause());
        }
    }


    @Override
    public void deleteStudent(Long id) throws StudentNotFoundException, StudentException {
        try {
            if (!studentRepository.existsById(id)) {
                throw new StudentNotFoundException("Student with ID " + id + " not found");
            }
            studentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        } catch (DataAccessException e) {
            throw new StudentException("Error while deleting student: " + e.getMessage());
        }
    }
}
