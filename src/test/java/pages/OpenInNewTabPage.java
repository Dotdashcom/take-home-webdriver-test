package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.DriverUtil;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OpenInNewTabPage extends BasePage {
  @FindBy(linkText = "Click Here")
  WebElement clickHereLink;
  @FindBy(xpath = "//div[@class='example']/h3")
  WebElement newWindowText;

  public String switchToNewTab() {
    String mainTab = DriverUtil.getDriver().getWindowHandle();
    clickHereLink.click();
    Set<String> allTabs = DriverUtil.getDriver().getWindowHandles();
    Iterator<String> iterator = allTabs.iterator();
    while (iterator.hasNext()) {
      String childTab = iterator.next();
      if (!mainTab.equalsIgnoreCase(childTab)) {
        DriverUtil.getDriver().switchTo().window(childTab);
      }
    }
    return DriverUtil.getDriver().getTitle();

  }
  public String getText(){
    return newWindowText.getText();
  }


}

