package MarionelaTirsina.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlert extends BasePage {
    @FindBy(xpath = "//button[contains(text(), 'Click for JS Alert')]")
    public WebElement javaScripAlert;


    @FindBy(xpath = "//button[contains(text(), 'Click for JS Confirm')]")
    public WebElement JSconfirmButton;


    @FindBy(xpath ="//button[contains(text(), 'Click for JS Confirm')]")
    public WebElement visibleText;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement JSpromtButton;

    @FindBy(id="result")
    public WebElement result;

}
