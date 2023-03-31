package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Iframe {
    public Iframe(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "mce_0_ifr")
    WebElement iFrame;
    @FindBy(xpath = "//body[@id='tinymce']")
    WebElement typingArea;

    public void switchToFrame(WebDriver driver) {
        driver.switchTo().frame(iFrame);
        typingArea.sendKeys("Hello");

    }

    public boolean expected() {
        return typingArea.isDisplayed();
    }
}
