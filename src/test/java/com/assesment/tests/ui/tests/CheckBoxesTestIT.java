package com.assesment.tests.ui.tests;

import com.assesment.tests.ui.pages.CheckBoxesPage;
import com.assesment.tests.ui.pages.HomePage;
import com.assesment.tests.ui.utilities.BasePageConf;
import com.assesment.tests.ui.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckBoxesTestIT extends BasePageConf {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = super.navigateToBasePage();
    }

    /**
     * Verify when checkbox 1 is clicked, it changes its position to opposite.
     */
    @Test
    public void verifyCheckbox1IsClickable() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCheckBoxes();
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        boolean isSelected = checkBoxesPage.isCheckBox1Selected();

        checkBoxesPage.clickOnCheckBox1();

        assertEquals(checkBoxesPage.isCheckBox1Selected(), !isSelected);
    }

    /**
     * Verify when checkbox 2 is clicked, it changes its position to opposite.
     */
    @Test
    public void verifyCheckbox2IsClickable() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCheckBoxes();
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        boolean isSelected = checkBoxesPage.isCheckBox2Selected();

        checkBoxesPage.clickOnCheckBox2();

        assertEquals(checkBoxesPage.isCheckBox2Selected(), !isSelected);
    }

    /**
     * Verify when checkbox 1 and checkbox 2 are clicked many times, these checkboxes functions as many times
     * they are clicked.
     */
    @Test
    public void verifyCheckboxCanBeClickedMoreThanOne() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCheckBoxes();
        int numberOfClicks = (int) (Math.random() * 10);

        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);

        // Random numbers of clicking checkboxes.
        boolean ischeckBox1Selected = checkBoxesPage.isCheckBox1Selected();
        boolean ischeckBox2Selected = checkBoxesPage.isCheckBox2Selected();
        for (int i = 0; i <= numberOfClicks; i++) {
            checkBoxesPage.clickOnCheckBox1();
            checkBoxesPage.clickOnCheckBox2();
            ischeckBox1Selected = !ischeckBox1Selected;
            ischeckBox2Selected = !ischeckBox2Selected;
        }

        // Verify after clicking on checkbox 1, it is left to expected selection
        assertEquals(checkBoxesPage.isCheckBox1Selected(), ischeckBox1Selected);

        // Verify after clicking on checkbox 2, it is left to expected selection
        assertEquals(checkBoxesPage.isCheckBox2Selected(), ischeckBox2Selected);
    }

    //TODO: I will add screenshot feature for failed test cases.
    /**
     * Close to opened browser.
     */
    @AfterMethod
    void tearDown(){
        Driver.closeDriver();
    }
}

