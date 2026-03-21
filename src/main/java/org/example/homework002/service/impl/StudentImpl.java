package org.example.homework002.service.impl;

import org.example.homework002.model.entity.Student;
import org.example.homework002.model.request.StudentRequest;
import org.example.homework002.repository.StudentCourseRepository;
import org.example.homework002.repository.StudentRepository;
import org.example.homework002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    public StudentImpl(StudentRepository studentRepository, StudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public List<Student> getAllStudent(Integer page, Integer size) {
        Integer offset = size * (page - 1);
        return studentRepository.getAllStudent(offset, size);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Student saveStudent(StudentRequest request) {

        Student student = studentRepository.saveStudent(request);

        for (Long courseId : request.getCourseId()) {
            studentCourseRepository.insertStudentCourse(student.getStudentId(), courseId);
        }
        return studentRepository.getStudentById(student.getStudentId());
//        return studentRepository.saveStudent(request);
    }

    @Override
    public Student updateStudentById(Long studentId, StudentRequest request) {

        Student student = studentRepository.updateStudentByID(studentId, request);

        studentCourseRepository.deleteStudentCourseByStudentID(studentId);
        for (Long courseId : request.getCourseId()) {
            studentCourseRepository.insertStudentCourse(student.getStudentId(), courseId);
        }
        return studentRepository.getStudentById(student.getStudentId());
    }

    @Override
    public Student deleteStudentById(Long studentId) {

        studentRepository.deleteStudentById(studentId);


        studentCourseRepository.deleteStudentCourseByStudentID(studentId);

        return studentRepository.deleteStudentById(studentId);

    }
}
