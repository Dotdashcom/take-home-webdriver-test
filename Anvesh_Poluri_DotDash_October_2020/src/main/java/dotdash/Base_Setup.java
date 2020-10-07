package dotdash;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.util.Objects;

public class Base_Setup
{
    /**
     * This code opens URL of "http://localhost:7080" on Chrome Browser and also Subsequent URL's on Chrome Browser
     * This Class Contains Basic Setup Methods that can be Used in Test Cases
     * Most of the Variable Names are Lengthy, they are designed to be understandable by any Readers.
     *
     * All Tests are Written Using TestNG
     * All the tests related to this are in SRC/Test/Java/Dotdash/ALL_18_TestCases
     * Simply Run ALL_18_TestCases to run all tests mentioned in the Test
     *
     * Using java version "1.8.0_251"
     * Using webdrivermanager 4.0.0 through POM.XML
     * Using selenium-java 3.141.59 through POM.XML
     * Using TestNG_6.8 through POM.XML
     * Code is written in IntelliJ IDEA IntelliJ IDEA 2020.1.2 (Community Edition)
     * Written By Anvesh Poluri, Email: anvesh.poluri@gmail.com, Date: October_6_2020
     */

    public static WebDriver driver;
    // Declaring a Public Webdriver help us run all Selenium Operations across different Classes and Test

    private static String Base_Environment_URL = "http://localhost:7080"; // Basic URL of the site

    public static void Browser_Settings()
    {
        // This Method is used to start the Browser
        // When ever this Method is Used it does the following
        WebDriverManager.chromedriver().setup(); // Setting up ChromeDriver from WebDriver Manager
        driver = new ChromeDriver(); // Pointing the driver to run on Chrome browser
        driver.manage().window().maximize(); //Maximizing the Chrome Browser Window
    }

    public static void Load_URL(String EndPoint_addon_to_Original_URL)
    {
        //For every Test there is a Base URL and Addon URL part at the End that open the required site directly
        // EndPoint_addon_to_Original_URL is combined with Base_Environment_URL and resulted URL is opened in Chrome Browser
        driver.get(Base_Environment_URL + "/" + EndPoint_addon_to_Original_URL); // Opening Website URL
    }

    public static void tearDown()
    {
        // Tearing down and Closing all Browser and driver related operations
        driver.close();
        driver.quit();
    }
    public boolean Check_for_Downloaded_file (String File_download_Path, String Downloaded_fileName)
    {
        // This Method Checks whether the passed file name is downloaded or not in the targeted Folder
        File dir = new File(File_download_Path); // Loading File_download_Path to Dir
        File[] dir_contents = dir.listFiles(); // Loading all Files in that Dir to dir_contents

        // Loop that goes through all the available files in dir
        for (int i = 0; i < Objects.requireNonNull(dir_contents).length; i++)
        {
            // Validating if the current file matches with the Downloaded_fileName
            if (dir_contents[i].getName().equals(Downloaded_fileName))
            {
                // Once We have a Match we are Deleting that file
                // so next time the test is run it will always check whether the file is downloaded once again or not
                //If we Don't delete the File when the Test is Run and file is not downloaded Test will still PAss
                dir_contents[i].delete();
                return true; // Once we have a match on File Name it will return True
            }
        }
        return false; // If in the Entire dir no filename Matches then this returns False
    }
}
