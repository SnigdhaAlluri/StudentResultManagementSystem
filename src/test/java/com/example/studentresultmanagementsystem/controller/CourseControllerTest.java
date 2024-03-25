package com.example.studentresultmanagementsystem.controller;

import com.example.studentresultmanagementsystem.dto.CourseDTO;
import com.example.studentresultmanagementsystem.exception.CourseException;
import com.example.studentresultmanagementsystem.mapper.CourseMapper;
import com.example.studentresultmanagementsystem.model.Course;
import com.example.studentresultmanagementsystem.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseControllerTest {

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    @Test
    void testCreateCourse() throws CourseException {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName("Math");
        when(courseService.createCourse(any(Course.class))).thenReturn(courseDTO);

        ResponseEntity<CourseDTO> response = courseController.createCourse(courseDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(courseDTO, response.getBody());
        verify(courseService, times(1)).createCourse(any(Course.class));
    }

    @Test
    void testGetAllCourses() throws CourseException {

        List<CourseDTO> courseDTOList = new ArrayList<>();
        CourseDTO courseDTO1 = new CourseDTO();
        courseDTO1.setCourseName("Math");
        CourseDTO courseDTO2 = new CourseDTO();
        courseDTO2.setCourseName("Science");
        courseDTOList.add(courseDTO1);
        courseDTOList.add(courseDTO2);
        when(courseService.getAllCourses()).thenReturn(courseDTOList);

        ResponseEntity<List<CourseDTO>> response = courseController.getAllCourses();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(courseDTOList, response.getBody());
        verify(courseService, times(1)).getAllCourses();
    }

    @Test
    void testDeleteCourse() throws CourseException {

        ResponseEntity<Void> response = courseController.deleteCourse(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(courseService, times(1)).deleteCourse(1L);
    }
}
