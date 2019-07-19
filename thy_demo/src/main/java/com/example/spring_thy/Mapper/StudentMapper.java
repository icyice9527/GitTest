package com.example.spring_thy.Mapper;


import org.apache.ibatis.annotations.*;

import com.example.spring_thy.Entity.Students;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from students")
    List<Students> findAll();

    @Insert("insert into students(id,name,school,score) values(#{id},#{name},#{school},#{score})")
    int insertStudent(@Param("id") int id, @Param("name") String name, @Param("school") String school, @Param("score") Integer score);

//    @Insert("insert into students(id,name,school,score) values(#{student.id},#{student.name},#{student.school},#{student.score})")
//    int insertStudent(Students student);

    @Select("select * from students where id=#{id}")
    Students queryById(int id);

    @Update("update students set name=#{name},school=#{school},score=#{score} where students.id=#{id}")
    int updateStudent(@Param("id") int id, @Param("name") String name, @Param("school") String school, @Param("score") Integer score);

//    @Update("update students set name=#{student.name},school=#{student.school},score=#{student.score} where students.id=#{student.id}")
//    int updateStudent(Students student);

    @Delete("delete from students where students.id=#{id}")
    int deleteStudent(int id);
}
