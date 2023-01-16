package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploaderPage extends BasePage {

  @FindBy(xpath = "//input[@id='file-upload']")
  WebElement chooseFileButton;
  @FindBy(xpath = "//input[@id='file-submit']")
  WebElement uploadButton;
  @FindBy(xpath = "//h3[contains(text(),'File Uploaded!')]")
  WebElement headerText;

  public void uploadFile() {
    chooseFileButton.sendKeys("C:\\Users\\pazar\\OneDrive\\Desktop\\file.txt");
    uploadButton.click();
  }

  public String getHeaderText() {
    return headerText.getText();

  }


}
