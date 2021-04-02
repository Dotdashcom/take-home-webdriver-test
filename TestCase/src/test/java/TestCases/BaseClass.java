package TestCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeTest;
import utilities.ReadConfig;

    public class BaseClass
    {
        ReadConfig readconfig=new ReadConfig();
        public String BaseUrl=readconfig.getApplicationURL();
        public String username=readconfig.getUsername();
        public String password=readconfig.getPassword();
        public String wrngUname=readconfig.getWrongUsername();
        public String wrngPwd=readconfig.getWrongPwd();

        public static WebDriver driver;

        @BeforeTest
        public void setup()
        {
            System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
            driver=new ChromeDriver();
        }
        @AfterTest
        public void teardown()
        {
            driver.close();
        }

    }

