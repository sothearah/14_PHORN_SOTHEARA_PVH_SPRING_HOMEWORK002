package org.example.homework002.service.impl;

import org.example.homework002.repository.CourseRepository;
import org.example.homework002.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
}
