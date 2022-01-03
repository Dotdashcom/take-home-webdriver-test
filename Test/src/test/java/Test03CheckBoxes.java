import pageObject.CheckBoxesPage;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Test03CheckBoxes extends TestBase{
    CheckBoxesPage checkBoxesPage;

    String checkbox1Xpath = "//input[@type='checkbox'][1]";
    String checkbox2Xpath = "//input[@type='checkbox'][2]";

    @Test
    public void test03CheckBoxes(){
        // by default, checkbox 1 is unchecked, checkbox 2 is checked

        checkBoxesPage = new CheckBoxesPage(webDriver);
        WebElement checkbox1 = webDriver.findElement(By.xpath(checkbox1Xpath));
        WebElement checkbox2 = webDriver.findElement(By.xpath(checkbox2Xpath));

        Assert.assertFalse(checkBoxesPage.ischecked(checkbox1));
        checkBoxesPage.check(checkbox1);
        Assert.assertTrue(checkBoxesPage.ischecked(checkbox1));

        Assert.assertTrue(checkBoxesPage.ischecked(checkbox2));
        checkBoxesPage.uncheck(checkbox2);
        Assert.assertFalse(checkBoxesPage.ischecked(checkbox2));
    }

}