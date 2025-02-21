package io.rapidw.utils.vo.spring;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class StringToLocalTimeConverter implements Converter<String, LocalTime> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public LocalTime convert(String source) {
        try {
            return LocalTime.parse(source, DATE_TIME_FORMATTER);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format. Expected HH:mm:ss", e);
        }
    }
}
