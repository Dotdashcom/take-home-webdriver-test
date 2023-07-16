package pageObject;

import base.CommonApi;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FloatingMenuPage extends CommonApi {

    WebDriver driver;
    public FloatingMenuPage(WebDriver driver){
        super(driver);
        this. driver=driver;
        PageFactory.initElements(driver,this );
    }



    public void menuBar(){
        By mySelector = By.xpath("//*[@id='menu']");
        List<WebElement> myElements = driver.findElements(mySelector);
        for(WebElement e : myElements) {
            scrollDown();
            e.isDisplayed();
        }
    }
    public String getText(){
        By mySelector = By.xpath("//*[@id='menu']");
        List<WebElement> myElements = driver.findElements(mySelector);
        for(WebElement e : myElements) {
            scrollDown();
            String text=   e.getText();
            return text;
        }

        return null;
    }







    public void goTo(){
        driver.get("http://localhost:7080/floating_menu");
    }
}
