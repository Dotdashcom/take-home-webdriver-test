package tests;

import Pages.CheckBoxes_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CheckBoxTest {
    public  String CheckBoxnUrl = "checkboxes";
    WebDriver driverDotDash;
    CheckBoxes_Page checkBoxes;
    @Before
    public void setUp(){
        checkBoxes=new CheckBoxes_Page(driverDotDash);
        checkBoxes.setChrome();
        checkBoxes.setUrl(CheckBoxnUrl);
    }

    @Test
    public void selectTheCheckBox() {
        checkBoxes.chooseCheckBoxes();
        checkBoxes.assertCheckBox();
    }

    @After
    public void tearDown(){
        checkBoxes.closeAllWindows();
    }
}
