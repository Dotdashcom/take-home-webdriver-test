package theinternet.tests;
import org.testng.annotations.*;
import theinternet.pages.BasePage;

public class BaseTest extends BasePage {
    @BeforeTest(description = "Navigate to home page")
    public void setup(){
        try {
            loadProperties();
            openBrowser();
        }catch (Exception e)
        {
            System.out.println("Failed to connect to baseUrl");
            e.printStackTrace();
            tearDown();
        }
    }
    @AfterTest(description = "Close the browser")
    public void tearDown(){
        closeBrowser();
    }
}
