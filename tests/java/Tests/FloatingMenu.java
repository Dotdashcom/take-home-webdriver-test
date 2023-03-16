package Tests;

import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FloatingMenu {
    @BeforeTest
    public void setup(){
    }
    @AfterTest
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void FloatingMenu(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        Driver.getDriver().get("http://localhost:7080/floating_menu");
        WebElement elemental = Driver.getDriver().findElement(By.xpath("//a[.='Elemental Selenium']"));
        wait.until(ExpectedConditions.visibilityOf(elemental));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", Driver.getDriver().
                findElement(By.xpath("//a[.='Elemental Selenium']")));
        assertTrue(Driver.getDriver().
                findElement(By.xpath("//*[@id='menu']")).isDisplayed());
        assertTrue(Driver.getDriver().
                findElement(By.xpath("//*[@id='menu']")).isDisplayed());
    }
}
