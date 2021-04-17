package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DropDown extends Base{

    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/dropdown";
    Select dropdown;
    private WebElement dropDownId;


    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
        dropDownId = driver.findElement(By.id("dropdown"));
        dropdown = new Select(dropDownId);
    }


    @Test
    public void dropDown(){

        dropdown.selectByIndex(1);
        boolean opt1 = driver.findElement(By.xpath("//option[@value='1']")).isSelected();
        Assert.assertEquals(true,opt1);


        dropdown.selectByIndex(2);
        boolean opt2 = driver.findElement(By.xpath("//option[@value='2']")).isSelected();
        Assert.assertEquals(true,opt1);


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}
