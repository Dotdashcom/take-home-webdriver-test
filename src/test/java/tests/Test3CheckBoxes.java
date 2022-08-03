package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test3CheckBoxes {
    WebDriver driver;

    @BeforeSuite
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void Test3CheckBoxes() {
        String url = "http://localhost:7080/checkboxes";
        driver.get(url);

        //get checbox web elements
        WebElement checkBoxOne = driver.findElement(By.xpath("//div[@class='example']/descendant::input[1]"));
        WebElement checkBoxTwo = driver.findElement(By.xpath("//div[@class='example']/descendant::input[2]"));

        //check initial state
        Boolean checkBoxOneInitial = checkBoxOne.isSelected();
        Boolean checkBoxTwoInitial = checkBoxTwo.isSelected();
        Assert.assertFalse(checkBoxOneInitial);
        Assert.assertTrue(checkBoxTwoInitial);

        //toggle both checkboxes
        checkBoxOne.click();
        checkBoxTwo.click();

        //recheck there state after interaction
        Boolean checkBoxOneResult = checkBoxOne.isSelected();
        Boolean checkBoxTwoResult = checkBoxTwo.isSelected();
        Assert.assertTrue(checkBoxOneResult);
        Assert.assertFalse(checkBoxTwoResult);


    }

    @AfterMethod
    public void  tearDown() {
        driver.close();
    }
}