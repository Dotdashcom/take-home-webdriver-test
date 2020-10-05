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
        if(jsAlertsPage.gettxtresult().contains("You successfuly clicked an alert"))
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!!Alert message is displayed on clicking JS Alert!!");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!!No Alert message displayed on clicking JS Alert!!");
        }

        //============================================================================================

        //Click on JS Confirm
        jsAlertsPage.clkbtnJSConfirm();

        //Close the alert window
        alert.accept();

        //Validate whether the alert message is displayed
        if(jsAlertsPage.gettxtresult().contains("Ok"))
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!!Alert message is displayed on clicking Ok button!!");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!!No Alert message displayed on clicking Ok button!!");
        }

        //==========================================================================================

        //Click on JS Confirm
        jsAlertsPage.clkbtnJSConfirm();

        //Close the alert window
        alert.dismiss();

        //Validate whether the alert message for Cancel is displayed
        if(jsAlertsPage.gettxtresult().contains("Cancel"))
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!!Alert message for Cancel is displayed on clicking Cancel button!!");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!!No Alert message displayed on clicking Cancel button!!");
        }

        //============================================================================================

        //Click on JS Prompt
        jsAlertsPage.clkbtnJSPrompt();
        String typedmsg = "Javascript is a scripting language!!";
        alert.sendKeys(typedmsg);
        //Close the alert window
        alert.accept();
        if(jsAlertsPage.gettxtresult().contains(typedmsg))
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! Alert contains typed message!!");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! Alert DONOT contain typed message!!");
        }
        assertion.assertAll();
    }
}
