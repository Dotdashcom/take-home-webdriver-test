package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_02_LoginFailure_Page {
    public TC_02_LoginFailure_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='username']")
    public WebElement userNameWrong;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordWrong;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement clickButtonWrong;

    @FindBy(xpath = "//div[@id='flash']")
    public WebElement failMessage;
}
