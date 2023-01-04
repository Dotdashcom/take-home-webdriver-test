package constants;

public final class FilePaths {
    private FilePaths() throws Exception {
        throw new Exception();
    }

    private static final String TEST_RESOURCES = "src/test/resources/";
    public static final String TEST_CONFIG = TEST_RESOURCES + "config/";
    public static final String TEST_DATA = System.getProperty("user.dir") + "/" + TEST_RESOURCES + "data/";
}
