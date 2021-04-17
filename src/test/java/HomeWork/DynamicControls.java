package HomeWork;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DynamicControls extends Base{

    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/dynamic_controls";
    WebDriverWait wait;
    private WebElement removeButton;
    private WebElement addButton;
    private WebElement enableButton;
    private WebElement disableButton;
    private String message;
    private WebElement msg;



    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
        wait = new WebDriverWait(driver,5);
        removeButton = driver.findElement(By.xpath("//form[@id='checkbox-example']/button"));
        addButton = driver.findElement(By.xpath("//form[@id='checkbox-example']/button"));



    }


    @Test
    public void removeAndAddButton(){

        removeButton.click();

        msg = driver.findElement(By.id("message"));

        wait.until(ExpectedConditions.visibilityOf(msg));

        message = msg.getText();

        Assert.assertEquals(message,"It's gone!");

        addButton.click();
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        wait.until(ExpectedConditions.visibilityOf(checkbox));

        String isBackMessage = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(isBackMessage,"It's back!");

    }


    @Test(dependsOnMethods = "removeAndAddButton")
    public void enableDisableField() throws InterruptedException {

        enableButton = driver.findElement(By.xpath("//form[@id='input-example']/button"));
        enableButton.click();

        WebElement enableMessage = driver.findElement(By.id("message"));

        wait.until(ExpectedConditions.visibilityOf(enableMessage));

        String enableMsgText = enableMessage.getText();

        Assert.assertEquals(enableMsgText,"It's enabled!");

        Thread.sleep(3000);

        disableButton = driver.findElement(By.xpath("//form[@id='input-example']/button"));
        disableButton.click();

        WebElement disableMessage = driver.findElement(By.id("message"));

        wait.until(ExpectedConditions.visibilityOf(disableMessage));

        String disableMsgText = disableMessage.getText();

        Assert.assertEquals(disableMsgText,"It's disabled!");

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }




}
