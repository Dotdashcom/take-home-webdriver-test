package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Test15JavaScriptAlerts extends GenericTest {

    @Test
    public void Test15JavaScriptAlerts() {
        String url = "http://localhost:7080/javascript_alerts";
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        By clickJsAlertXpath = By.xpath("//div[@class='example']/descendant::ul/li/button[text()='Click for JS Alert']");
        By clickJsConfirmXpath = By.xpath("//div[@class='example']/descendant::ul/li/button[text()='Click for JS Confirm']");
        By clickJsPromptXpath = By.xpath("//div[@class='example']/descendant::ul/li/button[text()='Click for JS Prompt']");
        By resultLabelXpath = By.xpath("//div[@class='example']/descendant::p[@id='result']");

        driver.findElement(clickJsAlertXpath).click();
        //switch context to js alert and grab text
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();
        driver.switchTo().defaultContent();

        driver.findElement(clickJsConfirmXpath).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.accept();
        driver.switchTo().defaultContent();
        Assert.assertEquals(driver.findElement(resultLabelXpath).getText(),"You clicked: Ok");

        driver.findElement(clickJsPromptXpath).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Hello World!");
        alert.accept();
        driver.switchTo().defaultContent();
        Assert.assertEquals(driver.findElement(resultLabelXpath).getText(),"You entered: Hello World!");

    }

}