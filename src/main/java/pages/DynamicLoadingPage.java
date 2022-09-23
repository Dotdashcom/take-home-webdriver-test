package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends BasePage {

    @FindBy(css = "div[id = start]>button")
    protected WebElement startButton;
    @FindBy(css = "div[id = finish]>h4")
    protected WebElement textMessage;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void startDynamicLoading(){
        startButton.click();
    }
    public String getLoadingTextMessage(){
        waitForElementToBeVisible("div[id = finish]>h4");
        return textMessage.getText();
    }
}
