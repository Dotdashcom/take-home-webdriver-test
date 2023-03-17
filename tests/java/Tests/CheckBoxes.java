package Tests;
import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class CheckBoxes {
    @BeforeClass
    public void setup(){
    }
    @AfterClass
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void CheckBoxes() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        Driver.getDriver().get("http://localhost:7080/checkboxes");
        WebElement box1 = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox'][1]"));
        if (!box1.isSelected()) {
        box1.click();
        Assert.assertTrue(box1.isSelected());
    } else {
        Assert.assertTrue(box1.isSelected());
    }
    WebElement box2 = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox'][2]"));
        wait.until(ExpectedConditions.visibilityOf(box2));
        Assert.assertTrue(box2.isSelected());
}
}
