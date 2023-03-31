package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicContent {
    public DynamicContent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@class='row']//img")
    List<WebElement> images;


    public boolean reload(WebDriver driver) {
        List<WebElement> newImages = new ArrayList<>(Arrays.asList());
        for (int i = 0; i < 4; i++) {
            driver.navigate().refresh();
            newImages.add(images.get(i));

            for (WebElement image : newImages) {
                if (image.getText() != images.get(i).getText()) ;
                return true;
            }
        }

        return true;
    }
}
