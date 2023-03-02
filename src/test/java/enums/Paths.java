package enums;

import java.io.File;

public enum Paths {
    DOWNLOAD_FOLDER(System.getProperty("user.dir") + File.separator + "target" + File.separator + "downloadFiles"),
    TEST_DATA_FOLDER(System.getProperty("user.dir") + File.separator + "src" +
            File.separator + "test" + File.separator + "java" + File.separator + "testData" + File.separator);

    private final String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
