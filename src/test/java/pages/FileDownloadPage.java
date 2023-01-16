package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class FileDownloadPage extends BasePage {
  @FindBy(xpath = "//a[contains(text(),'some-file.txt')]")
  WebElement downloadFile;

  public boolean isFileExists(String filePath) {
    File file = new File(filePath);
    if (file.exists()) {
      return true;
    } else {
      return false;
    }

  }

  public void fileDownload() throws InterruptedException {
    downloadFile.click();
    Thread.sleep(3000);

  }
}
