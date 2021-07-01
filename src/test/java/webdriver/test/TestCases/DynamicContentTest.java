package webdriver.test.TestCases;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.test.Pages.DynamicContent;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class DynamicContentTest
{


    private WebDriver driver;
    private DynamicContent dynamicContent;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        dynamicContent = new  DynamicContent(driver);

    }





    @Test
    public void testDynamicContent() throws NullPointerException{




        String Content1 = dynamicContent.getDynamicContent1();


        driver.navigate().refresh();  // Refresh PAge and get new content



        String Content2 = dynamicContent.getDynamicContent2();

        assertFalse(Content1.contains(Content2));


        driver.navigate().refresh();  // Refresh PAge  and get new content

        String Content3 = dynamicContent.getDynamicContent3();


        assertFalse(Content2.contains(Content3));


        assertFalse(Content1.contains(Content3));



        System.out.println(">>>>content changes on each refresh ");

        driver.close();
    }

    @AfterClass
    public void TearDown(){

        driver.quit();

    }


}
