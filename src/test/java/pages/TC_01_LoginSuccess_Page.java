package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_01_LoginSuccess_Page {
    public TC_01_LoginSuccess_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement Password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement clickButton;

    @FindBy(xpath = "//div[@id='flash-messages']")
    public WebElement loggedMassage;
}
