package org.example.homework002.controller;

import org.example.homework002.model.entity.Course;
import org.example.homework002.model.entity.Instructor;
import org.example.homework002.model.request.CourseRequest;
import org.example.homework002.model.response.ApiResponse;
import org.example.homework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourse(@RequestParam(defaultValue = "1") Integer size, @RequestParam(defaultValue =  "5") Integer page){
        ApiResponse<List<Course>> apiResponse = ApiResponse.<List<Course>>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Course created successfully")
                .payload(courseService.getAllCourse(size, page))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable("course-id") Long courseId) {
        ApiResponse<Course> apiResponse;
        Course checkId = courseService.getCourseById(courseId);

        if(!(checkId == null)) {
            apiResponse = ApiResponse.<Course>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Course fetched successfully")
                    .payload(courseService.getCourseById(courseId))
                    .timestamp(Instant.now())
                    .build();

            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            apiResponse = ApiResponse.<Course>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Course fetched failed")
                    .payload(courseService.getCourseById(courseId))
                    .timestamp(Instant.now())
                    .build();

            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> saveCourse(@RequestBody CourseRequest request) {
        ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                .success(true)
                .status(HttpStatus.CREATED)
                .message("Course created successfully")
                .payload(courseService.saveCourse(request))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    @PutMapping("/{course_id}")
    public ResponseEntity<ApiResponse<Course>> updateById(@PathVariable("course_id") Long courseId, @RequestBody CourseRequest request) {
        ApiResponse<Course> apiResponse;
        Course checkId = courseService.updateById(courseId, request);

        if(!(checkId == null)) {
            apiResponse = ApiResponse.<Course>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Course updated successfully")
                    .payload(courseService.updateById(courseId, request))
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            apiResponse = ApiResponse.<Course>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Course updated failed")
                    .payload(courseService.updateById(courseId, request))
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/{course_id}")
    public ResponseEntity<ApiResponse<Course>> deleteById(@PathVariable("course_id") Long courseId) {
        Course checkId = courseService.getCourseById(courseId);
        ApiResponse<Course> apiResponse ;

        if(!(checkId == null)) {
            courseService.deleteById(courseId);
            apiResponse = ApiResponse.<Course>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Course deleted successfully")
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            courseService.deleteById(courseId);
            apiResponse = ApiResponse.<Course>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Course deleted failed")
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }


}
