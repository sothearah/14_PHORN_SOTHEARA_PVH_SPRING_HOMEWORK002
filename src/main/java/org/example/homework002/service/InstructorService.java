package org.example.homework002.service;

import org.example.homework002.model.entity.Instructor;
import org.example.homework002.model.request.InstructorRequest;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructor(Integer page, Integer size);

    Instructor getInstructorById(Long instructorId);


    Instructor saveInstructor(InstructorRequest request);


    Instructor putByInstructorId(Long instructorId, InstructorRequest request);

    void deleteById(Long instructorId);
}
