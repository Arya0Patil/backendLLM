package com.prepwizard.demo.controller;

import com.prepwizard.demo.entity.Course;
import com.prepwizard.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/api/courses")
    public class CourseController {

        @Autowired
        private CourseService courseService;

        @GetMapping
        public List<Course> getAllCourses() {
            return courseService.getAllCourses();
        }

        @GetMapping("/{id}")
        public Course getCourseById(@PathVariable UUID id) {
            return courseService.getCourseById(id);
        }

        @PostMapping
        public Course createCourse(@RequestBody Course course) {
            return courseService.createCourse(course);
        }

//        @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/{id}")
        public Course updateCourse(@PathVariable UUID id, @RequestBody Course updatedCourse) {
//            return courseService.updateCourse(id, updatedCourse);
            return null;
        }

//        @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/{id}")
        public void deleteCourse(@PathVariable UUID id) {
            courseService.deleteCourse(id);
        }
    }
