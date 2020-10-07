package dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_PageObject extends Base_Setup
{
    /**
     * This is the PageObject Factory for Login Module
     * This Contains all the Paths,Elements, Usernames, Passwords
     * Most of the Variable Names are Lengthy, they are designed to be understandable by any Readers.
     *
     * All Tests are Written Using TestNG
     * All the tests related to this are in SRC/Test/Java/Dotdash/Test_Login_Success_Pageobject
     * All the tests related to this are in SRC/Test/Java/Dotdash/Test_Login_Failure_PageObject
     * Simply Run above mentioned tests to see results
     *
     * Using java version "1.8.0_251"
     * Using webdrivermanager 4.0.0 through POM.XML
     * Using selenium-java 3.141.59 through POM.XML
     * Using TestNG_6.8 through POM.XML
     * Code is written in IntelliJ IDEA IntelliJ IDEA 2020.1.2 (Community Edition)
     * Written By Anvesh Poluri, Email: anvesh.poluri@gmail.com, Date: October_6_2020
     */
    By User_Name_Path =By.xpath("//input[@id='username']"); // Path of Username TextBox on Login Page
    By Password_Path = By.id("password"); // Path of Password TextBox on Login Page
    By Login_Button_Path = By.cssSelector("button.radius"); // Path of Login Button on Login Page
    By Secure_Area_Message_Path = By.xpath("//body/div[2]/div[1]/div[1]/h4[1]"); // Path of Secure_Area_Message after Logging successful
    By Logout_path = By.xpath("//body/div[2]/div[1]/div[1]/a[1]"); // Path of Logout Button on Login Page
    By flash_Message_Path = By.xpath("//div[@id='flash']");


    public Login_PageObject(WebDriver driver)
    {
        Base_Setup.driver =driver;
    }
    public WebElement User_Name_WebElement()
    {
        return driver.findElement(User_Name_Path);
    }
    public WebElement Password_WebElement()
    {
        return driver.findElement(Password_Path);
    }
    public WebElement Login_Button_WebElement()
    {
        return driver.findElement(Login_Button_Path);
    }
    public WebElement Secure_Area_Message_WebElement()
    {
        return driver.findElement(Secure_Area_Message_Path);
    }
    public WebElement Logout_WebElement()
    {
        return driver.findElement(Logout_path);
    }
    public WebElement flash_Message_WebElement()
    {
        return driver.findElement(flash_Message_Path);
    }
    public String Wrong_Username()
    {
        return "wrong_username";
    } // Returns a String Called wrong_username
    public String Wrong_Password()
    {
        return "wrong_password!";
    } // Returns a String Called wrong_password
    public String Correct_Username()
    {
        return "tomsmith";
    } // Returns a String Called tomsmith
    public String Correct_Password()
    {
        return "SuperSecretPassword!";
    } // Returns a String Called SuperSecretPassword!
}
