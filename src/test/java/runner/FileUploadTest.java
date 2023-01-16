package runner;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploaderPage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class FileUploadTest extends TestBase {

  FileUploaderPage fileUploaderPage = new FileUploaderPage();

  @Test
  public void testFileUpload() {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "upload");
    fileUploaderPage.uploadFile();

    String expectedText = "File Uploaded!";
    String actualText = fileUploaderPage.getHeaderText();
    Assert.assertEquals(actualText, expectedText);
  }


}
