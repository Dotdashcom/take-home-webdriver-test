package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FloatingMenuPage {

    public WebDriver driver;

    public FloatingMenuPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@id='menu']")
    private WebElement floatingMenu;

    @FindBy(xpath = "//a[.='Elemental Selenium']")
    private WebElement elementalSeleniumButton;



public boolean scrollToBottonValidateMenu() throws InterruptedException {

    Helpers.ScrollToBotton();
    return Helpers.ElementIsPresent(floatingMenu);
}
}
