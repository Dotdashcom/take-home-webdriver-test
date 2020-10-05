package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.DropdownPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
public class TC06_Dropdown extends baseClass {

    @Test
    public void dropdown()
    {
        //Launch url
        driver.get(baseURL+"/dropdown");

        //Create object of DropdownPage
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.clkdrpdown();

        SoftAssert assertion = new SoftAssert();
        //Select option1 and validate
        dropdownPage.selOption1();

        if(dropdownPage.getOptionselected().contains("Option 1"))
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! Option 1 is selected");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test failed!! Option 1 is NOT selected");
        }
        //Refresh the page
        driver.navigate().refresh();

        //Select option2 and validate
        dropdownPage.selOption2();

        if(dropdownPage.getOptionselected().contains("Option 1"))
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! Option 2 is selected");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! Option 2 is NOT selected");
        }
        assertion.assertAll();


    }
}
