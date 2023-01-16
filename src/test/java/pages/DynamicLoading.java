package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoading extends BasePage{

  @FindBy(xpath = "//button[contains(text(),'Start')]")
  WebElement startButton;
  @FindBy(xpath = "//h4[contains(text(),'Hello World!')]")
  WebElement textButton;

  public void clickOnStartButton(){
    startButton.click();
    driverExplicitWait.until(ExpectedConditions.invisibilityOf(startButton));
  }
  public boolean getTextIsDisplayed(){
    driverExplicitWait.until(ExpectedConditions.visibilityOf(textButton));
    return  textButton.isDisplayed();
  }
}
