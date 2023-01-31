package utils;

public enum Browser {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    SAFARI("safari"),
    OPERA("opera");

    private final String driverName;

    public String getDriverName() {
        return driverName;
    }

    public static Browser fromString(String browserName) {
        for (Browser browser : Browser.values()) {
            if (browser.name().equalsIgnoreCase(browserName)) {
                return browser;
            }
        }
        return Browser.CHROME;
    }
    Browser(String driverName) {
        this.driverName = driverName;
    }
}
