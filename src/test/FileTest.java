package src.test;

import org.testng.annotations.Test;
import src.main.pages.CheckBoxesPage;
import src.main.pages.FileDownloadPage;
import src.main.pages.FileUploadPage;
import src.main.utilities.Browser;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class FileTest extends BaseTest {



    private FileDownloadPage fileDownloadPage;
    private FileUploadPage fileUploadPage;

    @Test
    public void downloadTest() {
        fileDownloadPage = Browser.open(baseURL + "download", FileDownloadPage.class);

        fileDownloadPage.downloadFile();
        assertTrue(fileDownloadPage.isDownloadedFileLocated());
    }

    @Test
    public void uploadTest() {
        fileUploadPage = Browser.open(baseURL + "upload", FileUploadPage.class);
        fileUploadPage.uploadFile("some-file.txt");
        assertEquals(fileUploadPage.getUploadedFileName(), "some-file.txt");
    }

}
