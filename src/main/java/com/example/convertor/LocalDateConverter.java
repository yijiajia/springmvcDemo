package com.example.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 时间格式化
 */
public class LocalDateConverter implements Converter<String, LocalDate> {

    private String datePattern;

    public LocalDateConverter(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public LocalDate convert(String source) {
        System.out.println("converter string to LocalDate");
        return LocalDate.parse(source, DateTimeFormatter.ofPattern(datePattern));
    }
}
