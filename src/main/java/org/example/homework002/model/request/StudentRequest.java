package org.example.homework002.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.homework002.model.entity.Course;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Long> courseId;
}
