package tests;

import Pages.DynamicLoading_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingTest {
    public String Url_DynamicLoading= "dynamic_loading/2";
    WebDriver driverDotDash;
    DynamicLoading_Page dynamicLoading_page;
    @Before
    public void setUp() {
        dynamicLoading_page=new DynamicLoading_Page(driverDotDash);
        dynamicLoading_page.setChrome();
        dynamicLoading_page.setUrl(Url_DynamicLoading);
    }

    @Test
    public void startButtonClick() {
        dynamicLoading_page.startbtnNdAssert();
    }

    @After
    public void tearDown(){
        dynamicLoading_page.closeAllWindows();
    }
}
