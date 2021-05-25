package pages;

import common.POBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdown extends POBase {
    public void selectVerifyOptions(){
        Select dropdown = new Select(getElement(By.id("dropdown")));
        String option1 = "Option 1";
        dropdown.selectByVisibleText(option1);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), option1);
        String option2 = "Option 2";
        dropdown.selectByVisibleText(option2);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), option2);
    }
}
