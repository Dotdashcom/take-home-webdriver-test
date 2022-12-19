package theinternet.tests;

import org.testng.annotations.*;
import theinternet.pages.BasePage;
import theinternet.pages.CheckboxPage;
import theinternet.pages.HomePage;


public class BaseTest extends BasePage {
    HomePage homePage;
    @BeforeTest(description = "Navigate to home page")
    public void setup(){
        launchBrowser();
        homePage = new HomePage();
    }
    @AfterTest(description = "Close the browser")
    public void tearDown(){
        quitBrowser();
    }
}
