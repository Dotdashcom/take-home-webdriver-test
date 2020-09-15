package testsDotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;
import java.util.concurrent.TimeUnit;

public class CheckBoxes {
    @BeforeMethod
    public void setUpMethod(){
        Driver.get().get(ConfigurationReader.get("baseUrl") + "/checkboxes");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }


    @Test
    public void CheckBoxes(){

        WebElement checkBox1 = Driver.get().findElement(By.xpath("//input[1]"));
        WebElement checkBox2 = Driver.get().findElement(By.xpath("//input[2]"));

        System.out.println("CheckBox1 Selected = " + checkBox1.isSelected());
        System.out.println("CheckBox2 Selected = " + checkBox2.isSelected());

        Assert.assertFalse(checkBox1.isSelected(),"Checkbox1 isn't selected");
        Assert.assertTrue(checkBox2.isSelected(),"Checkbox2 is selected");

        checkBox1.click();
        checkBox2.click();

        Assert.assertTrue(checkBox1.isSelected(),"Checkbox1 is selected");
        Assert.assertFalse(checkBox2.isSelected(),"Checkbox2 isn't selected");
        System.out.println("CheckBox1 Selected = " + checkBox1.isSelected());
        System.out.println("CheckBox2 Selected = " + checkBox2.isSelected());

    }
}
