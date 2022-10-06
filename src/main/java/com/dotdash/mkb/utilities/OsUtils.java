package com.dotdash.mkb.utilities;


public class OsUtils {

    private static String osName = null;

    // Restrict creating objects on the fly.
    private OsUtils() {

    }

    public static void initOsUtils() {
        osName = System.getProperty("os.name").toLowerCase();
    }

    public static String getOSName() {
        return osName;
    }

    public static boolean isWindows() {
        return osName.startsWith("windows");
    }

    public static boolean isMac() {
        return osName.startsWith("mac");
    }
}
