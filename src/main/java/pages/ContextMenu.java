package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ContextMenu {

    private WebDriver driver;
    private SoftAssert softAssert;

    public ContextMenu(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="hot-spot")
    private WebElement box;

    public void checkAlertWindow()  {
        navigateToContextPage();
        Actions action = new Actions(driver);
        action.contextClick(box).perform();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    private void navigateToContextPage(){
        driver.get(ConfigReader.getProperty("url")+"/context_menu");
    }

}
