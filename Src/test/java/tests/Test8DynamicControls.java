package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;


public class Test8DynamicControls extends chromedriver {

    @Test
    public void Test8DynamicControls() {
        String url = "http://localhost:7080/dynamic_controls";
        driver.get(url);

        By removeAddCheckbox = By.xpath("//form[@id='checkbox-example']/descendant::input[@label='blah']");
        By removeAddButton = By.xpath("//form[@id='checkbox-example']/button");
        By removeAddLoader = By.xpath("//form[@id='checkbox-example']/div[@id='loading']");
        By removeAddMessage = By.xpath("//form[@id='checkbox-example']/p[@id='message']");
        By inputTextBox = By.xpath("//form[@id='input-example']/descendant::input");
        By inputButton = By.xpath("//form[@id='input-example']/descendant::button");
        By inputLoader = By.xpath("//form[@id='input-example']/div[@id='loading']");
        By inputMessageEnabled = By.xpath("//form[@id='input-example']/p[contains(text(),'enabled')]");
        By inputMessageDisabled = By.xpath("//form[@id='input-example']/p[contains(text(),'disabled')]");


        WebDriverWait wait = new WebDriverWait(driver, 15);

        WebElement raButton = driver.findElement(removeAddButton);
        raButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(removeAddLoader));
        String raMessageString = driver.findElement(removeAddMessage).getText();
        Assert.assertEquals(raMessageString,"It's gone!");

        raButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(removeAddLoader));
        String raMessageStringTwo = driver.findElement(removeAddMessage).getText();
        Assert.assertEquals(raMessageStringTwo,"It's back!");

        WebElement inButton = driver.findElement(inputButton);
        inButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputMessageEnabled));
        WebElement inTextbox = driver.findElement(inputTextBox);
        Assert.assertTrue(inTextbox.isEnabled());

        inButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputMessageDisabled));
        Assert.assertFalse(inTextbox.isEnabled());


    }

}