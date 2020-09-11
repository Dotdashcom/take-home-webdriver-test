package webdrivertest;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover extends Base {
    WebDriver driver;

    @Test
    public void mouseHover(){
        driver = getDriver();
        driver.get("http://localhost:7080/hovers");

        /*
        * For mouse hover I am using Actions class of Selenium Webdriver.
        * First, I instantiated Actions class by passing driver to its constructor.
        * Then I invoked moveToElement() method by passing the target element.
        * Finally, I used build() and perform() method execute all steps.
        *
        * */

        WebElement target1 = driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]"));
       // WebElement target2 = driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]"));
       // WebElement target3 = driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]"));

        Actions ac = new Actions(driver);
        ac.moveToElement(target1).build().perform();
    }
}
