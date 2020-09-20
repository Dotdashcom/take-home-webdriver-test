package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;
import utils.Driver;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;

public class DropDownListTests extends TestBase {

    String url="dropdown";


    @Test
    public void selectFirstOption(){
        Driver.setUp(url);
        Assert.assertTrue(driver.getCurrentUrl().contains("dropdown"));
        Select select=new Select(driver.findElement(By.id("dropdown")));

        List<WebElement>lst=select.getOptions();

        select.selectByIndex(1);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals(lst.get(1).getText()));

        select.selectByIndex(2);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals(lst.get(2).getText()));
    }


}
