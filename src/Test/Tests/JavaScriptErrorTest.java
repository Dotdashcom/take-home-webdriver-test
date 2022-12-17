package Tests;

import Pages.BasePage;
import Pages.JavaScriptErrorPage;
import Utils.Driver;
import Utils.HelpfulMethods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptErrorTest extends BasePage {
    JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage();
    @BeforeClass
    public void SetUp(){
        Driver.GetDriver().get("http://localhost:7080/javascript_error");
    }

    @Test
    public void TC1JavaScriptErrorVerification(){
        HelpfulMethods.staticWait(3);
        javaScriptErrorPage.ErrorFound();
    }
}
