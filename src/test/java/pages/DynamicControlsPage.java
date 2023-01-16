package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicControlsPage extends BasePage {

  @FindBy(xpath = "(//div[@id='checkbox'])/input")
  WebElement removeCheckbox;

  @FindBy(xpath = "//button[contains(text(),'Remove')]")
  WebElement removeButton;


  @FindBy(xpath = "(//form[@id='input-example'])/input")
  WebElement textBox;

  @FindBy(xpath = "//button[contains(text(),'Enable')]")
  WebElement enableButton;

  @FindBy(xpath = "//p[@id='message']")
  WebElement messageText;

  @FindBy(xpath = "//button[contains(text(),'Add')]")
  WebElement addButton;
  @FindBy(xpath = "//button[contains(text(),'Disable')]")
  WebElement disableButton;
  @FindBy(xpath = "//input[@id='checkbox']")
  WebElement addCheckbox;
  @FindBy(css = "#message")
  WebElement enableTextMsg;
  @FindBy(xpath = "//p[@id='message']")
  WebElement disableTextMsg;

  public void clickOnRemove(){
    removeButton.click();
    driverExplicitWait.until(ExpectedConditions.invisibilityOf(removeButton));


  }
  public boolean removeCheckboxIsVisible(){
    return removeCheckbox.isDisplayed();

  }
  public void clickOnAddButton(){
    addButton.click();
    driverExplicitWait.until(ExpectedConditions.invisibilityOf(addButton));

  }
  public void clickOnEnableButton(){
    enableButton.click();
    driverExplicitWait.until(ExpectedConditions.invisibilityOf(enableButton));

  }
  public String getTextMessage(){
    return messageText.getText();

  }
  public boolean addCheckboxIsVisible(){

    driverExplicitWait.until(ExpectedConditions.visibilityOf(addCheckbox));
    return addCheckbox.isDisplayed();

  }
  public String getEnableTextMessage(){
    return enableTextMsg.getText();

  }
  public void clickOnDisableButton(){
    disableButton.click();
    driverExplicitWait.until(ExpectedConditions.invisibilityOf(disableButton));
  }
  public String getDisableTextMessage(){
    return disableTextMsg.getText();

  }




}
