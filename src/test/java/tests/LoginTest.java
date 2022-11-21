package tests;

import com.qa.pages.*;
import com.qa.pages.DirectoryPage;
import com.qa.pages.Utility;
import org.testng.annotations.*;

public class LoginTest extends BasePage{
    LoginPage lPage;
    LandingPage landPage;


    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.login);
        lPage=new LoginPage();

    }
    // login success
    @Test
    public boolean loginTest()
    {
        landPage=lPage.login("tomsmith", "SuperSecretPassword!");
        return landPage.isLoggedIn();
    }
    // login failed

    @Test
    public boolean loginTestFail()
    {
        // use the wrong password for the failed test
        Utility.navigateBack();
        return lPage.loginFail("tomsmith","super1234");
    }


@AfterTest
    public void tearDown()
{
    quit();
}


}
