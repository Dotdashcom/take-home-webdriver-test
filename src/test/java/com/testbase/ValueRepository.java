package com.testbase;

import com.pages.LoginPage;
import com.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class ValueRepository  {

    public static WebDriver driver;
 //   public static  Select select;
    public static SoftAssert softAssert;
    public static String Window_Handle = "";
  //  public static String OriginalWindow = "";

    // ChromeDriver_Path
    public static final String BrowserPath = System.getProperty("user.dir")+ "\\src\\test\\java\\com\\Windriver\\chromedriver.exe";

    //Download Path
    public static final String DownloadPath = System.getProperty("user.dir")+ "\\src\\test\\java\\com\\Download";

    //Base URL
    public static final String BaseURL="http://localhost:7080/";

    //Credentials
    public static final String _userName_Correct = "tomsmith";
    public static final String _password_Correct = "SuperSecretPassword!";
    public static final String _userName_Wrong = "tomsmih123";
    public static final String _password_Wrong = "SuperSecretPassword!123";
}
