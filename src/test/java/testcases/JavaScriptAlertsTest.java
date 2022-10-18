package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.JavaScriptAlertsPage;
import org.junit.Test;

public class JavaScriptAlertsTest extends BaseTest {

    public JavaScriptAlertsTest(){
        super();
    }

    @Test
    public void TestingJavaScriptAlerts(){
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);

        javaScriptAlertsPage.clickJSAlertBtn();
        javaScriptAlertsPage.clickJSConfirmBtn();
        javaScriptAlertsPage.clickJSPromptBtn();

    }

}
