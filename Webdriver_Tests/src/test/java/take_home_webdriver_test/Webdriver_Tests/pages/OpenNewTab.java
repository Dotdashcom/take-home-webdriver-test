package take_home_webdriver_test.Webdriver_Tests.pages;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public class OpenNewTab{
  WebDriver driver;
  GenericMethods gnrcMthds;
  
  @FindBy(linkText ="Click Here")
  public WebElement clkHereLink;
  
  @FindBy(xpath =".//*[text()='New Window']")
  public WebElement newWindwTxt;
  
  
  public OpenNewTab(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
      gnrcMthds = PageFactory.initElements(driver, GenericMethods.class);
  }
 
  public void clickOnClikHereLink() {
	  gnrcMthds.clickOnElement(clkHereLink);
  }
  public boolean switchToWindowAndVerifyTxt() {
	  Set<String> windows = driver.getWindowHandles(); 
	  for (String window : windows) 
	  { 
		  driver.switchTo().window(window);
	  }
	  if (ExpectedConditions.visibilityOf(newWindwTxt)==null)
		  return false;
	  else
		  return true;
  }
}
