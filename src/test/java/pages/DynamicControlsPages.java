package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPages extends PageBase {

    @FindBy(xpath = "//*[@onclick='swapCheckbox()']")
    protected WebElement removeButton;

    @FindBy(xpath = "//*[@type='checkbox']")
    protected WebElement checkBox;

    @FindBy(xpath = "//*[@id='message']")
    protected WebElement checkBoxMessage;


}
