/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.healthsciences.services.web.dto.mappers;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.healthsciences.services.facade.AppConfiguration;


/**
 * DateTime adapter for XML representations
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

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
    public LocalDateTimeAdapter() throws FileNotFoundException, IOException {
        super();
        dateFormatter = DateTimeFormat.forPattern(AppConfiguration
                .getDatetimeFormat());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
     */
    @Override
    public LocalDateTime unmarshal(String v) {
        try {
            return LocalDateTime.parse(v, dateFormatter);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
     */
    @Override
    public String marshal(LocalDateTime v) {
        return dateFormatter.print(v);
    }

}
