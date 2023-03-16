package Tests;
import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControls {
    @BeforeClass
    public void setup(){
    }
    @AfterClass
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void DynamicControls(){
        Driver.getDriver().get("http://localhost:7080/dynamic_controls");
        Driver.getDriver().findElement(By.xpath("//button[.='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']")));
        assertEquals("It's gone!", Driver.getDriver().findElement(By.id("message")).getText());
        Driver.getDriver().findElement(By.xpath("//button[text()='Add']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Remove']")));
        assertEquals("It's back!", Driver.getDriver().findElement(By.id("message")).getText());
        assertTrue(Driver.getDriver().findElement(By.id("message")).isDisplayed());
        Driver.getDriver().findElement(By.xpath("//button[text()='Enable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Disable']")));
        assertTrue(Driver.getDriver().findElement(By.id("message")).getText().equals("It's enabled!"));
        System.out.println(Driver.getDriver().findElement(By.id("message")).isDisplayed());
        Driver.getDriver().findElement(By.xpath("//button[text()='Disable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Enable']")));
        assertTrue(Driver.getDriver().findElement(By.id("message")).isDisplayed());
        assertEquals("It's disabled!", Driver.getDriver().findElement(By.id("message")).getText());
    }
}
