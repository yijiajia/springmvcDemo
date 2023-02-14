package com.example.mapper;

import com.example.model.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    Student getStudentById(int id);
}
