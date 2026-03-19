package org.example.homework002.service;

import org.example.homework002.model.entity.Course;
import org.example.homework002.model.request.CourseRequest;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourse(Integer size, Integer page);

    Course getCourseById(Long courseId);

    Course saveCourse(CourseRequest request);

    Course updateById(Long courseId, CourseRequest request);

    void deleteById(Long courseId);
}
