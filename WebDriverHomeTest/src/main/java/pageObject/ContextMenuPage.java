package pageObject;

import base.CommonApi;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends CommonApi {
    WebDriver driver;
    public ContextMenuPage( WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//*[@id='hot-spot']")
    WebElement CtxMenu;


    public void rightclick(){

        Actions action = new Actions(driver);
        action.moveToElement(CtxMenu).contextClick().build().perform();
    }

    public String textAlert() throws InterruptedException {
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        return alertText;
    }

    public void switchAlert() throws InterruptedException {
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }


    public void goTo(){
        driver.get(" http://localhost:7080/context_menu");
    }
}


