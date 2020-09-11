package webdrivertest;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DynamicContent extends Base {
    WebDriver driver;
    @Test
    public void dynamicContent(){
        driver = getDriver();

        /*
        * I can basically check the dynamic content that changes in every reload
        * by refreshing the page.
        * To do that I am using navigate().refresh() methods which refresh the page
        * */
        driver.navigate().to("http://localhost:7080/dynamic_content");
        driver.navigate().refresh();

    }
}
