package Test;

import Utilities.DriverHelper;
import Main.MouseHoverPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseHoverTest {

    MouseHoverPage hover= new MouseHoverPage();

    @Test
    public void HoverTest() throws InterruptedException {

        DriverHelper.getDriver().get("http://localhost:7080/hovers");

        DriverHelper.getDriver().manage().window().maximize();

        Actions actions = new Actions(DriverHelper.getDriver());

        Thread.sleep(2);
        actions.moveToElement(hover.picture1).perform();


        Assert.assertTrue(hover.picture1.isDisplayed(),"name: user1");

        Thread.sleep(2);
        actions.moveToElement(hover.picture3).perform();


        Assert.assertTrue(hover.picture3.isDisplayed(),"name: user3");


        Thread.sleep(2);
        actions.moveToElement(hover.picture2).perform();


        Assert.assertTrue(hover.picture2.isDisplayed(),"name: user2");

        DriverHelper.closeDriver();


    }




}