package com.healthsciences.services.facade;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class AppConfiguration {
	private static final String APP_CONFIG_FILE = "properties/app.properties";
    private static final Properties PROPERTIES;

    /**
     * The Constructor.
     */
    private AppConfiguration() {
        // no code
    }

    static {
        Resource resource = new ClassPathResource(APP_CONFIG_FILE);
        try {
            PROPERTIES = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            throw new RuntimeException("Could not load configuration file "
                    + APP_CONFIG_FILE, e);
        }
    }

    /**
     * Gets the property.
     * 
     * @param name
     *            the name
     * @return the property
     */
    public static String getProperty(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException(
                    "Given property name is null or empty");
        }
        if (PROPERTIES == null) {
            throw new IllegalStateException(
                    "Properties was not initialized properly.");
        }
        return PROPERTIES.getProperty(name);
    }

    /**
     * Gets the datetime format.
     * 
     * @return the datetime format
     */
    public static String getDatetimeFormat() {
        String value = PROPERTIES.getProperty("web.mapper.datetime.format");
        return value != null ? value : "YYYY.MM.dd HH:mm";
    }
}
