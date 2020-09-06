package assessmentMkaya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTest {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/dropdown");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }

    //Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
    @Test
    public void dropDownBySelect() {

        WebElement dropdownList = Driver.get().findElement(By.id("dropdown"));

        Select select = new Select(dropdownList);

        //getOptions --> returns all the available options from the dropdown list
        List<WebElement> options = select.getOptions();

        //print size of the options
        System.out.println("options.size() = " + options.size());
        //print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        options.get(0).click();
        String optionZero = options.get(0).getText();
        System.out.println("optionZero = " + optionZero);
        options.get(1).click();
        String optionOne = options.get(1).getText();
        System.out.println("optionOne = " + optionOne);
        options.get(2).click();
        String optionTwo = options.get(2).getText();
        System.out.println("optionTwo = " + optionTwo);

        Assert.assertEquals(optionZero, "Please select an option");
        Assert.assertEquals(optionOne, "Option 1");
        Assert.assertEquals(optionTwo, "Option 2");

    }


}
