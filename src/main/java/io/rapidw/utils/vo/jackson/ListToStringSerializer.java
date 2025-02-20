package io.rapidw.utils.vo.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ListToStringSerializer extends JsonSerializer<List<String>> {

    @Override
    public void serialize(List<String> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(String.join(",", value));
    }
}
