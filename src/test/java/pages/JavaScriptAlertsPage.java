package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.DriverUtil;

public class JavaScriptAlertsPage extends BasePage {
  @FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
  WebElement jsAlertButton;
  @FindBy(xpath = "//button[contains(text(),'Click for JS Confirm')]")
  WebElement jsConfirmButton;
  @FindBy(xpath = "//button[contains(text(),'Click for JS Prompt')]")
  WebElement jsPromptButton;
  @FindBy(css = "#result")
  WebElement resultText;

  public void clickOnJsAlertButton() {
    jsAlertButton.click();
  }

  public String getJsAlertText() {
    Alert alert = DriverUtil.getDriver().switchTo().alert();
    String text = alert.getText();
    alert.accept();
    return text;
  }

  public void clickOnJsConfirmButton() {
    jsConfirmButton.click();
  }

  public String getJsConfirmText() {
    Alert alert = DriverUtil.getDriver().switchTo().alert();
    String text = alert.getText();
    alert.accept();
    return text;

  }

  public void clickOnJsPromptButton() {
    jsPromptButton.click();
  }

  public String getJsPromptText() {
    Alert alert = DriverUtil.getDriver().switchTo().alert();
    alert.sendKeys("Ali");
    alert.accept();
    String text = resultText.getText();
    return text;

  }


}
