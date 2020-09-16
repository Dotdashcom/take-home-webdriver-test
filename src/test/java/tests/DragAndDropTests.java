package tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Driver;

public class DragAndDropTests extends TestBase {

    /**
     * 5. Drag and Drop
     *
     * Test drags element A to element B.
     * Test asserts that the text on element A and B are switched.
     * @throws InterruptedException
     */
    @Test
    @DisplayName("Verify drag and drop function.")
    public void dragAndDropTest() throws InterruptedException {
        Driver.getDriver().findElement(By.linkText("Drag and Drop")).click();

        WebElement elementA = Driver.getDriver().findElement(By.id("column-a"));
        WebElement elementB = Driver.getDriver().findElement(By.id("column-b"));

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(elementA, elementB).pause(1000).release().perform();

        Thread.sleep(2000);
        Assertions.assertEquals(elementA.getText(), "B", "Drag and Drop failed!");
        Assertions.assertEquals(elementB.getText(), "A", "Drag and Drop failed!");

    }
}
