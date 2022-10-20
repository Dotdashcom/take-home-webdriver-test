package src.main.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FramePage extends BasePage{
    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.tox-icon svg")
    private WebElement closeIcon;

    @FindBy(css = "#tinymce > p")
    private WebElement text;

    public void closeNotification() {
        WebDriverWait wdWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.tox-icon svg")));
        closeIcon.click();
    }

    public String getInnerText() {
        return text.getText();
    }

    public void setText(String text) {
        this.text.clear();
        this.text.sendKeys(text);
    }
}
