package MarionelaTirsina;

import MarionelaTirsina.pages.CheckBoxes;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import utilities.ConfigurationReader;
import utilities.Driver;
import java.util.concurrent.TimeUnit;

public class CheckBoxesTest {
    //CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
    CheckBoxes checkBoxes=new CheckBoxes();
    @Before
    public void setUpMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/checkboxes");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }



    @Test
    public void checkAndUncheckBoxesTest(){

        WebElement box1 =checkBoxes.checkBox1;
        WebElement box2 = checkBoxes.checkBox2;


        System.out.println("checkBox1 is Selected  =" + box1.isSelected());
        System.out.println("checkBox2 is selected  = " + box2.isSelected());


        Assert.assertFalse("Verify checkbox 1 is NOT selected",box1.isSelected());
        Assert.assertTrue("Verify checkbox 2 is selected",box2.isSelected());


        box1.click();
        box2.click();

        Assert.assertTrue("Verify checkbox 1 is selected",box1.isSelected());
        Assert.assertFalse("Verify checkbox 2 is  selected",box2.isSelected());
        System.out.println("checkBox1.isSelected() = " + box1.isSelected());
        System.out.println("checkBox2.isSelected() = " + box2.isSelected());

    }
}
