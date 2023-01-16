package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.DriverUtil;

public class DynamicContent extends BasePage {

  @FindBy(xpath = "(//div[@class='large-10 columns'])[1]")
  WebElement firstContent;
  @FindBy(xpath = "(//div[@class='large-10 columns'])[2]")
  WebElement secondContent;
  @FindBy(xpath = "(//div[@class='large-10 columns'])[3]")
  WebElement thirdContent;

  public void refreshPage(){
    DriverUtil.getDriver().navigate().refresh();
  }

  public String getFirstContextText() {
    return firstContent.getText();
  }

  public String getSecondContextText() {
    return secondContent.getText();
  }

  public String getThirdContextText() {
    return thirdContent.getText();
  }
}
