package com.example.studentresultmanagementsystem.controller;

import com.example.studentresultmanagementsystem.dto.CourseDTO;
import com.example.studentresultmanagementsystem.exception.CourseException;
import com.example.studentresultmanagementsystem.mapper.CourseMapper;
import com.example.studentresultmanagementsystem.model.Course;
import com.example.studentresultmanagementsystem.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping("/addCourse")
    public ResponseEntity<CourseDTO> createCourse(@Valid @RequestBody CourseDTO courseDto) throws CourseException {

        return new ResponseEntity<>(courseService.createCourse(CourseMapper.convertToEntity(courseDto)), HttpStatus.CREATED);
    }

    @GetMapping("/getCourses")
    public ResponseEntity<List<CourseDTO>> getAllCourses() throws CourseException {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) throws CourseException {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}