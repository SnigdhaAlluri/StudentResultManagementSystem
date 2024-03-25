package com.example.studentresultmanagementsystem.service;

import com.example.studentresultmanagementsystem.dto.CourseDTO;
import com.example.studentresultmanagementsystem.exception.CourseException;
import com.example.studentresultmanagementsystem.mapper.CourseMapper;
import com.example.studentresultmanagementsystem.repository.CourseRepository;
import com.example.studentresultmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.example.studentresultmanagementsystem.model.Course;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDTO createCourse(Course course) throws CourseException {
        try {
            return CourseMapper.convertToDTO(courseRepository.save(course));
        } catch (DataAccessException e) {
            throw new CourseException("Error while retrieving adding new course to database" + e.getCause());
        }
    }

    @Override
    public List<CourseDTO> getAllCourses() throws CourseException {
        try {
            return courseRepository.findAll().stream().map(CourseMapper::convertToDTO).collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new CourseException("Error while retrieving courses from database" + e.getCause());
        }
    }

    @Override
    public void deleteCourse(Long id) throws CourseException {
        try {
            courseRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new CourseException("Error while retrieving deleting course from database" + e.getCause());
        }
    }
}
