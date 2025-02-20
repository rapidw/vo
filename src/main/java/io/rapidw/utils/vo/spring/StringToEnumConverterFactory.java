package io.rapidw.utils.vo.spring;

import io.rapidw.utils.vo.mybatis.BaseEnum;
import org.springframework.core.convert.converter.ConverterFactory;

public class StringToEnumConverterFactory implements ConverterFactory<String, BaseEnum> {
    @Override
    public <T extends BaseEnum> org.springframework.core.convert.converter.Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToEnumConverter<>(targetType);
    }

    private static class StringToEnumConverter<T extends BaseEnum> implements org.springframework.core.convert.converter.Converter<String, T> {
        private final Class<T> enumType;

        public StringToEnumConverter(Class<T> enumType) {
            this.enumType = enumType;
        }

        @Override
        public T convert(String source) {
            if (source.isEmpty()) {
                return null;
            }
            for (T t : this.enumType.getEnumConstants()) {
                if (t.getDescription().equals(source)) {
                    return t;
                }
            }
            return null;
        }
    }
}
