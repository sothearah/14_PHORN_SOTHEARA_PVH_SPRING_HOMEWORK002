package org.example.homework002.controller;

import org.example.homework002.model.entity.Student;
import org.example.homework002.model.request.InstructorRequest;
import org.example.homework002.model.request.StudentRequest;
import org.example.homework002.model.response.ApiResponse;
import org.example.homework002.repository.StudentRepository;
import org.example.homework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudent(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        ApiResponse<List<Student>> apiResponse = ApiResponse.<List<Student>>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Student fetched successfully")
                .payload(studentService.getAllStudent(page, size))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{student_id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable("student_id") Long studentId) {
        ApiResponse<Student> apiResponse;
        Student checkid = studentService.getStudentById(studentId);
        if(!(checkid == null)) {
            apiResponse = ApiResponse.<Student>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Students fetched successfully")
                    .payload(studentService.getStudentById(studentId))
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            apiResponse = ApiResponse.<Student>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Students fetched failed")
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/{student_id}")
    public ResponseEntity<ApiResponse<Student>> saveStudent(@RequestBody StudentRequest request) {
        ApiResponse<Student> apiResponse;
        Student checkId = studentService.saveStudent(request);
        if(!(checkId == null)) {
            apiResponse = ApiResponse.<Student>builder()
                    .success(true)
                    .status(HttpStatus.CREATED)
                    .message("Students fetched successfully")
                    .payload(studentService.saveStudent(request))
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } else {
            apiResponse = ApiResponse.<Student>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Students fetched failed")
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{student_id}")
    public ResponseEntity<ApiResponse<Student>> updateStudentById (@PathVariable("student_id") Long studentId, @RequestBody StudentRequest request) {
        ApiResponse<Student> apiResponse;
        Student checkId = studentService.updateStudentById(studentId, request);
        if(!(checkId == null)) {
            apiResponse = ApiResponse.<Student>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Students Put successfully")
                    .payload(studentService.updateStudentById(studentId, request))
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } else {
            apiResponse = ApiResponse.<Student>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Students Put failed")
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{student_id}")
    public ResponseEntity<ApiResponse<Student>> deleteStudentById(@PathVariable("student_id") Long studentId) {
        ApiResponse<Student> apiResponse;
        Student checkid = studentService.deleteStudentById(studentId);

        if ((checkid == null)) {
            apiResponse = ApiResponse.<Student>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Student deleted successfully")
//                    .payload(studentService.deleteStudentById(studentId))
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            apiResponse = ApiResponse.<Student>builder()
                    .success(true)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Student deleted failed")
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }

    }

}
