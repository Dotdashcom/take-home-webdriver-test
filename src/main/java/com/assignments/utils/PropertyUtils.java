package com.assignments.utils;

import com.assignments.enums.ConfigProperties;
import com.assignments.exceptions.PropertyNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import static com.assignments.constants.MessageConstants.ERROR_MESSAGE_PROPERTY_NOT_FOUND;
import static com.assignments.constants.FrameworkConstants.getConfigfilepath;
import static java.lang.String.valueOf;
import static java.util.Objects.isNull;
import static java.lang.String.format;

/**
 * Read the property file and store it in a HashMap for faster processing.
 */
public final class PropertyUtils {

  /**
   * Private constructor to avoid external instantiation
   */
  private PropertyUtils() {
  }

  private static Properties properties = new Properties();
  private static final HashMap<String, String> configMap = new HashMap<>();

  static {
    FileInputStream fis;
    String configFilePath = getConfigfilepath();
    try {

      fis = new FileInputStream(configFilePath);
      properties.load(fis);
      properties.forEach((key, value) -> configMap.put((String) key, valueOf(value)));
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(0);
    }
  }

  /**
   * Receives the {@link ConfigProperties},converts to lowercase , return the
   * corresponding value
   *
   * @param key to be fetched from property file
   * @return corresponding value for the requested key if found else {@link
   * PropertyNotFoundException}
   */
  public static String getValue(ConfigProperties key) {

    if (isNull(configMap.get(key.name().toLowerCase()))) {
      throw new PropertyNotFoundException(format(ERROR_MESSAGE_PROPERTY_NOT_FOUND, key));
    }

    return configMap.get(key.toString().toLowerCase());
  }


}
