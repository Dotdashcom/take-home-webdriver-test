package Tests;

import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class DragAndDrop {
    @BeforeTest
    public void setup(){
    }
    @AfterTest
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void DragAndDrop() {
        Driver.getDriver().get("http://localhost:7080/drag_and_drop");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains("/drag_and_drop"));
        WebElement source = Driver.getDriver().findElement(By.xpath("(//div[@draggable=\"true\"])[1]"));     //   "//div[@id='column-a']"));
        WebElement target = Driver.getDriver().findElement(By.xpath("(//div[@draggable=\"true\"])[2]"));
        int xOffset = source.getLocation().getX();
        int yOffset = target.getLocation().getY();
        Actions action = new Actions(Driver.getDriver());
        action.dragAndDropBy(source, xOffset, yOffset).build().perform();
        String textTarget = target.getText();
        if (textTarget.equals("A")) {
            assertTrue("Image switched", true);
        } else {
            System.err.println("Image is not switched");
        }
    }
}
