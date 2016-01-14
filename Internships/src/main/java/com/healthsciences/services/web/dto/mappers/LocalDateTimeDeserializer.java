
package com.healthsciences.services.web.dto.mappers;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.healthsciences.services.facade.AppConfiguration;


public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    // This is joda-time and this class is thread-safe
    private final DateTimeFormatter dateFormatter;

    /**
     * The Constructor.
     * 
     * @throws FileNotFoundException
     *             the file not found exception
     * @throws IOException
     *             the IO exception
     */
    public LocalDateTimeDeserializer() throws FileNotFoundException,
            IOException {
        super();
        dateFormatter = DateTimeFormat.forPattern(AppConfiguration
                .getDatetimeFormat());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.codehaus.jackson.map.JsonDeserializer#deserialize(org.codehaus.jackson
     * .JsonParser, org.codehaus.jackson.map.DeserializationContext)
     */
    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        try {
            LocalDateTime date = LocalDateTime.parse(jp.getText(),
                    dateFormatter);
            return date;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
