package model;

import org.openqa.selenium.WebDriver;
import model.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DynamicLoadingPage extends BasePage {

    @FindBy(css = "button")
    private WebElement startButton;

    @FindBy(css = "#loading")
    private WebElement loadingMessage;

    @FindBy(css = "#loading img")
    private WebElement waitbarImage;

    @FindBy(css = "#finish")
    private WebElement resultMessage;

    @FindBy(css = "h4")
    private List<WebElement> h4TagList;

    private static final String DYNAMIC_LOADING_ENDPOINT = "dynamic_loading/2";

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public DynamicLoadingPage getDynamicLoadingPage() {
        getDriver(DYNAMIC_LOADING_ENDPOINT);

        return this;
    }

    public String getStartButtonText() {

        return startButton.getText();
    }

    public DynamicLoadingPage clickStartButton() {
        startButton.click();

        return this;
    }

    public DynamicLoadingPage clickAndWaitStartButton() {
        startButton.click();
        getWait(5).until(ExpectedConditions.visibilityOf(resultMessage));

        return this;
    }

    public boolean isWaitbarImageDisplayed() {

        return waitbarImage.isDisplayed();
    }

    public boolean isLoadingMessageDisplayed() {

        return loadingMessage.isDisplayed();
    }

    public String getLoadingMessageText() {

        return loadingMessage.getText();
    }

    public boolean isResultMessageDisplayed() {

        return resultMessage.isDisplayed();
    }

    public String getResultMessageText() {

        return resultMessage.getText();
    }

    public boolean isResultMessageNotDisplayed() {

        return h4TagList.size() == 1;
    }
}