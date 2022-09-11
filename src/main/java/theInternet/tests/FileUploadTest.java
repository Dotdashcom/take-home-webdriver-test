package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.FileUpload;

public class FileUploadTest extends TestBase {

    @Test
    public void fileUploadTest(){
        FileUpload fileUpload = new FileUpload(driver);
        String filePath = "/Users/firedoo/Desktop/Mount Rushmore.jpeg";
        fileUpload.uploadFile(filePath);
    }
}
