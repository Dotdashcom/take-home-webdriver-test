package take_home_webdriver_test.Webdriver_Tests.pages;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public class FloatingMenu{
  WebDriver driver;
  GenericMethods gnrcMthds;
  
  @FindBy(id="menu")
  public WebElement fltngMenu;
  
  public FloatingMenu(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
      gnrcMthds = PageFactory.initElements(driver, GenericMethods.class);
  }
 
  public boolean verifyThatFloatingMenuIsdisplayed() {
	  if (ExpectedConditions.visibilityOf(fltngMenu)==null)
		  return false;
	  else
		  return true;
  }
  
  public void scrollToTheBottom() {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }
}
