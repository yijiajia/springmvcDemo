package com.example.service.impl;

import com.example.mapper.StudentMapper;
import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(int id) {
        return studentMapper.getStudentById(id);
    }
}
