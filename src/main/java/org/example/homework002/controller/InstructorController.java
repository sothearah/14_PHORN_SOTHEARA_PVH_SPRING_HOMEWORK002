package org.example.homework002.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.example.homework002.model.entity.Instructor;
import org.example.homework002.model.request.InstructorRequest;
import org.example.homework002.model.response.ApiResponse;
import org.example.homework002.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService){
        this.instructorService = instructorService;

    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructor(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        ApiResponse<List<Instructor>> apiResponse = ApiResponse.<List<Instructor>>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Instructors fetched successfully")
                .payload(instructorService.getAllInstructor(page, size))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{instructor_id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable("instructor_id") Long instructorId) {
        ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Instructor fetched successfully")
                .payload(instructorService.getInstructorById(instructorId))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> saveInstructor(@RequestBody InstructorRequest request) {
        ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Instructor created successfully")
                .payload(instructorService.saveInstructor(request))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/{instructor_id}")
    public ResponseEntity<ApiResponse<Instructor>> putByInstructorId(@PathVariable("instructor_id") Long instructorId, @org.springframework.web.bind.annotation.RequestBody InstructorRequest request) {
        ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Instructor updated successfully")
                .payload(instructorService.putByInstructorId(instructorId, request))
                .timestamp(Instant.now())
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
