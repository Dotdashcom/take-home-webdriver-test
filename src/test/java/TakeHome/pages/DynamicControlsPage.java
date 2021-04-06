package TakeHome.pages;

import TakeHome.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicControlsPage extends BasePage {

    public DynamicControlsPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id="checkbox")
    private WebElement checkbox;

    @FindBy(xpath = "//*[@onclick='swapCheckbox()']")
    private WebElement checkButton;

    @FindBy(xpath ="//*[@style='width: 30%;']")
    private WebElement disableArea;

    @FindBy(xpath = "//*[@onclick='swapInput()']")
    private WebElement inputButton;

    @FindBy(id = "message")
    private WebElement message;


    WebDriverWait wait = new WebDriverWait(Driver.get(), 3);

    public void clickCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(checkButton));
        checkButton.click();
    }

    public String getCheckButtonName() {
        wait.until(ExpectedConditions.elementToBeClickable(checkButton));

        return checkButton.getText();
    }

    public void clickInputBox() {
        wait.until(ExpectedConditions.elementToBeClickable(inputButton));
        inputButton.click();
    }

    public String getInputBoxName() {
        wait.until(ExpectedConditions.elementToBeClickable(checkButton));

        return inputButton.getText();
    }

}
