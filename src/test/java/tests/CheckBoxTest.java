package tests;

import com.qa.pages.BasePage;
import com.qa.pages.CheckBoxPage;
import com.qa.pages.DirectoryPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxTest extends BasePage {
CheckBoxPage chPage;

    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.checkboxes);
        chPage=new CheckBoxPage();
    }

    @Test
    public boolean clickCheckBoxes()
    {
        chPage.clickCheckBoxes();
        return  chPage.checkBoxSelected();

    }

    @AfterTest
    public void tearDown()
    {
        quit();
    }




}
