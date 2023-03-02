package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DynamicControlsPage {

    public DynamicControlsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h4[1]")
    public WebElement header;

    @FindBy(xpath = "//div[text()=' A checkbox']")
    public List<WebElement> checkboxA;

    @FindBy(xpath = "//button[@onclick='swapCheckbox()']")
    public WebElement addRemoveBtn;

    @FindBy(id = "message")
    public WebElement message;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement textInput;

    @FindBy(xpath = "//button[@onclick='swapInput()']")
    public WebElement enableDisableBtn;

}

