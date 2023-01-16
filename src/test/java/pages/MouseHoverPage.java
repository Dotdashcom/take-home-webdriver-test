package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.DriverUtil;

public class MouseHoverPage extends  BasePage{
  @FindBy(xpath = "//img[@ src='/img/avatar-blank.jpg'][1]")
  WebElement firstImg;
  @FindBy(xpath = "//img[@ src='/img/avatar-blank.jpg'][1]")
  WebElement secondImg;
  @FindBy(xpath = "//img[@ src='/img/avatar-blank.jpg'][1]")
  WebElement thirdImg;

  @FindBy(linkText = "View profile")
  WebElement viewProfileLink;
  @FindBy(xpath = "//h5[contains(text(),'name: user1')]")
  WebElement userNameText;


   public boolean mouseHoverFirstImg(){
     Actions action = new Actions(DriverUtil.getDriver());
     action.moveToElement(firstImg).build().perform();
     if(userNameText.isDisplayed() && viewProfileLink.isDisplayed()){
       return true;
     }else{
       return false;
     }

   }
  public boolean mouseHoverSecondImg(){
    Actions action = new Actions(DriverUtil.getDriver());
    action.moveToElement(secondImg).build().perform();
    if(userNameText.isDisplayed() && viewProfileLink.isDisplayed()){
      return true;
    }else{
      return false;
    }

  }
  public boolean mouseHoverThirdImg(){
    Actions action = new Actions(DriverUtil.getDriver());
    action.moveToElement(thirdImg).build().perform();
    if(userNameText.isDisplayed() && viewProfileLink.isDisplayed()){
      return true;
    }else{
      return false;
    }

  }





}
