package test;

import methods.FileDownloadMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FileDownloadTest extends FileDownloadMethod {

    private final String filename = System.getProperty("user.home")+"/Downloads/"+"some-file.txt";

    @Test
    public void fileDownloadTest() throws InterruptedException {
        startFileDownloadTest();
        assertTrue(isFileExist(filename));
    }
}
