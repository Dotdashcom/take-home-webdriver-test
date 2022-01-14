package test;

import methods.FileUploadMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FileUploadTest extends FileUploadMethod {

    private final String filename = System.getProperty("user.home")+"/Downloads/"+"some-file.txt";

    @Test
    public void fileUploadTest() throws InterruptedException {
        startFileUploadTest(filename);
        assertTrue(isUploadSuccess());
    }
}
