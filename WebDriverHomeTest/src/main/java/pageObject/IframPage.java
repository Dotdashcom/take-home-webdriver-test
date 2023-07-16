package pageObject;

import base.CommonApi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframPage extends CommonApi {
    WebDriver driver;
    public IframPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@class='tox-icon']")
    WebElement exitAlert;
    @FindBy(xpath = "//*[@id='tinymce']")
    WebElement textBox;

    public void closeAlert(){
        exitAlert.click();
        driver.switchTo().frame(0);

    }
    public void cleartextBox(){
        textBox.clear();
    }
    public String sendText(){
        textBox.sendKeys("I have 6 years experience in automation");
        return textBox.getText();


    }

    public void goTo(){
        driver.get("http://localhost:7080/iframe");
    }
}
