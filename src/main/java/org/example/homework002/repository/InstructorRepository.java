package org.example.homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework002.model.entity.Instructor;
import org.example.homework002.model.request.InstructorRequest;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Results(
            id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "name", column = "instructor_name")
            }
    )

    @Select("""
            select * from instructors offset #{offset} limit #{size}
            """)
    List<Instructor> getAllInstructor(Integer offset, Integer size);

    @Select("""
                select * from instructors where instructor_id = #{instructorId};
            """)
    @ResultMap("instructorMapper")
    Instructor getInstructorById(Long instructorId);

    @ResultMap("instructorMapper")
    @Select("""
                INSERT INTO instructors VALUES (default, #{req.name}, #{req.email}) RETURNING *;
            """)
    Instructor saveInstructor(@Param("req") InstructorRequest request);

    @ResultMap("instructorMapper")
    @Select("""
        UPDATE instructors SET instructor_name = #{req.name}, email = #{req.email}
        WHERE instructor_id = #{instructorId} RETURNING *;
    """)
    Instructor putByInstructorId(Long instructorId, @Param("req") InstructorRequest request);


    @ResultMap("instructorMapper")
    @Select("""
        DELETE FROM instructors WHERE instructor_id = #{instructorId};
    """)
    void deleteById(Long instructorId);
}
