package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.DropdownPage;
import org.apache.poi.ss.formula.functions.T;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
public class TC06_Dropdown extends baseClass {

    @Test
    public void dropdown() throws InterruptedException {
        //Launch url
        driver.get(baseURL+"/dropdown");

        //Create object of DropdownPage
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.clkdrpdown();

        SoftAssert assertion = new SoftAssert();
        //Select option1 and validate
        dropdownPage.selOption1();
        assertion.assertTrue(dropdownPage.getOptionselected().contains("Option 1"));
        //Refresh the page
        driver.navigate().refresh();

        Thread.sleep(2000);

        //Select option2 and validate
        dropdownPage.selOption2();
        assertion.assertTrue(dropdownPage.getOptionselected().contains("Option 2"));

        assertion.assertAll();


    }
}
