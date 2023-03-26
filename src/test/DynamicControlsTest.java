package test;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;
@Test
public class DynamicControlsTest extends CommonMethods {
    public static void main(String []args){
        setUp("http://localhost:7080/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(), 'Remove')]"));
        removeButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'gone')]")));
        WebElement itsGoneText = driver.findElement(By.xpath("//p[contains(text(), 'gone')]"));
        System.out.println(itsGoneText.getText());

        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(), 'Add')]"));
        addButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'back')]")));
        WebElement itsPresentText = driver.findElement(By.xpath("//p[contains(text(), 'back')]"));
        System.out.println(itsPresentText.getText());

        WebElement enableButton = driver.findElement(By.xpath("//button[contains(text(), 'Enable')]"));
        enableButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'enabled')]")));
        WebElement itsEnabled = driver.findElement(By.xpath("//p[contains(text(), 'enabled')]"));
        System.out.println(itsEnabled.getText());

        WebElement disableButton = driver.findElement(By.xpath("//button[contains(text(), 'Disable')]"));
        disableButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'disabled')]")));
        WebElement itsDisabledText = driver.findElement(By.xpath("//p[contains(text(), 'disabled')]"));
        System.out.println(itsDisabledText.getText());

        tearDown();

    }
}
