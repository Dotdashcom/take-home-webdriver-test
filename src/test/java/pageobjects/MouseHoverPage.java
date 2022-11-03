package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class MouseHoverPage {

    private static MouseHoverPage _instance = null;
    private final By firstImage = By.cssSelector("div.example div.figure:first-of-type img");
    private final By secondImage = By.cssSelector("div.example div.figure:nth-of-type(2) img");
    private final By thirdImage = By.cssSelector("div.example div.figure:last-of-type img");
    private final By firstHeader = By.cssSelector("div.example div.figure:first-of-type h5");
    private final By secondHeader = By.cssSelector("div.example div.figure:nth-of-type(2) h5");
    private final By thirdHeader = By.cssSelector("div.example div.figure:last-of-type h5");

    public static MouseHoverPage getInstance() {
        if (_instance == null)
            _instance = new MouseHoverPage();
        return _instance;
    }

    public void mouseHoverFirstImage() {
        ActionHelper.mouseHoverElement(firstImage);
    }

    public void mouseHoverSecondImage() {
        ActionHelper.mouseHoverElement(secondImage);
    }

    public void mouseHoverThirdImage() {
        ActionHelper.mouseHoverElement(thirdImage);
    }

    public boolean firstHeaderIsDisplayed() {
        return ActionHelper.isPresent(firstHeader);
    }

    public boolean secondHeaderIsDisplayed() {
        return ActionHelper.isPresent(secondHeader);
    }

    public boolean thirdHeaderIsDisplayed() {
        return ActionHelper.isPresent(thirdHeader);
    }
}