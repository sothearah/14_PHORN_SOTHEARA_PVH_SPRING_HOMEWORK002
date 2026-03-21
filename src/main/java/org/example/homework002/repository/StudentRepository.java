package org.example.homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework002.model.entity.Student;
import org.example.homework002.model.request.StudentRequest;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Results(
            id = "studentMapper", value = {
//            @Result(property = "courseName", column = "course_name"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "course", column = "student_id",
                    many = @Many(select = "org.example.homework002.repository.StudentCourseRepository.getCourseById"))
    }
    )

    @Select("""
                select * from students offset #{offset} limit #{size}
            """)
    List<Student> getAllStudent(Integer offset, Integer size);

    @ResultMap("studentMapper")
    @Select("""
        SELECT * FROM students WHERE student_id = #{studentId}
    """)
    Student getStudentById(Long studentId);

    @ResultMap("studentMapper")
    @Select("""
                INSERT INTO students VALUES (default,#{req.studentName}, #{req.email}, #{req.phoneNumber}) RETURNING *;
            """)
    Student saveStudent(@Param("req") StudentRequest request);

    @ResultMap("studentMapper")
    @Select("""
                UPDATE students SET student_name = #{req.studentName},email = #{req.email}, phone_number = #{req.phoneNumber} WHERE student_id = #{studentId} RETURNING *;
            """)
    Student updateStudentByID(Long studentId, @Param("req") StudentRequest request);

    @ResultMap("studentMapper")
    @Select("""
                DELETE FROM students WHERE student_id = #{studentId};
            """)
    Student deleteStudentById(Long studentId);

}
