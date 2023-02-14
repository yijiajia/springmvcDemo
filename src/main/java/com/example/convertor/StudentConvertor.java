package com.example.convertor;

import com.example.model.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Java 配置暂未实现
 */
public class StudentConvertor implements Converter<String, Student> {

    @Override
    public Student convert(String source) {

        if(null == source || source.isEmpty()) {
            return null;
        }
        String[] strings = source.split("-");
        if(strings.length != 3) {
            return null;
        }

        Student student = new Student();
        student.setSid(Integer.parseInt(strings[0]));
        student.setAge(Integer.parseInt(strings[1]));
        student.setName(strings[2]);


        return student;
    }
}

