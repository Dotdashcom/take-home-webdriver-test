import Pages.DropDownPage;
import Utils.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {

    DropDownPage dropPage =new DropDownPage();

    @Test
    public void DropDownTest1(){

        Driver.getDriver().get("http://localhost:7080/dropdown");

        Driver.getDriver().manage().window().maximize();


        Select element =new Select(dropPage.dropDownElement);

        element.selectByVisibleText("Option 1");

        Assert.assertEquals(element.getFirstSelectedOption().getText(),"Option 1");

        Driver.closeDriver();


    }

    @Test
    public void DropDownTest2() {

        Driver.getDriver().get("http://localhost:7080/dropdown");

        Driver.getDriver().manage().window().maximize();


        Select element = new Select(dropPage.dropDownElement);

        element.selectByVisibleText("Option 2");

        Assert.assertEquals(element.getFirstSelectedOption().getText(), "Option 2");

        Driver.closeDriver();

    }


}