package webdrivertest;

import common.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextMenu extends Base {
    WebDriver driver;

    @Test
    public void contextMenu(){
        driver = getDriver();
        driver.get("http://localhost:7080/context_menu");
        /*
        * In order to do the right click I will use the Actions class which is basically use
        * for mouse movement and key board.
        * Then, I will create an instant of the Actions class by passing the driver to its constructor.
        * Then, I will invoke the contextClick() method by passing the webelement and
        * I will also have to invoke the perform() method
        *
        * */
        WebElement element = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions ac = new Actions(driver);
        ac.contextClick(element).perform();

        /*
        * In order to handle the pop up I am using the Alert interface.
        * Then, I am invoking accept() method which will click on the "OK" button
        * as soon as the pop up appears.
        * */
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


}
