package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingPageObjects extends BasePageObject {
    @FindBy(id="menu")
    WebElement floatingMenu;

    public FloatingPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isMenuVisible(){
        return floatingMenu.isDisplayed();
    }
    public FloatingPageObjects scrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }
    public FloatingPageObjects scrollUp(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, 0)");
        return this;
    }
}
