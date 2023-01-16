package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverUtil;

import java.time.Duration;

public abstract class BasePage {

  protected WebDriverWait driverExplicitWait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(20));

  public BasePage() {
    PageFactory.initElements(DriverUtil.getDriver(), this);
  }
}
