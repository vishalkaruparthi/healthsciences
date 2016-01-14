
package com.healthsciences.services.web.dto.mappers;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.joda.time.LocalDateTime;

/**
 * Json mapper for DateTime formatting
 */
public class JsonMapper extends ObjectMapper {

    /**
     * The Constructor.
     * 
     * @throws FileNotFoundException
     *             the file not found exception
     * @throws IOException
     *             the IO exception
     */
    public JsonMapper() throws FileNotFoundException, IOException {
        super();
        SimpleModule module = new SimpleModule("JsonModule", new Version(2, 0,
                0, null));
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class,
                new LocalDateTimeDeserializer());
        registerModule(module);
    }
}
