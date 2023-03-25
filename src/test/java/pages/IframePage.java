package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IframePage extends BasePage {
    private By iframe = By.id("mce_0_ifr");
    private By textInput = By.id("tinymce");

    public IframePage(WebDriver driver) {
        super(driver);
    }

    public void switchIframe() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(iframe));
        driver.switchTo().frame(driver.findElement(iframe));
    }

    public void clearText(){
        getElement(textInput).clear();
    }

    public void typeText(String text) {
        getElement(textInput).sendKeys(text);
    }

    public String getText() {
        return getElement(textInput).getText();
    }
}
