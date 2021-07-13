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
public class JavaScriptError{
  WebDriver driver;
  GenericMethods gnrcMthds;
  
  @FindBy(xpath=".//*[@type='checkbox']")
  public List<WebElement> checkboxes;
  
  public JavaScriptError(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
      gnrcMthds = PageFactory.initElements(driver, GenericMethods.class);
  }
 
  public void VerifyThatCheckboxesWorksAsExpected() {
	  for(WebElement chkBx:checkboxes) {
		  if (gnrcMthds.verifyIfCheckboxIsSlected(chkBx)==true) {
			  gnrcMthds.clickOnElement(chkBx);
			  Assert.assertEquals(gnrcMthds.verifyIfCheckboxIsSlected(chkBx),false);
			}
		  else {
			  gnrcMthds.clickOnElement(chkBx);
			  Assert.assertEquals(gnrcMthds.verifyIfCheckboxIsSlected(chkBx),true);
		  }
	  }
  }
}
