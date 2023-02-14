package com.example.convertor;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class StringToLocalDateFormatter implements Formatter<LocalDate> {

    private DateTimeFormatter formatter;
    private String datePattern;

    public StringToLocalDateFormatter(String datePattern) {
        this.datePattern = datePattern;
        this.formatter = DateTimeFormatter.ofPattern(datePattern);
    }

    /**
     * 利用指定的 Local 将一个String解析成目标类型
     */
    @Override
    public LocalDate parse(String source, Locale time) throws ParseException {
        System.out.println("StringToLocalDateFormatter converter..");
        return LocalDate.parse(source,DateTimeFormatter.ofPattern(datePattern));
    }

    @Override
    public String print(LocalDate date, Locale locale) {
        return date.format(formatter);
    }
}
