package webdrivertestpages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContextMenu{
    WebDriver driver;
    Alert alert;

    @FindBy(xpath = "//div[@id='hot-spot']")
    WebElement element;

    public ContextMenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void contextMenu(){
        Actions ac = new Actions(driver);
        ac.contextClick(element).perform();
    }

    public String alertHandler(){
        alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.accept();
        return message;

    }

}
