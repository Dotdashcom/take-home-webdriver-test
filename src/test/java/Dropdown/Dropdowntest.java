package Dropdown;

import Pages.DropdownPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class Dropdowntest extends TestBase {

    @BeforeClass
    public void loginUrl(){
        driver.get(TestBase.BASEURL.concat("/dropdown"));
    }
    @Test
            public void Dropdowntest() {
        DropdownPage d=new DropdownPage();

        Select select = new Select(d.dropdown);

        List<WebElement> lst = select.getOptions();

        select.selectByIndex(1);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals(lst.get(1).getText()));

        select.selectByIndex(2);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals(lst.get(2).getText()));


    }

}
