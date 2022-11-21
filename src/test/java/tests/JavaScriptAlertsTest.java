package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.JavaScriptAlerts;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends BasePage {
    JavaScriptAlerts jsa;
    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.JSAlerts);
        jsa=new JavaScriptAlerts();
    }
    @Test
    public void JavaScriptAlert(){
        Assert.assertTrue(jsa.JSAlertTest());
    }
    @AfterTest
    public void tearDown()
    {
        quit();
    }

}