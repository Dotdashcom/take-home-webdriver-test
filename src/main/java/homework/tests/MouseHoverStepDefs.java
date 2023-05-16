package homework.tests;

import homework.pages.MouseHoverPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseHoverStepDefs extends TestBase {

    MouseHoverPage mouseHoverPage=new MouseHoverPage();

    @Test
    public void mouseHoverVerify(){
        Driver.getDriver().get("http://localhost:7080/hovers");

        Actions actions=new Actions(Driver.getDriver());

        actions.moveToElement(mouseHoverPage.image).perform();

        Assert.assertTrue(mouseHoverPage.textBelow.isDisplayed());
    }
}
