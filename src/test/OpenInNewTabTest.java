package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;

import java.util.Set;
@Test
public class OpenInNewTabTest extends CommonMethods {
    public static void main(String[]args){
        setUp("http://localhost:7080/windows");

        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        Set<String> handles = driver.getWindowHandles();
        for(String handle:handles) {
            driver.switchTo().window(handle); //switching focus on a new opened tab
        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "New Window";

        Assert.assertEquals(actualTitle, expectedTitle, "Test is failed. The text is not displayed in new tab");
        System.out.println("Test is passed. A new tab is opened with the text 'New Window'");

            tearDown();
        }
    }

