package take_home_webdriver_test.Webdriver_Tests.pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Sample page
 */
public class GenericMethods {
  protected WebDriver driver;

  @FindBy(tagName="h2")
  WebElement pageHeading;
  
  @FindBy(tagName="h4")
  WebElement pageSubHeading;
  
  public GenericMethods(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);

  }
  
  public WebElement waitFortheVisibilityOfElemnt(WebElement elmnt) {
	  WebDriverWait wait = new WebDriverWait(driver,10);
	  return wait.until(ExpectedConditions.visibilityOf(elmnt));
	  }
  

  public boolean waitForInvisibilityOfElemnt(WebElement elmnt) {
	  WebDriverWait wait = new WebDriverWait(driver,20);
	  return wait.until(ExpectedConditions.invisibilityOf(elmnt));
	  }
  
  
  public WebElement waitFortheElementToBeClickable(WebElement elmnt){
	  WebDriverWait wait = new WebDriverWait(driver,10);
	  return wait.until(ExpectedConditions.elementToBeClickable(elmnt));
	  }
  
  public boolean attributeTobePresent(WebElement elmnt,String attrbt,String atrbtVal){
	  WebDriverWait wait = new WebDriverWait(driver,10);
	  return wait.until(ExpectedConditions.attributeToBe(elmnt,attrbt,atrbtVal));
	  }
  
  public boolean verifyIfCheckboxIsSlected(WebElement elmnt) {
	  return elmnt.isSelected();
	  }
  
  
  public void setValueInTextBox(WebElement txtBoxElmnt,String textTobeEntered) {
	  waitFortheVisibilityOfElemnt(txtBoxElmnt).sendKeys(textTobeEntered);
	  }
   
  public void clickOnElement(WebElement elmntTobeClicked) {
		waitFortheElementToBeClickable(elmntTobeClicked).click();
	  }
  
  public void ifAlertPresentThenAccept() {
	  WebDriverWait wait = new WebDriverWait(driver,5);
	  Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	  alert.accept();
	  }
  
  public void ifAlertPresentThenEnterValInAlrtTxtBox(String txt) {
	  WebDriverWait wait = new WebDriverWait(driver,5);
	  wait.until(ExpectedConditions.alertIsPresent());
	  driver.switchTo().alert().sendKeys(txt);
	  }
  
  public void ifAlertPresentThenAssertTheText(String expctdTxt) {
	  WebDriverWait wait = new WebDriverWait(driver,5);
	  wait.until(ExpectedConditions.alertIsPresent());
	  Assert.assertEquals(driver.switchTo().alert().getText(), expctdTxt);
	  }
  
  public void mouseRightClickOnElement(WebElement elmntTobeClicked) {
	  Actions action = new Actions(driver);
	  action.contextClick(elmntTobeClicked).build().perform();
	  }
  
  public void mouseActionDragAndDrop(WebElement srcElmnt,WebElement destElmnt) {
	  Actions action = new Actions(driver);
	  action.dragAndDrop(srcElmnt,destElmnt).build().perform();
	  }
  
  public void selectValueByVisibleTxtInDropDown(WebElement slctWebElemnt,String vsblTxt) {
	  Select slct = new Select(slctWebElemnt);
	  slct.selectByVisibleText(vsblTxt);
	  }
  
  public boolean ifValueIsSelectedInDropdown(WebElement slctWebElemnt,String vsblTxt) {
	  Select slct = new Select(slctWebElemnt);
	  if (slct.getFirstSelectedOption().getText().equals(vsblTxt))
		  return true;
	  else
		  return false;
	  }
  
  public void verifyPageHeading(String expctdHeading) {
	  String actualHeading=pageHeading.getText();
	  Assert.assertEquals(actualHeading, expctdHeading);
	  }
  
  public void verifyPageSubHeading(String expctdSubHeading) {
	  String actualSubHeading=pageSubHeading.getText();
	  Assert.assertEquals(actualSubHeading, expctdSubHeading);
	  }
}
