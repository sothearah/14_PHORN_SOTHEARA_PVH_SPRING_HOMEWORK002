package org.example.homework002.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data

@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {
    private String name;
    private String email;

}
