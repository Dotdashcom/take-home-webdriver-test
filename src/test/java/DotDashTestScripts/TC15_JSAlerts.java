package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.JSAlertsPage;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//Testcase Description: JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.
public class TC15_JSAlerts extends baseClass {

    @Test
    public void JSAlerts() {
        //Launch url
        driver.get(baseURL + "/javascript_alerts");

        //Create an object for JSAlertsPage
        JSAlertsPage jsAlertsPage = new JSAlertsPage(driver);

        //Click on JS Alert
        jsAlertsPage.clkbtnJSAlert();

        Alert alert = driver.switchTo().alert();

        //Close the alert window
        alert.accept();

        SoftAssert assertion = new SoftAssert();
        //Validate whether the alert message is displayed
        assertion.assertTrue(jsAlertsPage.gettxtresult().contains("You successfuly clicked an alert"));

        //============================================================================================

        //Click on JS Confirm
        jsAlertsPage.clkbtnJSConfirm();

        //Close the alert window
        alert.accept();

        //Validate whether the alert message is displayed
        assertion.assertTrue(jsAlertsPage.gettxtresult().contains("Ok"));

        //==========================================================================================

        //Click on JS Confirm
        jsAlertsPage.clkbtnJSConfirm();

        //Close the alert window
        alert.dismiss();

        //Validate whether the alert message for Cancel is displayed
        assertion.assertTrue(jsAlertsPage.gettxtresult().contains("Cancel"));

        //============================================================================================

        //Click on JS Prompt
        jsAlertsPage.clkbtnJSPrompt();
        String typedmsg = "Javascript is a scripting language!!";
        alert.sendKeys(typedmsg);

        //Close the alert window
        alert.accept();
        assertion.assertTrue(jsAlertsPage.gettxtresult().contains(typedmsg));

        assertion.assertAll();
    }
}
