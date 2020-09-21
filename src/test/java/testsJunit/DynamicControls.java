package testsJunit;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import static org.junit.Assert.assertEquals;


public class DynamicControls extends BaseClass {
    //I am on the Dynamic Controls page
    //I click on the Remove Button
    //I verify the checkbox is gone
    //I click Add Button
    //I assert that the checkbox is present
    //I click on the Enanble Button
    //I assert that the text box is enabled
    //I click on the Disable Button
    //I assert that the box is disabled

    @Test
    public void dynamicControls_page() {
        Driver.getDriver().get("http://localhost:7080/dynamic_controls");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().findElement(By.xpath("//button[text()='Remove']")).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']")));
        String expected1 = "It's gone!";
        String actual1 = Driver.getDriver().findElement(By.id("message")).getText();

        assertEquals(expected1, actual1);
        System.out.println("The Checkbox " + actual1);
        System.out.println(Driver.getDriver().findElement(By.id("message")).isDisplayed());

        Driver.getDriver().findElement(By.xpath("//button[text()='Add']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Remove']")));

        String expected2 = "It's back!";
        String actualtext2 = Driver.getDriver().findElement(By.id("message")).getText();

        assertEquals(expected2, actualtext2);
        System.out.println("The Checkbox " + actualtext2);
        System.out.println(Driver.getDriver().findElement(By.id("message")).isDisplayed());

        Driver.getDriver().findElement(By.xpath("//button[text()='Enable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Disable']")));

        String expected3 = "It's enabled!";
        String actualtext3 = Driver.getDriver().findElement(By.id("message")).getText();
        assertEquals(expected3, actualtext3);
        System.out.println("The text box " + actualtext3);
        System.out.println(Driver.getDriver().findElement(By.id("message")).isDisplayed());

        Driver.getDriver().findElement(By.xpath("//button[text()='Disable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Enable']")));

        String expected4 = "It's disabled!";
        String actualtext4 = Driver.getDriver().findElement(By.id("message")).getText();
        Driver.getDriver().findElement(By.id("message")).isDisplayed();
        assertEquals(expected4, actualtext4);
        System.out.println("The text box " + actualtext4);
        System.out.println(Driver.getDriver().findElement(By.id("message")).isDisplayed());
    }
}
