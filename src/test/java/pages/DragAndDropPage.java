package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.DriverUtil;

public class DragAndDropPage extends BasePage {

  @FindBy(xpath = "//div[@id='column-a']")
  WebElement source;
  @FindBy(xpath = "//div[@id='column-b']")
  WebElement target;

  public void dragAndDrop() {
    Actions action = new Actions(DriverUtil.getDriver());
    action.dragAndDrop(source, target).build().perform();

  }

  public String getElementText_A() {
    return source.getText();

  }

  public String getElementText_B() {
    return target.getText();

  }
}
