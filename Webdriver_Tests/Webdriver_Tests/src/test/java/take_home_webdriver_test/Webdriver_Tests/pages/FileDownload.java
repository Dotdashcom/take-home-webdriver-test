package take_home_webdriver_test.Webdriver_Tests.pages;
import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public class FileDownload{
  WebDriver driver;
  GenericMethods gnrcMthds;
  
  @FindBy(linkText="some-file.txt")
  public WebElement flDwnldLink;
  
  public FileDownload(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
      gnrcMthds = PageFactory.initElements(driver, GenericMethods.class);
  }
 
  public void clickOnFileNameLink() {
	  gnrcMthds.clickOnElement(flDwnldLink);
  }
  
  public boolean verifyIFFileExists() {
	  String tmpFolderPath = System.getProperty("java.io.tmpdir");
	  String expectedFileName = "some-file.txt";
	  File file = new File(tmpFolderPath + expectedFileName);
	  if (file.exists()) {
	      file.delete();
	      return true;
	  }
	  else
		  return false;
	  		
	  
  }
  
  
}
