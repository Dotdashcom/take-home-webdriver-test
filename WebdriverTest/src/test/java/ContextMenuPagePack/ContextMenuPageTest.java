package ContextMenuPagePack;
import Main.Package.ContextMenuPage;
import bsh.util.JConsole;
import org.asynchttpclient.util.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ContextMenuPageTest {
    private WebDriver driver;
    private ContextMenuPage contextMenuPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/context_menu");
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
    }

    @Test
    public void AlertOpenAndAccept() {
        WebElement Box = driver.findElement(By.xpath("//div[@id='hot-spot']"));

        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(Box);
            actions.contextClick(Box).sendKeys(Keys.ARROW_DOWN).perform();
            driver.switchTo().alert().accept();


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test
    public void AssertAlertText() {
        WebElement Box = driver.findElement(By.xpath("//div[@id='hot-spot']"));

        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(Box);
            actions.contextClick(Box).sendKeys(Keys.ARROW_DOWN).perform();
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            String expectedAlertText = "You selected a context menu";
            System.out.println(alertText);
            Assert.assertEquals("You selected a context menu", alertText);


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @After
    public void TearDown() {
        driver.quit();
    }
}
