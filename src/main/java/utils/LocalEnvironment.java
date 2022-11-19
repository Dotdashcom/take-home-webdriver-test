package utils;

import java.nio.file.Paths;

public final class LocalEnvironment {

    private static final String RESOURCES_DIR = "src/main/resources/";
    private static final String DOWNLOADS_DIR = "downloads";

    public static String getResourcePath(String resource) {
        return Paths.get(RESOURCES_DIR + resource).toAbsolutePath().toString();
    }

    public static String getDownloadsPath() {
        return Paths.get(DOWNLOADS_DIR).toAbsolutePath().toString();
    }
}
