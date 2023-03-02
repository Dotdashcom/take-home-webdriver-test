package utilities;

import enums.Paths;

import java.io.File;

public class FileUtils {

    public static boolean isFilePresent(Paths path, String fileName) {
        return new File(path.getPath() + File.separator + fileName).exists();
    }
}
