package com.assignments.factory;

import com.assignments.exceptions.IncorrectFilePathException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static com.assignments.constants.MessageConstants.ERROR_MESSAGE_FILE_NOT_FOUND;
import static java.lang.ClassLoader.getSystemClassLoader;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

/**
 * This class acts as factory for producing File Object.
 */
public final class FileFactory {

  /**
   * Private constructor to avoid external instantiation.
   */
  private FileFactory() {
  }

  /**
   * @param fileName Name should be relative path from resources folder
   * @return {@link File} instance having full file path
   */
  public static File resource(String fileName) {
    File file;
    try {
      file = new File(requireNonNull(getSystemClassLoader().getResource(fileName)).getFile());
    } catch (NullPointerException ex) {
      throw new IncorrectFilePathException(format(ERROR_MESSAGE_FILE_NOT_FOUND, fileName));
    }
    return file;
  }

  public static void deleteFile(String filePath) {
    File file = new File(filePath);
    if (file.exists()){
      try {
        FileUtils.delete(file);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
