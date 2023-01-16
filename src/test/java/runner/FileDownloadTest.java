package runner;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileDownloadPage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class FileDownloadTest extends TestBase {
  FileDownloadPage fileDownloadPage = new FileDownloadPage();

  @Test
  public void validateDownload() throws InterruptedException {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "download");
    fileDownloadPage.fileDownload();
    String filePath = "C:\\Users\\pazar\\Downloads";
    Assert.assertTrue(fileDownloadPage.isFileExists(filePath));
  }

}
