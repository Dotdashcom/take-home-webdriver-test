package webdrivertest;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownList extends Base {
    WebDriver driver;
    @Test
    public void dropDownList(){
        driver = getDriver();
        driver.get("http://localhost:7080/dropdown");
        /*
        * In order to do the drop down I used the Select class of Selenium WebDriver.
        * First, I have instantiated the Select class by passing the element to its constructor.
        * Then, I have invoked the selectByVisibleText() method to select an option based on the
        * text over the option which is "Option1"
        * */

        WebElement element = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select sc = new Select(element);
        sc.selectByVisibleText("Option 1");

    }
}
