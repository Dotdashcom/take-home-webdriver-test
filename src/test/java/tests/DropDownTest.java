package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.DropDown;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownTest extends BasePage {
    DropDown dropDown;

    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.dropdown);
        dropDown=new DropDown();
    }
    @Test
    public boolean selectFromDropDown()
    {
        return dropDown.selectValue("Option 1");
    }

    @AfterTest
    public void tearDown()
    {
        quit();
    }
}

