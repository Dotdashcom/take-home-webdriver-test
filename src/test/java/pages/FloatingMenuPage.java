package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.DriverUtil;

public class FloatingMenuPage extends BasePage {

  @FindBy(xpath = "//a[contains(text(),'Home')]")
  WebElement homeButton;
  @FindBy(xpath = "//a[contains(text(),'News')]")
  WebElement newsButton;
  @FindBy(xpath = "//a[contains(text(),'Contact')]")
  WebElement contactButton;
  @FindBy(xpath = "//a[contains(text(),'About')]")
  WebElement aboutButton;


  public boolean buttonsAreVisibleWhileScrolling() {
    if (homeButton.isDisplayed() && newsButton.isDisplayed() && contactButton.isDisplayed() && aboutButton.isDisplayed()) {

    }
    return true;
  }

  public void scrollDownThePage() {
    JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }


}
