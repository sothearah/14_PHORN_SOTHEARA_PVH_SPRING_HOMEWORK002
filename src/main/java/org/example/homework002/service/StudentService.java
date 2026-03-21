package org.example.homework002.service;

import org.example.homework002.model.entity.Student;
import org.example.homework002.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent(Integer page, Integer size);

    Student getStudentById(Long studentId);

    Student saveStudent(StudentRequest request);

    Student updateStudentById(Long studentId, StudentRequest request);

    Student deleteStudentById(Long studentId);
}
