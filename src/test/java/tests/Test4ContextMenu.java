package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test4ContextMenu {
    WebDriver driver;

    @BeforeSuite
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void Test4ContextMenu() {
        String url = "http://localhost:7080/context_menu";
        String alertTextKey = "You selected a context menu";
        driver.get(url);

        //build action that performs a context click
        Actions contextClickAction = new Actions(driver);
        WebElement contextMenu = driver.findElement(By.xpath("//div[contains(@id,'hot-spot')]"));
        contextClickAction.contextClick(contextMenu).sendKeys(Keys.ENTER).build().perform();

        //switch context to js alert and grab text
        Alert alert = driver.switchTo().alert();
        Boolean isAlertTextPresent = alert.getText().contains(alertTextKey);

        Assert.assertTrue(isAlertTextPresent);

        //get rid of alert and then get rid of the context menu
        alert.accept();
        contextMenu.click();
    }

    @AfterMethod
    public void  tearDown() {
        driver.quit();
    }
}