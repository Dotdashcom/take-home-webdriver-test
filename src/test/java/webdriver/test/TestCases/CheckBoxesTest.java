package webdriver.test.TestCases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import webdriver.test.Pages.CheckBox;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class CheckBoxesTest
{


    private WebDriver driver;
    private CheckBox checkBox;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        checkBox = new CheckBox(driver);

    }





    @Test
    public void Checkboxes() throws NullPointerException{


        checkBox.checkBoxIwo.click();

        assertFalse(checkBox.checkBoxIwo.isSelected());

        System.out.println(">>>>Checkbox Two unCheckbox ");

        checkBox.checkBoxOne.click();

        assertTrue(checkBox.checkBoxOne.isSelected());

        System.out.println(">>>>Checkbox One Checkbox ");

        checkBox.checkBoxIwo.click();

        assertTrue(checkBox.checkBoxIwo.isSelected());

        System.out.println(">>>>Checkbox Two Checkbox ");

        checkBox.checkBoxAll.click();

        assertFalse( checkBox.checkBoxAll.isSelected());

        System.out.println(">>>>Both Checkbox unCheckbox ");

        checkBox.checkBoxAll.click();

        assertTrue( checkBox.checkBoxAll.isSelected());

        System.out.println(">>>>Both Checkbox Checkbox ");

        driver.close();
    }

    @AfterClass
    public void TearDown(){

        driver.quit();

    }


}
