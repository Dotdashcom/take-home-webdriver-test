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
public class DynamicLoading{
  WebDriver driver;
  GenericMethods gnrcMthds;
  
  @FindBy(id="start")
  public WebElement startBtn;
  
  @FindBy(id="finish")
  public WebElement hloWrdTxt;
  
  public DynamicLoading(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
      gnrcMthds = PageFactory.initElements(driver, GenericMethods.class);
  }
  
  public void clickOnStartButton() {
	  gnrcMthds.clickOnElement(startBtn);
  }
}
