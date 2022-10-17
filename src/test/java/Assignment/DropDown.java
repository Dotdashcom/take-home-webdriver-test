package Assignment;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDown extends TestBase {

    @Test
    public void dropDownTest(){

        driver.get(baseUrl + "/dropdown");

        WebElement dropdownMenu = driver.findElement(By.xpath("//div[@id='content']//select[@id='dropdown']"));
        dropdownMenu.click();

        Select select = new Select(dropdownMenu);

        select.selectByIndex(1);

        WebElement option1 = driver.findElement(By.xpath("//div[@id='content']//select[@id='dropdown']//option[@value='1']"));
        Assert.assertTrue(option1.isSelected(),"Selecting Option 1 FAILED");

        select.selectByIndex(2);

        WebElement option2 = driver.findElement(By.xpath("//div[@id='content']//select[@id='dropdown']//option[@value='2']"));
        Assert.assertTrue(option2.isSelected(),"Selecting Option 2 FAILED");


    }
}
