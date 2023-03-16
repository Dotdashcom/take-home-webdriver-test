package Tests;
import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Dropdown {
    @BeforeClass
    public void setup(){
    }
    @Test
    public void Dropdown() {
        Driver.getDriver().get("http://localhost:7080/dropdown");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.id("dropdown"))));
        Select selectObj = new Select(Driver.getDriver().findElement(By.id("dropdown")));
        Assert.assertEquals(selectObj.getFirstSelectedOption().getText(), "Please select an option");
        selectObj.selectByVisibleText("Option 1");
        Assert.assertTrue(selectObj.getFirstSelectedOption().getText().equals("Option 1"));
        selectObj.selectByIndex(2);
        Assert.assertEquals(selectObj.getFirstSelectedOption().getText(), "Option 2");
    }
    @AfterClass
    public void teardown() {
        Driver.closeDriver();
    }
}