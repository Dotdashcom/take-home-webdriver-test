package homework.tests;

import homework.pages.OpenNewTabPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewWindowStepDef extends TestBase {

    OpenNewTabPage openNewTabPage=new OpenNewTabPage();

    @Test
    public void verifyNewWindowIsOpening(){

        Driver.getDriver().get("http://localhost:7080/windows");

        String mainHandle=Driver.getDriver().getWindowHandle();

        openNewTabPage.link.click();


        for (String each: Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(each);
        }

        String newWindowExpected="New Window";
        String actualTittleNewWindow=Driver.getDriver().getTitle();

        Assert.assertEquals(actualTittleNewWindow,newWindowExpected);

    }
}
