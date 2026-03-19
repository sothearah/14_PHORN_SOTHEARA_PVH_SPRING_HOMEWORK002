package org.example.homework002.service.impl;

import org.example.homework002.model.entity.Course;
import org.example.homework002.model.request.CourseRequest;
import org.example.homework002.repository.CourseRepository;
import org.example.homework002.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse(Integer page, Integer size) {
        int offset = size * (page - 1);
        return courseRepository.getAllCourse(offset, size);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public Course saveCourse(CourseRequest request) {
        return courseRepository.saveCourse(request);
    }

    @Override
    public Course updateById(Long courseId, CourseRequest request) {
        return courseRepository.updateById(courseId, request);
    }

    @Override
    public void deleteById(Long courseId) {
        courseRepository.deleteById(courseId);
    }

}
