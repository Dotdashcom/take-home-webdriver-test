package webdriver.test.TestCases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import webdriver.test.Pages.DropDown;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class DropDownTest
{


    private WebDriver driver;
    private DropDown dropDown;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        dropDown = new  DropDown(driver);

    }





    @Test
    public void selectDropDownOptionTest() throws NullPointerException{


        dropDown.setSelectDropDownBoxOption("Option 1");

        assertTrue(dropDown.getSelectedValueText().contains("Option 1"));

        dropDown.setSelectDropDownBoxOption("Option 2");

        assertTrue(dropDown.getSelectedValueText().contains("Option 2"));

        System.out.println(">>>>Both Checkbox Checkbox ");

        driver.close();
    }

    @AfterClass
    public void TearDown(){

        driver.quit();

    }


}
