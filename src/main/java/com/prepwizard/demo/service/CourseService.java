package com.prepwizard.demo.service;

import com.prepwizard.demo.entity.Course;
import com.prepwizard.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

    @RequiredArgsConstructor
    @Service
    public class CourseService {

        private final CourseRepository courseRepository;


        public List<Course> getAllCourses() {
            return courseRepository.findAll();
        }

        public Course getCourseById(UUID id) {
            return courseRepository.findById(id).orElse(null);
        }

        public Course createCourse(Course course) {
            return courseRepository.save(course);
        }

//        public Course updateCourse(UUID id, Course updatedCourse) {return null;}
//        Course existingCourse = courseRepository.findById(id).orElse(null);
//        if (existingCourse != null) {
//            existingCourse.setCourse_name(updatedCourse.getCourse_name());
//            existingCourse.setDescription(updatedCourse.getDescription());
//            existingCourse.setP_link(updatedCourse.getP_link());
//            existingCourse.setPrice(updatedCourse.getPrice());
//            existingCourse.setInstructor(updatedCourse.getInstructor());
//            existingCourse.setY_link(updatedCourse.getY_link());
//            return courseRepository.save(existingCourse);
//        }
//        return null;
//    }

        public void deleteCourse(UUID id) {
            courseRepository.deleteById(id);
        }
    }

