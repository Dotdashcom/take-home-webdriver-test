package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

public abstract class BasePage {

    public WebDriver driver = Driver.get();

    public BasePage() {
        //this method requires to provide webdriver object for @FindBy
        //and page class
        //this means this page class
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateTo(String page){
        String url = ConfigurationReader.getProperty("baseUrl")+page;
        driver.get(url);
    }

    public String getAlertMessage(){
        Alert alert     = Driver.get().switchTo().alert();
        String message  = alert.getText();
        //driver.switchTo().defaultContent();

        return message;
    }
}
