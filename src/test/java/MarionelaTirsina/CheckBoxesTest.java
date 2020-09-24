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
    /**
     *     CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
     */
    CheckBoxes checkBoxes=new CheckBoxes();
    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/checkboxes");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }



    @Test
    public void checkAndUncheckBoxesTest(){

        WebElement checkBox1 =checkBoxes.checkBox1;
        WebElement checkBox2 = checkBoxes.checkBox2;
//verifying if checkBoxes are enable
        System.out.println("checkBox1.isEnabled() = " + checkBox1.isEnabled());
        System.out.println("checkBox2.isEnabled() = " + checkBox2.isEnabled());
        Assert.assertTrue("Verify checkbox 1 is Enable",checkBox1.isEnabled() );
        Assert.assertTrue("Verify checkbox 2 is Enable",checkBox2.isEnabled());
//by default checkBox2 is selected
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());
        Assert.assertFalse("Verify checkbox 1 is NOT SELECTED",checkBox1.isSelected());
        Assert.assertTrue("Verify checkbox 2 is SELECTED",checkBox2.isSelected());
//now i click to make it first selected, and second unselected
    checkBox1.click();
       checkBox2.click();

        Assert.assertTrue("Verify checkbox 1 IS SELECTED",checkBox1.isSelected());
        Assert.assertFalse("Verify checkbox 2 IS NOT SELECTED",checkBox2.isSelected());
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());
    }
}
