package io.rapidw.utils.vo.spring;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class StringToLocalDateConverter implements Converter<String, LocalDate> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate convert(String source) {
        try {
            return LocalDate.parse(source, DATE_TIME_FORMATTER);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format. Expected yyyy-MM-dd", e);
        }
    }
}
