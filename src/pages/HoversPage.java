import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage extends BasePage {
    private String path = "/hovers";

    private By imagesBy = By.xpath("//div[@class='figure']");
    private By infosBy = By.xpath("//div[@class='figcaption']");

    HoversPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public int numImages() {
        return driver.findElements(imagesBy).size();
    }

    public boolean infoVisible(int index) {
        List<WebElement> infos = driver.findElements(infosBy);

        return infos.get(index).isDisplayed();
    }

    public void hoverOverImage(int imgIndex) {
        Actions actions = new Actions(driver);
        List<WebElement> images = driver.findElements(imagesBy);

        actions.moveToElement(images.get(imgIndex)).perform();
    }
}
