package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverUtilities;

public class Dropdown extends DriverUtilities {

    @Before
    public void setUp(){
        createDriver();
        getDriver().navigate().to("http://localhost:7080/dropdown");
    }
    @Test
    public void dropdown(){
        WebDriver driver = getDriver();

        WebElement pageTitle = driver.findElement(By.xpath("//h3[contains(text(),'Dropdown List')]"));
        Assert.assertTrue("User is not on dropdown page", pageTitle.isDisplayed());

        WebElement dropdown = driver.findElement(By.cssSelector("select#dropdown"));

        Select select = new Select(dropdown);
        select.selectByIndex(1);
        WebElement option1 = driver.findElement(By.xpath("(//select[@id='dropdown']/option)[2][@selected]"));

        Assert.assertTrue(option1.isSelected());

        select.selectByIndex(2);

        WebElement option2 = driver.findElement(By.xpath("(//select[@id='dropdown']/option)[3][@selected]"));

        Assert.assertTrue(option2.isSelected());

    }
    @After
    public void cleanUp() {
        quitDriver();
    }

}
