package org.example.homework002.model.response;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ApiResponseInstructor<T> {
    private Boolean success;
    private HttpStatus status;
    private String message;
    private T payload;
    private Instant timestamp;
}
