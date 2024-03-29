package no.nav.academy.exapp.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JacksonUtil {

    private static final Logger LOG = LoggerFactory.getLogger(JacksonUtil.class);

    private final ObjectMapper mapper;

    public JacksonUtil(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public <T> T convertTo(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            return null;
            // throw new UnexpectedInputException("Kunne ikke rekonstuere melding fra %s til
            // %s", e, json, clazz);
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [mapper=" + mapper + "]";
    }
}
