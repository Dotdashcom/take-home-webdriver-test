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
public class Dropdown{
  WebDriver driver;
  GenericMethods gnrcMthds;
  
  @FindBy(id="dropdown")
  public WebElement drpDwn;
  
  public Dropdown(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
      gnrcMthds = PageFactory.initElements(driver, GenericMethods.class);
  }
 
}
