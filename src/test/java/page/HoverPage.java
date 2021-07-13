package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoverPage extends PageObject {
    public HoverPage(WebDriver driver) {
        super(driver);
        image = driver.findElements(By.className("figure"));
    }

    private List<WebElement> image;

    public void imageHover(int index) {
        Actions action = new Actions(driver);
        action.moveToElement(image.get(index)).build().perform();
    }

    public String getVisibleCaption(int index) {
        List<WebElement> imageCaptions = driver.findElements(By.className("figcaption"));
        return imageCaptions.get(index).getText();
    }
}
