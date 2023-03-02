package tests;

import enums.Pages;
import enums.Paths;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import utilities.BrowserUtils;

import java.io.File;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class FileUploadTest extends TestBase {

    @Test(description = "File upload test")
    public void fileUploadTest() {
        FileUploadPage fileUploadPage = new FileUploadPage();
        BrowserUtils.openPage(driver, Pages.FILE_UPLOAD_PAGE);
        BrowserUtils.waitUntilVisible(driver, fileUploadPage.header, Duration.ofSeconds(15));
        String fileName = "some-file.txt";
        fileUploadPage.chooseFileBtn.sendKeys(Paths.TEST_DATA_FOLDER.getPath() + File.separator + fileName);
        assertThat(fileUploadPage.chooseFileBtn.getAttribute("value")).contains(fileName);
    }
}
