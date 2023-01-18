package com.qa.take_home_webdriver_test.constants;

public class Paths {

    //    SYSTEM PROPERTIES:
    private static final String USER_DIRECTORY = System.getProperty("user.dir");

    //    DIRECTORIES:
    private static final String CONFIG_MAIN = "src/main/java/com/qa/take_home_webdriver_test/";
    private static final String CONFIG_PATH = "config/config.properties";
    private static final String SCREENSHOT_PATH = "screenshots/";

    public static final long PAGE_LOAD_TIMEOUT = 20;
    public static final long WEB_DRIVER_WAIT_TIMEOUT = 10;
    public static final String CONFIG = CONFIG_MAIN + CONFIG_PATH;
    public static final String REPORTS = "reports/";
    public static final String SCREENSHOTS = USER_DIRECTORY + '/' + SCREENSHOT_PATH;
    public static final String DOWNLOAD_PATH = "/Users/dzmitryrazhkou/Downloads";
    public static final String UPLOAD_FILE_PATH = "/Users/dzmitryrazhkou/Documents/take-home-webdriver-test/upload/upload-file.txt";
}
