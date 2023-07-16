package pageObject;

import base.CommonApi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;


public class OpenInNewTabPage extends CommonApi {
    WebDriver driver;
    public OpenInNewTabPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//*[text()='Click Here']")
    WebElement clickHer;

    @FindBy(xpath  ="//*[@class='example']")
    WebElement message;

    public void clickTheLink(){
        clickHer.click();
        Set<String> windowhandles=driver.getWindowHandles();
        System.out.println(windowhandles);
        Iterator<String> iterator=  windowhandles.iterator();
        String parentwindow=iterator.next();
        System.out.println(parentwindow);
        String childwindow= iterator.next();
        driver.switchTo().window(childwindow);


    }
    public String getMessage(){
       return message.getText();

    }

    public void goTO(){
        driver.get("http://localhost:7080/windows");
    }
}
