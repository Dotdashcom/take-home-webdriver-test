package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='username']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//button[@class='radius']")
    WebElement button;
    @FindBy(xpath = "//div//div[@class='flash success']")
    WebElement successMessage;

    public void enterDetails(String username, String pass) {
        //can be provided through configreader/dataprovider
        userName.sendKeys(username);
        password.sendKeys(pass);
        button.click();
    }

    public String message() {
        return successMessage.getText();
    }
}
