package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {
    public WebDriver driver;

    public DynamicControlsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@onclick='swapCheckbox()']")
    private WebElement buttonCheckbox;
    @FindBy(id = "checkbox")
    private WebElement checkbox;

    @FindBy(xpath = "//button[@onclick='swapInput()']")
    private WebElement buttonInput;

    @FindBy(xpath = "//form[@id='input-example']//input")
    private WebElement inputText;



    public void clickButtonCheckbox(){
        Helpers.ClickElement(buttonCheckbox);
    }

    public void clickButtonInput(){
        Helpers.ClickElement(buttonInput);
    }
    public boolean validateCheckboxExist() throws InterruptedException {
Thread.sleep(4000);
        return Helpers.ElementIsPresent(checkbox);
    }

    public boolean validateInputEnabled() throws InterruptedException {
        Thread.sleep(4000);
        return Helpers.ElementIsEnabled(inputText);
    }


}
