package com.example.studentresultmanagementsystem.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.studentresultmanagementsystem.dto.CourseDTO;
import com.example.studentresultmanagementsystem.model.Course;

public class CourseMapperTest {

    @Test
    public void testConvertToDTO() {

        Course course = new Course();
        course.setCourseName("Java");
        CourseDTO courseDTO = CourseMapper.convertToDTO(course);
        assertEquals(course.getCourseName(), courseDTO.getCourseName());
    }

    @Test
    public void testConvertToEntity() {

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName("DBMS");
        Course course = CourseMapper.convertToEntity(courseDTO);
        assertEquals(courseDTO.getCourseName(), course.getCourseName());
    }
}