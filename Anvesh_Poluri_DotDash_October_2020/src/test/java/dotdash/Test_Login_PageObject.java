package dotdash;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Test_Login_PageObject extends Base_Setup
{
    /**
     * This is Contains Two Methods: Below Two Methods are Tests Written in TestNG
     * 1. Test_Login_Success_PageObject --> This Test Conducts Success of the Login Page
     * 2. Test_Login_Failure_PageObject --> This Test Conducts Failure of the Login Page
     * These Test are referenced from  Login_PageObject
     * Most of the Variable Names are Lengthy, they are designed to be understandable by any Readers.
     *
     * Using java version "1.8.0_251"
     * Using webdrivermanager 4.0.0 through POM.XML
     * Using selenium-java 3.141.59 through POM.XML
     * Using TestNG_6.8 through POM.XML
     * Code is written in IntelliJ IDEA IntelliJ IDEA 2020.1.2 (Community Edition)
     * Written By Anvesh Poluri, Email: anvesh.poluri@gmail.com, Date: October_6_2020
     */
    @BeforeClass // Before Every Class Run this runs Browser Setings that invokes Chrome Browser and make sure browser is ready
    public void setUp()
    {
        Base_Setup.Browser_Settings(); //Open Chrome Browser
    }
    @Test ()
    public void Test_Login_Success_PageObject()
    {
        Load_URL("login"); // Opening Login URl Page
        Login_PageObject PageObject_driver = new Login_PageObject(driver); // Passing driver to Pageobject Driver to handle Pageobject factory Variables
        String Correct_Username = PageObject_driver.Correct_Username(); // User_name for Login Credentials
        String Correct_Password = PageObject_driver.Correct_Password(); // Password for Login Credentials
        PageObject_driver.User_Name_WebElement().sendKeys(Correct_Username); // Sending Username to Username Text Box
        PageObject_driver.Password_WebElement().sendKeys(Correct_Password); // Sending Password to Password Text Box
        PageObject_driver.Login_Button_WebElement().click(); // Clicking Login Button
        String Secure_Area_Message = PageObject_driver.Secure_Area_Message_WebElement().getText(); // Reading Secure Message after Logging In
        // Validating the Test_Login_Success_PageObject by comparing Secure_Area_Message with the expected Message
        assertEquals(Secure_Area_Message, "Welcome to the Secure Area. When you are done click logout below.");
        PageObject_driver.Logout_WebElement().click(); //Logging Out
    }
    @Test (priority = 1)
    public void Test_Login_Failure_PageObject()
    {
        Load_URL("login"); // Opening Login URl Page
        Login_PageObject PageObject_driver = new Login_PageObject(driver); // Passing driver to Pageobject Driver to handle Pageobject factory Variables
        String Wrong_Username = PageObject_driver.Wrong_Username(); // User_name for Login Credentials
        String Wrong_Password = PageObject_driver.Wrong_Password(); // Password for Login Credentials
        PageObject_driver.User_Name_WebElement().sendKeys(Wrong_Username ); // Sending Username to Username Text Box
        PageObject_driver.Password_WebElement().sendKeys(Wrong_Password); // Sending Password to Password Text Box
        PageObject_driver.Login_Button_WebElement().click(); // Clicking Login Button
        String Error_Message = PageObject_driver.flash_Message_WebElement().getText(); // Reading Error Message for Login Failure
        // Validating the Test_Login_Failure_PageObject by comparing Error_Message with the expected Message
        assertTrue(Error_Message.contains("Your username is invalid!"));
    }
    @AfterClass // After Every Class this tears down Browser and Drivers and Closes Everything
    public void TearDown()
    {
        Base_Setup.tearDown();
    }
}