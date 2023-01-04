package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MouseHoverPage extends Page {
    private static final String CONTENT = "//div[@id='content']";
    private static final By IMAGES = By.xpath(CONTENT + "//img");
    private static final String INFO_HEADER = "(" + CONTENT + "//h5)[%s]";
    private static final String INFO_LINK = "(" + CONTENT + "//a)[%s]";

    public MouseHoverPage(ChromeDriver driver) {
        super(driver);
    }

    public List<WebElement> getImages() {
        return visibilityOfAllElementsLocated(IMAGES, BasePage.TIMEOUT);
    }

    public void hoverImage(WebElement image) {
        getActions()
                .moveToElement(image)
                .build()
                .perform();
    }

    public boolean isHeaderDisplayed(int index) {
        return isElementLocatedVisible(By.xpath(String.format(INFO_HEADER, index)), BasePage.ACTION_TIMEOUT);
    }

    public boolean isLinkDisplayed(int index) {
        return isElementLocatedVisible(By.xpath(String.format(INFO_LINK, index)), BasePage.ACTION_TIMEOUT);
    }
}
