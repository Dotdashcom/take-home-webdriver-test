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
public class DynamicControls{
  WebDriver driver;
  GenericMethods gnrcMthds;
  
  @FindBy(xpath=".//*[@type='button' and text()='Remove']")
  public WebElement removeBtn;
  
  @FindBy(xpath=".//*[@type='button' and text()='Add']")
  public WebElement addBtn;

  @FindBy(id="checkbox")
  public WebElement chckBox;
  
  @FindBy(xpath=".//*[@type='text']")
  public WebElement txtBox;
  
  @FindBy(xpath=".//*[@type='button' and text()='Enable']")
  public WebElement enableBtn;
  
  @FindBy(xpath=".//*[@type='button' and text()='Disable']")
  public WebElement disbleBtn;
  
  public DynamicControls(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
      gnrcMthds = PageFactory.initElements(driver, GenericMethods.class);
  }
 
  public void clickOnRemoveButton() {
	  gnrcMthds.clickOnElement(removeBtn);
  }
  
  public void clickOnAddButton() {
	  gnrcMthds.clickOnElement(addBtn);
  }
  
  public void clickOnEnableButton() {
	  gnrcMthds.clickOnElement(enableBtn);
  }

  public void clickOnDisableButton() {
	  gnrcMthds.clickOnElement(disbleBtn);
  }
  
  public void verifyTxtBoxDisability() {
	  Assert.assertEquals(gnrcMthds.attributeTobePresent(disbleBtn,"disabled",""),true);
  }
  

  
}
