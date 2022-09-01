package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.DropdownPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class Dropdown {
    DropdownPage dropdownPage = new DropdownPage();
    @Test()
    public void test01() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl") + "dropdown"); //Go to "http://localhost:7080/dropdown" URL
        ReusableMethods.waitForPageToLoad(3); //Page load waiting for 3 seconds

        Select dropDown = new Select(dropdownPage.dropdown);
        List<WebElement> list = dropDown.getOptions();
        for(int i=0; i<list.size(); i++){
            dropDown.selectByIndex(i);
            Assert.assertTrue(list.get(i).isSelected());
            System.out.println(("Selected Option is "+list.get(i).getText()));
        }

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
