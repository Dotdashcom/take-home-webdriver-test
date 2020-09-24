package MarionelaTirsina.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.FindBy;

public class DynamicControls extends BasePage {
    @FindBy(css = "button[type='button'][onclick='swapCheckbox()']")
    public WebElement removeAddButton;

    @FindBy(xpath = "//p[@id='message']")
    public WebElement textBox;

    @FindBy(xpath ="//form[@id='input-example']/button")
    public WebElement enableDisable;

    @FindBy(xpath = "//form[@id='input-example']/input[@type='text']")
    public WebElement inputBox;

    @FindBy(xpath = "//p[@id='message']")
    public WebElement getInputBox;
}
