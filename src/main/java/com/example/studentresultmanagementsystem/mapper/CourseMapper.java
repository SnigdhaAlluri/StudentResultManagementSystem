package com.example.studentresultmanagementsystem.mapper;

import com.example.studentresultmanagementsystem.dto.CourseDTO;
import com.example.studentresultmanagementsystem.model.Course;

public class CourseMapper {
    public static CourseDTO convertToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName(course.getCourseName());
        return courseDTO;
    }

    public static Course convertToEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        return course;
    }
}
