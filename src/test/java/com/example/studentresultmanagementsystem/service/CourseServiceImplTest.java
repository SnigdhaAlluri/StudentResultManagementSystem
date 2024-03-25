package com.example.studentresultmanagementsystem.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.studentresultmanagementsystem.dto.CourseDTO;
import com.example.studentresultmanagementsystem.exception.CourseException;
import com.example.studentresultmanagementsystem.model.Course;
import com.example.studentresultmanagementsystem.repository.CourseRepository;

public class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCourse() throws CourseException {

        Course mockCourse = new Course();
        mockCourse.setId(1L);
        mockCourse.setCourseName("Math");

        when(courseRepository.save(any(Course.class))).thenReturn(mockCourse);

        CourseDTO courseDTO = courseService.createCourse(mockCourse);

        assertEquals(mockCourse.getCourseName(), courseDTO.getCourseName());

    }

    @Test
    public void testGetAllCourses() throws CourseException {

        List<Course> mockCourses = new ArrayList<>();
        Course course = new Course();
        course.setCourseName("Java");
        course.setId(125143L);
        Course course1 = new Course();
        course1.setId(531126L);
        course.setCourseName("Python");
        mockCourses.add(course);
        mockCourses.add(course1);
        when(courseRepository.findAll()).thenReturn(mockCourses);

        List<CourseDTO> courseDTOList = courseService.getAllCourses();

        assertEquals(mockCourses.size(), courseDTOList.size());
    }

    @Test
    public void testDeleteCourse() throws CourseException {
        Long courseId = 1L;
        courseService.deleteCourse(courseId);
        verify(courseRepository, times(1)).deleteById(courseId);
    }
}
