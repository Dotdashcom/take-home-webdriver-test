package Test;

import Utilities.DriverHelper;
import Main.DropDownPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {

    DropDownPage dropPage =new DropDownPage();

    @Test
    public void DropDownTest1(){

        DriverHelper.getDriver().get("http://localhost:7080/dropdown");

        DriverHelper.getDriver().manage().window().maximize();


        Select element =new Select(dropPage.dropDownElement);

        element.selectByVisibleText("Option 1");

        Assert.assertEquals(element.getFirstSelectedOption().getText(),"Option 1");

        DriverHelper.closeDriver();


    }

    @Test
    public void DropDownTest2() {

        DriverHelper.getDriver().get("http://localhost:7080/dropdown");

        DriverHelper.getDriver().manage().window().maximize();


        Select element = new Select(dropPage.dropDownElement);

        element.selectByVisibleText("Option 2");

        Assert.assertEquals(element.getFirstSelectedOption().getText(), "Option 2");

        DriverHelper.closeDriver();

    }


}
