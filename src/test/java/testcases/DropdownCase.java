package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.DropdownPage;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;

public class DropdownCase {
    DropdownPage dropdownPage = new DropdownPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "dropdown";
        Driver.getDriver().get(url);
    }

    @Test
    public void test() {
        Select select = new Select(dropdownPage.selectOption);

        List<WebElement> options = select.getAllSelectedOptions();
        for (int i = 0; i < options.size(); i++) {
            select.selectByIndex(i);
            Assert.assertTrue(options.get(i).isSelected());
        }
    }
        @After
        public void tearDown() {
            Driver.quitDriver();
        }
}
