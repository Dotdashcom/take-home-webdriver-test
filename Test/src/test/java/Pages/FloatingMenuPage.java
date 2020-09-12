package Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPage extends PageBase {

    @FindBy(xpath = "//div[@id='menu']")
    WebElement menu;

     public void floatMenu(){
         BrowserUtils.scrollDownMenu("500");
     }

    public boolean menuIsVisible(){
        return BrowserUtils.elementIsVisible(menu);
    }
}
