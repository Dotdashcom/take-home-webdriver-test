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
public class IFrame{
  WebDriver driver;
  GenericMethods gnrcMthds;
  
  @FindBy(id="mce_0_ifr")
  public WebElement frameID;
  
  public IFrame(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
      gnrcMthds = PageFactory.initElements(driver, GenericMethods.class);
  }
 
  public void switchToFrame() {
	  driver.switchTo().frame("mce_0_ifr");
  }
  
  public void enterText() {
	  frameID.sendKeys("For the Testing");;
  }
}
