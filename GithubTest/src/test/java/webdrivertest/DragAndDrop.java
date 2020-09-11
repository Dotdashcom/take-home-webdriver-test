package webdrivertest;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop extends Base {
    WebDriver driver;
    @Test
    public void dragAndDrop(){
        driver = getDriver();
        driver.get("http://localhost:7080/drag_and_drop");

        WebElement source = driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='column-b']"));

        /*
        * In order to do the drag and drop I used the Actions class which is for
        * mouse movement and keyboard.
        * First, I have instantiate the action class by passing driver to its constructor.
        * Then, I have invoked the dragAndDrop() method by passing the source and target webelemnts.
        * Finally, I have used build and perform to execute all the steps.
        * */

        Actions ac = new Actions(driver);
        ac.dragAndDrop(source, target).build().perform();

    }
}
