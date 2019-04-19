package com.bushlife.demo;

import static java.text.MessageFormat.format;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class JacksonTestDataLoader {

  /**
   * Load a json file as the specified object.
   * NOTE: the files to be used should be located in a test/resoures/{TestClassName}/{resourceName}.
   *
   * @param testClass    the test class, used to derive the folder to search for the resourceName.
   * @param resourceName the name of the Json file to read the payload from
   * @param resultType   the type of object to convert the class to
   * @param <T>          the type of the return object
   * @return the converted object
   */
  public static <T> T readJson(Class testClass, String resourceName, Class<T> resultType) {
    String resource = testClass.getSimpleName() + File.separator + resourceName;
    ClassLoader classLoader = testClass.getClassLoader();

    try (InputStream input = classLoader.getResourceAsStream(resource)) {
      ObjectMapper objectMapper = buildObjectMapper();
      return objectMapper.readValue(input, resultType);
    } catch (JsonParseException e) {
      e.printStackTrace();
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    throw new RuntimeException(format("Could not load Json file {0}", resource));
  }

  /**
   * Configure the jackson object mapToPaymentMethod with the configuration used by the main application.
   *
   * @return the object mapToPaymentMethod instance
   */
  private static ObjectMapper buildObjectMapper() {
    return objectMapper();
  }

  static ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();

    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
    objectMapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

//    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//    objectMapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

    return objectMapper;
  }

}
