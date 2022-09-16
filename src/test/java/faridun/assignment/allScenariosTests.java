package faridun.assignment;

import faridun.utils.Base;
import faridun.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static faridun.utils.Pages.*;


public class allScenariosTests extends TestBase {

    //To run from command use mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml

    //Test1
    @Test
    public void LoginTestPassed() {
        loginPage().goToLogIn();
        loginPage().typeCredentials("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals(loginPage().loggedinTxtToVerify.getText(), "You logged into a secure area!\n" + "×");
    }

    //Test2
    @Test
    public void LoginTestFailed() {
        loginPage().goToLogIn();
        loginPage().typeCredentials("tomsmith", "SuperSecret");
        Assert.assertEquals(loginPage().invalidFailedLoginTxt.getText(), "Your password is invalid!\n" + "×");
    }

    //Test3
    @Test
    public void checkBoxes() {
        pages().goToCheckBox();
        pages().clickCheckBox(pages().checkBox1);
        Assert.assertTrue(pages().checkBox1.isSelected());
        pages().clickCheckBox(pages().checkBox2);
        Assert.assertFalse(pages().checkBox2.isSelected());
    }

    //Test4
    @Test
    public void contextMenu() {
        pages().goContextMenu();
        pages().contextclick();
        pages().handleAlertAndVerify("You selected a context menu");
    }

    //Test5
    @Test
    public void DragAndDrop() {
        pages().goDragAndDrop();
        pages().dragAndDrop(pages().dragElement, pages().dropElement);
    }

    //Test6
    @Test
    public void dropDown() {
        pages().goDropDownn();
        String value1 = pages().selectDdValue(pages().dropDown, "Option 1");
        Assert.assertEquals(value1, "Option 1");
        String value2 = pages().selectDdValue(pages().dropDown, "Option 2");
        Assert.assertEquals(value2, "Option 2");
    }
}
