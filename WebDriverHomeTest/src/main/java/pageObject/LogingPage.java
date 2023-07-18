package pageObject;

import base.CommonApi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogingPage extends CommonApi {
    WebDriver driver;
   public LogingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="username")
    WebElement usernameBox;
    @FindBy(id="password")
    WebElement passwordBox;

    @FindBy(xpath="//*[@class='radius']")
    WebElement loginButton;


    @FindBy(xpath = "//*[@id='flash']")
    WebElement succesfullMessage;




    public void signin(String ussername, String password){
        usernameBox.sendKeys(ussername);
        passwordBox.sendKeys(password);
        loginButton.click();
    }
    public void goTo(){
        driver.get("http://localhost:7080/login");
    }

    public String getText(){
        String text=  succesfullMessage.getText();
        return text ;
    }
}
