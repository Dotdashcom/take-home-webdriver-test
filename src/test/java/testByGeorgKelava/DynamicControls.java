package testByGeorgKelava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class DynamicControls {
    public DynamicControls() {
    }

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "dynamic_controls");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }


    @Test
    public void dynamicControlsRemoveAdd() {
        WebElement removeAddButton = Driver.get().findElement(By.cssSelector("button[type='button'][onclick='swapCheckbox()']"));
        removeAddButton.click();
        WebElement textBox = Driver.get().findElement(By.xpath("//p[@id='message']"));
        WebDriverWait wait = new WebDriverWait(Driver.get(), 15L);
        wait.until(ExpectedConditions.visibilityOf(textBox));
        String expectedText = "It's gone!";
        System.out.println("expectedText = " + expectedText);
        String actualText = textBox.getText();
        System.out.println("actualText = " + actualText);
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @Test
    public void dynamicControlsEnableDisable() {
        WebElement enableOrdisable = Driver.get().findElement(By.xpath("//form[@id='input-example']/button"));
        enableOrdisable.click();
        WebElement box = Driver.get().findElement(By.xpath("//form[@id='input-example']/input[@type='text']"));
        WebDriverWait wait = new WebDriverWait(Driver.get(), 15L);
        wait.until(ExpectedConditions.elementToBeClickable(box));
        box.sendKeys(new CharSequence[]{"Test dynamic content"});
        String expectedText = "It's enabled!";
        String actualText = Driver.get().findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }
}
