package org.example.homework002.service.impl;

import org.example.homework002.model.entity.Instructor;
import org.example.homework002.model.request.InstructorRequest;
import org.example.homework002.repository.InstructorRepository;
import org.example.homework002.service.InstructorService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class InstructorImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructor(Integer page, Integer size) {
        Integer offset = size * (page - 1);
        return instructorRepository.getAllInstructor(offset, size);
    }

    @Override
    public Instructor getInstructorById(Long instructorId) {
        return instructorRepository.getInstructorById(instructorId);
    }

    @Override
    public Instructor saveInstructor(InstructorRequest request) {
        return instructorRepository.saveInstructor(request);
    }

    @Override
    public Instructor putByInstructorId(Long instructorId, InstructorRequest request) {
        return instructorRepository.putByInstructorId(instructorId, request);
    }

    @Override
    public Instructor deleteById(Long instructorId) {
        return instructorRepository.deleteById(instructorId);
    }


}
