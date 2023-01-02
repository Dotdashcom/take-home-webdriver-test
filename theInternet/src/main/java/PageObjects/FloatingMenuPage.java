package PageObjects;

import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage {
    public FloatingMenuPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy( how = How.CSS , using = "a[href='#home']")
    WebElement homeMenu;

    @FindBy( how = How.CSS , using = "a[href='#news']")
    WebElement NewsMenu;

    @FindBy( how = How.CSS , using = "a[href='#contact']")
    WebElement contactMenu;

    @FindBy( how = How.CSS , using = "a[href='#about']")
    WebElement aboutMenu;

    public boolean isMenuDisplayed(){
        boolean flag = false;
        SeleniumLibrary seleniumLibrary = new SeleniumLibrary();
        if(seleniumLibrary.isElementDisplayed(homeMenu) &&
                seleniumLibrary.isElementDisplayed(NewsMenu) &&
                seleniumLibrary.isElementDisplayed(contactMenu) &&
                seleniumLibrary.isElementDisplayed(aboutMenu)
        ) {
            flag = true;
        }
        return flag;
    }


}
