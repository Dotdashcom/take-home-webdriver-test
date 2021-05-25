package pages;

import common.POBase;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Checkboxes extends POBase {
    public void verifyCheckboxesStateAfterActions(){
        var checkbox1 = getElement(By.xpath("//input[@type='checkbox'][1]"));
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());

        var checkbox2 = getElement(By.xpath("//input[@type='checkbox'][2]"));
        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected());
    }
}
