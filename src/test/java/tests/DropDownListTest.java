package tests;

import Pages.DropDown_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DropDownListTest{
    public String Url_Dropdown= "dropdown";
    WebDriver driverDotDash;
    DropDown_Page dropDown_page;
    @Before
    public void setUp(){
         dropDown_page=new DropDown_Page(driverDotDash);
         dropDown_page.setChrome();
        dropDown_page.setUrl(Url_Dropdown);
    }

    @Test
    public void selecTheOption() {
        dropDown_page.option1Selected();
        dropDown_page.assertOptionsList();
        dropDown_page.option2Selected();
        dropDown_page.assertOptionsList();
    }

    @After
    public void tearDown() throws Exception {
        dropDown_page.closeAllWindows();
    }
}
