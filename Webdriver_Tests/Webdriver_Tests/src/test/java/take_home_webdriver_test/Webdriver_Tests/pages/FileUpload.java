package take_home_webdriver_test.Webdriver_Tests.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public class FileUpload{
  WebDriver driver;
  GenericMethods gnrcMthds;
  
  @FindBy(id="file-submit")
  public WebElement upldBtn;
  
  @FindBy(id="drag-drop-upload")
  public WebElement upldBox;
  
  @FindBy(id="file-upload")
  public WebElement chsFleBtn;
  
  @FindBy(id="uploaded-files")
  public WebElement upldedFile;
  
  public FileUpload(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
      gnrcMthds = PageFactory.initElements(driver, GenericMethods.class);
  }
 
  public void sendFileTouploadAndClickOnUploadBtn() {
	  chsFleBtn.sendKeys(System.getProperty("user.dir")+"src\\main\\resources\\text.txt");
	  gnrcMthds.clickOnElement(upldBtn);
  }
  
  public void verifyUploadedFileName() {
	  Assert.assertEquals(upldedFile.getText().trim(), "text.txt");
  }
  
}
