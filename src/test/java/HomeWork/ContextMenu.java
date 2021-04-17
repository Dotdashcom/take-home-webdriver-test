package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContextMenu extends Base{

    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/context_menu";
    private WebElement contextMenu;
    private Actions action;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
        contextMenu = driver.findElement(By.id("hot-spot"));
       action = new Actions(driver);
    }


    @Test
    public void contextMenuCheck(){

        action.moveToElement(contextMenu).contextClick().build().perform();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",alertText);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
