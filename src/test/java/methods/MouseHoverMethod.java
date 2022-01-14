package methods;

import model.MouseHoverPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MouseHoverMethod extends GeneralTestMethod{

    private final String mouseHoverURL = "http://localhost:7080/hovers";
    MouseHoverPage mouseHoverPage;
    List<WebElement> images;
    List<WebElement> contents;

    public void startMouseHoverTest(int i) {
        driver.get(mouseHoverURL);
        mouseHoverPage = new MouseHoverPage(driver);

        images = mouseHoverPage.imagesComponent();
        contents = mouseHoverPage.contentsComponent();

        mouseHoverPage.contentsComponent();
        mouseHover(i);
    }

    public void mouseHover(int i) {
        WebElement image = images.get(i);
        Actions action = new Actions(driver);
        action.moveToElement(image).build().perform();
    }

    public boolean isContentDisplayed(int i) {
        return contents.get(i).isDisplayed();
    }
}
