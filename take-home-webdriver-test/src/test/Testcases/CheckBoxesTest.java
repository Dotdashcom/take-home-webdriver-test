package com.framework.testcases;
import com.framework.pages.CheckBoxesPage;
import com.framework.testbase.TestBase;
import com.framework.utils.Utils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxesTest extends TestBase {

    CheckBoxesPage checkBoxesPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }


    @Test(priority = 2, description = "checkbox 1 is unselected by default")
    public void checkbox1_is_unselected() {
        checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.navigate();
        WebElement checkbox1 = checkBoxesPage.getCheckBox1();
        Boolean ischeckBox1Unselected = checkbox1.isDisplayed() && !checkbox1.isSelected() && checkbox1.isEnabled();
        Assert.assertTrue(ischeckBox1Unselected);
    }

    @Test(priority = 3, description = "checkbox 1 can be selected and unselected")
    public void checkbox1_can_be_selected_and_unselected() {
        checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.navigate();
        WebElement checkbox1 = checkBoxesPage.getCheckBox1();

        Utils.selectCheckBox(checkbox1);
        Boolean ischeckBox1Selected = checkbox1.isSelected();
        Assert.assertTrue(ischeckBox1Selected);

        Utils.unselectCheckBox(checkbox1);
        Boolean ischeckBox1UnSelected = !checkbox1.isSelected();
        Assert.assertTrue(ischeckBox1UnSelected);

    }

    @Test(priority = 4, description = "checkbox 2 is selected by default")
    public void checkbox2_is_selected() {
        checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.navigate();
        WebElement checkbox2 = checkBoxesPage.getCheckBox2();
        Boolean ischeckBox2Selected = checkbox2.isDisplayed() && checkbox2.isSelected() && checkbox2.isEnabled();
        Assert.assertTrue(ischeckBox2Selected);
    }

    @Test(priority = 5, description = "checkbox 2 can be selected and unselected")
    public void checkbox2_can_be_selected_and_unselected() {
        checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.navigate();
        WebElement checkbox2 = checkBoxesPage.getCheckBox2();

        Utils.unselectCheckBox(checkbox2);
        Boolean ischeckBox2Unselected = !checkbox2.isSelected();
        Assert.assertTrue(ischeckBox2Unselected);

        Utils.selectCheckBox(checkbox2);
        Boolean ischeckBox2Selected = checkbox2.isSelected();
        Assert.assertTrue(ischeckBox2Selected);
    }
	

    @Test(priority = 1, description = "User is on the checkboxes page")
    public void user_is_on_checkboxes_page() {
        checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.navigate();
        String actualURL = checkBoxesPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/checkboxes";
        Assert.assertEquals(actualURL, expectedURL);
    }
	
	@AfterTest
    public void teardown() {
        super.cleanup();
    }

}
