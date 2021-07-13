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
public class JavaScriptAlert{
  WebDriver driver;
  GenericMethods gnrcMthds;
  
  @FindBy(xpath=".//*[text()='Click for JS Alert']")
  public WebElement jsAlrtBtn;
  
  @FindBy(xpath=".//*[text()='Click for JS Confirm']")
  public WebElement jsCnfrmBtn;
  
  @FindBy(xpath=".//*[text()='Click for JS Prompt']")
  public WebElement jsPrmptBtn;
  
  public JavaScriptAlert(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
      gnrcMthds = PageFactory.initElements(driver, GenericMethods.class);
  }
 
  public void clickOnJsAlertButton() {
	  gnrcMthds.clickOnElement(jsAlrtBtn);
  }
  

  public void clickOnJsCnfrmButton() {
	  gnrcMthds.clickOnElement(jsCnfrmBtn);
  }
  

  public void clickOnJsPrmptButton() {
	  gnrcMthds.clickOnElement(jsPrmptBtn);
  }
  
  public void verifyTheAlert() {
	  gnrcMthds.ifAlertPresentThenAccept();
  }
  
}
