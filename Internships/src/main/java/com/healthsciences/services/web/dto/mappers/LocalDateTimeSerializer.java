/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.healthsciences.services.web.dto.mappers;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.healthsciences.services.facade.AppConfiguration;


public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
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
    public LocalDateTimeSerializer() throws FileNotFoundException, IOException {
        super();
        dateFormatter = DateTimeFormat.forPattern(AppConfiguration
                .getDatetimeFormat());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.codehaus.jackson.map.JsonSerializer#serialize(java.lang.Object,
     * org.codehaus.jackson.JsonGenerator,
     * org.codehaus.jackson.map.SerializerProvider)
     */
    @Override
    public void serialize(LocalDateTime value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {
        String date = dateFormatter.print(value);
        jgen.writeString(date);
    }

}
