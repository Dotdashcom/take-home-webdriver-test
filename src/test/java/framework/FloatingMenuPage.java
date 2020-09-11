package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class FloatingMenuPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    WebElement homeButton;

    public FloatingMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean testFloatingMenu(WebDriver driver) {
        boolean isFloating = false;
        waitUntilElementIsPresent(driver, homeButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        System.out.println("Scrolled to the bottom of the page");
        if (isElementPresent(driver, homeButton)) {
            clickOnElement(driver, homeButton, "Success: Clicked on Home button",
                    "Failed: Unable to click on Home button");
            isFloating = true;
        }
        return isFloating;
    }
}
