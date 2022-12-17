package Tests;

import Pages.BasePage;
import Pages.CheckBoxPage;
import Utils.Driver;
import Utils.HelpfulMethods;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckBoxVerification extends BasePage {
    CheckBoxPage checkBoxPage = new CheckBoxPage();

    @BeforeMethod
    public void SetUp(){
        Driver.GetDriver().get("http://localhost:7080/checkboxes");
    }

    @Test(priority=1)
    public void TC1CheckBoxVerification() throws IOException {
        checkBoxPage.ClickCheckBox1();
        HelpfulMethods.staticWait(3);
        checkBoxPage.ClickCheckBox2();
        HelpfulMethods.takeScreenShot("CheckBox_Verification");

    }

}
