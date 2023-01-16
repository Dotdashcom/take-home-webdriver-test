package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import utilities.DriverUtil;

public class ContextMenuPage extends BasePage {
  @FindBy(xpath = "//div[@id='hot-spot']")
  WebElement box;

  public void rightClick() {
    Actions action = new Actions(DriverUtil.getDriver());
    action.contextClick(box).perform();
  }

  public String getJavaScriptAlertText() {
    Alert alert = DriverUtil.getDriver().switchTo().alert();
    alert.getText();
    return alert.getText();
  }

}
