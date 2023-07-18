package pageObject;

import base.CommonApi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends CommonApi {
    WebDriver driver;
    public DynamicLoadingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='start']//child::button")
    WebElement startButton;

    @FindBy(xpath = "//*[@id='finish']//child::h4")
    WebElement message;

    public void clickSatrtButton(){
        startButton.click();
        waitForWebElementToAppear(message);
    }

    public String getText(){
        return message.getText();
    }


    public void goTo(){driver.get("http://localhost:7080/dynamic_loading/2");}
}
