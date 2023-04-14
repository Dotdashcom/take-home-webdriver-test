package page_object_model.dynamic_loading;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends Base {

    public DynamicLoadingPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Start']")
    private WebElement startButton;

    @FindBy(xpath = "//h4[text()='Hello World!']")
    public static WebElement helloWordMessage;

    public void clickStartButton() {
        clickOnElement(startButton);
    }
}
