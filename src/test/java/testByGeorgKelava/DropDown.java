package testByGeorgKelava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    public DropDown() {
    }

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "/dropdown");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }



    @Test
    public void dropDownBySelect() {
        WebElement dropdownList = Driver.get().findElement(By.id("dropdown"));
        Select select = new Select(dropdownList);
        List<WebElement> options = select.getOptions();
        System.out.println("options.size() = " + options.size());
        Iterator iterator = options.iterator();

        while(iterator.hasNext()) {
            WebElement option = (WebElement)iterator.next();
            System.out.println(option.getText());
        }

        ((WebElement)options.get(0)).click();
        String option1 = ((WebElement)options.get(0)).getText();
        System.out.println("option1 = " + option1);
        ((WebElement)options.get(1)).click();
        String option2 = ((WebElement)options.get(1)).getText();
        System.out.println("option2 = " + option2);
        ((WebElement)options.get(2)).click();
        String option3 = ((WebElement)options.get(2)).getText();
        System.out.println("option3 = " + option3);
        Assert.assertEquals(option1, "Please select an option");
        Assert.assertEquals(option2, "Option 1");
        Assert.assertEquals(option3, "Option 2");
    }
}
