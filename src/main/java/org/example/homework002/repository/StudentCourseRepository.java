package org.example.homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework002.model.entity.Course;

import java.util.List;

@Mapper
public interface StudentCourseRepository {
    @Results(id = "StudentCourseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(
                    property = "instructor", column = "instructor_id",
                    one = @One(select = "org.example.homework002.repository.InstructorRepository.getInstructorById"))
    })

    @Select("""
                SELECT *
                FROM student_course sc
                INNER JOIN courses c
                ON sc.course_id = c.course_id
                WHERE student_id = #{studentId}
            """)
    List<Course> getCourseById(Long studentId);

    @ResultMap("StudentCourseMapper")
    @Select("""
                INSERT INTO student_course VALUES (#{studentId}, #{courseId}) returning *;
            """)
    void saveStudentCourse(Long studentId, Long courseId);

    @ResultMap("StudentCourseMapper")
    @Delete("""
            DELETE FROM student_course WHERE student_id = #{studentId};
            """)
    void deleteStudentCourseByStudentID(Long studentId);

    @Insert("""
        INSERT INTO student_course VALUES (#{studentId}, #{courseId})
    """)
    void insertStudentCourse(Long studentId, Long courseId);

}
