package PageObjects;

import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MouseHoverPage
{

    public MouseHoverPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy( how = How.XPATH , using = "(//img[@alt='User Avatar'])")
    List<WebElement> avatars;

    @FindBy( how = How.CLASS_NAME , using = "figcaption")
    List<WebElement> viewProfile;
    public boolean mouseHoverAvatars()  {
       boolean flag = true;
        SeleniumLibrary seleniumLibrary = new SeleniumLibrary();
        for(int i = 0;i<avatars.size();i++) {
            seleniumLibrary.mouseHover(avatars.get(i));
          if(! seleniumLibrary.isElementDisplayed(viewProfile.get(i))){
              flag = false;
          }
        }
        return flag;
    }



}
