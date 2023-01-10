package model;

import org.openqa.selenium.WebDriver;
import model.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MouseHoverPage extends BasePage {

    private static final String HOVERS_ENDPOINT = "hovers";

    @FindBy(css = ".figure:nth-of-type(1) img")
    private WebElement firstImage;

    @FindBy(css = ".figure:nth-of-type(2) img")
    private WebElement secondImage;

    @FindBy(css = ".figure:nth-of-type(3) img")
    private WebElement thirdImage;

    @FindBy(css = ".figure img")
    private List<WebElement> imageList;

    @FindBy(css = ".figure:nth-of-type(1) .figcaption")
    private WebElement firstImageCaption;

    @FindBy(css = ".figure:nth-of-type(2) .figcaption")
    private WebElement secondImageCaption;

    @FindBy(css = ".figure:nth-of-type(3) .figcaption")
    private WebElement thirdImageCaption;

    public MouseHoverPage(WebDriver driver) {
        super(driver);
    }

    public MouseHoverPage getMouseHoverPage() {
        getDriver(HOVERS_ENDPOINT);

        return this;
    }

    public MouseHoverPage hoverFirstImage() {
        getAction().moveToElement(firstImage).perform();

        return this;
    }

    public boolean isFirstImageCaptionDisplayed() {
        getAction().moveToElement(firstImage).perform();

        return firstImageCaption.isDisplayed();
    }
    public MouseHoverPage hoverSecondImage() {
        getAction().moveToElement(secondImage).perform();

        return this;
    }

    public boolean isSecondImageCaptionDisplayed() {
        getAction().moveToElement(secondImage).perform();

        return secondImageCaption.isDisplayed();
    }
    public MouseHoverPage hoverThirdImage() {
        getAction().moveToElement(thirdImage).perform();

        return this;
    }

    public boolean isThirdImageCaptionDisplayed() {
        getAction().moveToElement(thirdImage).perform();

        return thirdImageCaption.isDisplayed();
    }
}