package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class FloatingMenuPage {

    private WebDriver driver;

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='menu']")
    private WebElement floatingMenu;

    public boolean checkFloatingMenuExists(){
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)", " ");
        return floatingMenu.isDisplayed();

    }
}
