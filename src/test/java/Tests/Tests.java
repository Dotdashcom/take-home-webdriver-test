package Tests;

import org.junit.Test;
import pages.CheckboxesPage;
import pages.ContextMenuPage;
import pages.LoginSuccessPage;
import utilities.BrowserUtils;

public class Tests extends AbstractTestBase {
    LoginSuccessPage logInSuccess = new LoginSuccessPage();
    CheckboxesPage checkboxesPage = new CheckboxesPage();
    ContextMenuPage contextMenuPage=new ContextMenuPage();


    @Test
    public void LoginSuccess() {
        logInSuccess.LogIn();
    }

    @Test
    public void LoginSuccessWrongCredentials() {
        logInSuccess.LogIn("BlaBla", "LaLA");

    }
    @Test
    public void Checkboxes(){
        checkboxesPage.logInCheckboxPage();
        checkboxesPage.verifyCheckBoxes();
    }

    @Test
    public void ContextMenu(){
        contextMenuPage.getConnection("ContextMenu");
        contextMenuPage.clickOnWindow();
        contextMenuPage.getText();
    }
}
