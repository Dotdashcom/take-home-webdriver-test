package pages;

import core.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MouseHoverPage extends AbstractWebPage {

    @FindBy(css = "div.example > div > img")
    protected List<WebElement> listOfImagesElm;

    @FindBy(css = "div.figcaption > h5")
    protected List<WebElement> userNameElm;

    @FindBy(css = "div.figcaption > a")
    protected List<WebElement> viewProfileLinkElm;

    public MouseHoverPage(WebDriver driver) {
        super(driver);
    }

    public void mouseHoverToProfile(int index) {
        mkbActions.moveToElement(listOfImagesElm.get(index)).build().perform();
        sleepInSeconds(1);
    }

    public boolean isUserNameVisible(int index) {
        return isVisibleInViewport(viewProfileLinkElm.get(index));
    }
}