package com.example.studentresultmanagementsystem.service;

import com.example.studentresultmanagementsystem.dto.CourseDTO;
import com.example.studentresultmanagementsystem.exception.CourseException;
import com.example.studentresultmanagementsystem.model.Course;

import java.util.List;

public interface CourseService {
    public CourseDTO createCourse(Course course) throws CourseException;
    public List<CourseDTO> getAllCourses() throws CourseException;
    public void deleteCourse(Long id) throws CourseException;
}
