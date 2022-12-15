package Test;

import Utilities.DriverHelper;
import Main.OpenNewTabPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class OpenNewTabTest {

    OpenNewTabPage opn =new OpenNewTabPage();

    @Test
    public void OpenWindowTest()  {

        DriverHelper.getDriver().get("http://localhost:7080/windows");

        DriverHelper.getDriver().manage().window().maximize();


        DriverHelper.getDriver().getWindowHandles();

        Set<String> allWindowHandles = DriverHelper.getDriver().getWindowHandles();

        for(String each: allWindowHandles){

            DriverHelper.getDriver().switchTo().window(each);
            System.out.println("Current title while switching windows: " + DriverHelper.getDriver().getTitle());

        }


        Assert.assertEquals(DriverHelper.getDriver().getTitle(),"New Window");


        DriverHelper.closeDriver();

    }




}