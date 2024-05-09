package io.github.moudjames23.paycard4j.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtils() {
    }

    /**
     * Converts JSON to an object of the specified class.
     *
     * @param json  The JSON to convert.
     * @param clazz The class to map the JSON to.
     * @param <T>   The generic type.
     * @return An instance of the specified class with data from the JSON.
     * @throws JsonProcessingException if mapping the JSON to the object fails.
     */
    public static <T> T getObjectFromJsonString(String json, Class<T> clazz) throws JsonProcessingException {
        return objectMapper.readValue(json, clazz);
    }


}
