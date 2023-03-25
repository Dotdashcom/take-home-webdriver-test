package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MouseHoverPage extends BasePage {
    private By images = By.cssSelector("div[class='figure']");
    private By additionalInfo = By.cssSelector("div[class='figcaption']");

    public MouseHoverPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getImages() {
        return driver.findElements(images);
    }

    public List<WebElement> getInfo() {
        return driver.findElements(additionalInfo);
    }

    public void mouseHover(WebElement image){
        Actions hover = new Actions(driver);
        hover.moveToElement(image).perform();
    }

    public boolean isInfoDisplayed(WebElement info) {
        return info.isDisplayed();
    }
}
