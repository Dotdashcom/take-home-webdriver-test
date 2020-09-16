package pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public abstract class PageBase {

    WebDriver driver = Driver.getDriver();
   // WebDriverWait wait = new WebDriverWait(driver, 25);
    Actions actions = new Actions(driver);
    Alert alert;


    public PageBase() {
        PageFactory.initElements(driver, this);
    }

    public void NavigateTo(String str){
        driver.get("http://localhost:7080");
        BrowserUtils.waitForPageToLoad(5);
        WebElement elem = driver.findElement(By.xpath("//*[text()='"+str+"']"));
        elem.click();
        BrowserUtils.waitForPageToLoad(5);
    }
    public void getConnection(String str){
        driver.get(ConfigurationReader.getProperty(str));
        BrowserUtils.waitForPageToLoad(5);
    }

}