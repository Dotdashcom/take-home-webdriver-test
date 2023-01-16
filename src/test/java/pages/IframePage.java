package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.DriverUtil;

public class IframePage extends BasePage {
  @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
  WebElement iframe;
  @FindBy(xpath = "//button[@ class='tox-notification__dismiss tox-button tox-button--naked tox-button--icon']//div[@class='tox-icon']")
  WebElement closeIcon;
  @FindBy(xpath = "//p[contains(text(),'Your content goes here.')]")
  WebElement editBox;

  public void switchToIframe(){
    int size=DriverUtil.getDriver().findElements(By.tagName("iframe")).size();
    System.out.println(size);
    DriverUtil.getDriver().switchTo().frame("mce_0_ifr");

  }
  public void writeTextIn(){

    driverExplicitWait.until(ExpectedConditions.visibilityOf(editBox));
    editBox.clear();
    editBox.sendKeys("Ali Can Pazarcikli");
  }
  public String getText(){
   return  editBox.getText();
  }
}
