package pageObject;

import base.CommonApi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HoverOverPage extends CommonApi {

    WebDriver driver;
    public HoverOverPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverover(){
        By mySelector=By.xpath("//*[@class='figure']");
        List<WebElement> myElement=driver.findElements(mySelector);
        for(WebElement e: myElement) {
            Actions actions = new Actions(driver);
            actions.moveToElement(e).perform();


        }
    }
    public Object getText() throws InterruptedException {
        By mySelector=By.xpath("//*[@class='figure']");
        List<WebElement> myElement=driver.findElements(mySelector);
        for(WebElement e: myElement) {
            Actions actions=new Actions(driver);
            actions.moveToElement(e).perform();

             return e.getText();
        }

        return getText();
    }


    public void goTo(){
        driver.get("http://localhost:7080/hovers");
    }
}
