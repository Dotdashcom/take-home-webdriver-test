package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.DriverUtil;

public class HomePage extends BasePage{

  @FindBy(xpath = "//h4[@class='subheader']")
  WebElement subHeader;
  @FindBy(xpath = "//i[contains(text(),'Logout')]")
  WebElement logoutButton;

  String ExpectedUrl=" http://localhost:7080/secure";
  String msg="Welcome to the Secure Area. When you are done click logout below.";

  public String getUrl(){

    return DriverUtil.getDriver().getCurrentUrl();
  }
  public boolean logoutButtonIsVisible(){
    if(logoutButton.isDisplayed()){
      return true;
    }else{
      return false;
    }
  }
  public String getText(){
    return subHeader.getText();
  }

}
