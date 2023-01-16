package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class NotificationMessagePage extends BasePage {
  @FindBy(xpath = "//a[contains(text(),'Click here')]")
  WebElement clickHereLink;
  @FindBy(xpath = "//div[@class='flash notice']")
  WebElement flashNoticeText;

  public String test() {
    for (int i = 0; i < 3; i++) {
      clickHereLink.click();
    }
    return flashNoticeText.getText();
  }


}
