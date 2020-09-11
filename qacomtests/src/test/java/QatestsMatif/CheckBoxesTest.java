package QatestsMatif;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browserUtil.Driver;
import java.util.concurrent.TimeUnit;

public class CheckBoxesTest {


    @BeforeMethod
    public void setUpMethod(){
        Driver.get().get(browserUtil.ConfigReader.get("baseUrl") + "/checkboxes");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }


    @Test
    public void checkAndUncheckBoxesTest(){

        WebElement chkB0 = Driver.get().findElement(By.xpath("//input[1]"));
        WebElement chkB1 = Driver.get().findElement(By.xpath("//input[2]"));


        System.out.println("checkBox1.isSelected() = " + chkB0.isSelected());
        System.out.println("checkBox2.isSelected() = " + chkB1.isSelected());


        Assert.assertFalse(chkB0.isSelected(),"Verify checkbox 1 is NOT selected");
        Assert.assertTrue(chkB1.isSelected(),"Verify checkbox 2 is selected");


        chkB0.click();
        chkB1.click();

        Assert.assertTrue(chkB0.isSelected(),"Verify checkbox 1 is selected");
        Assert.assertFalse(chkB1.isSelected(),"Verify checkbox 2 is selected");
        System.out.println("checkBox1.isSelected() = " + chkB0.isSelected());
        System.out.println("checkBox2.isSelected() = " + chkB1.isSelected());

    }


}
