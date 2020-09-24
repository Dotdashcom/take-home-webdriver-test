package MarionelaTirsina;

import MarionelaTirsina.pages.DropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTest {
    /**
     * //Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
     */
    DropDown dropDown=new DropDown();
    @Before
    public void setUp() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/dropdown");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @Test
    public void dropDownBySelect() {

        WebElement dropdownList = dropDown.dropdown;

        Select select = new Select(dropdownList);


        List<WebElement> allOptions = select.getOptions();//return list of all options
        System.out.println("allOptions.size() = " + allOptions.size());//the size of the list

        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }
        allOptions.get(0).click();
        String optionZeroTEXT = allOptions.get(0).getText();
        System.out.println("optionZeroTEXT = " + optionZeroTEXT);
        allOptions.get(1).click();
        String optionOneTEXT = allOptions.get(1).getText();
        System.out.println("optionOneTEXT = " + optionOneTEXT);
        allOptions.get(2).click();
        String optionTwoTEXT = allOptions.get(2).getText();
        System.out.println("optionTwoTEXT = " + optionTwoTEXT);

        Assert.assertEquals(optionZeroTEXT, "Please select an option");
        Assert.assertEquals(optionOneTEXT, "Option 1");
        Assert.assertEquals(optionTwoTEXT, "Option 2");

    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);

    }


}
