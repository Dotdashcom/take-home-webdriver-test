package homework.pages;

import homework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JS_AlertPage {

    public JS_AlertPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement alertButton;


    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement confirmButton;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement promptButton;

    @FindBy(id = "result")
    public WebElement shownMessage;
}
