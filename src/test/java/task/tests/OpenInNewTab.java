package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.pages.OpenInNewTabPage;
import task.utilities.BrowserUtils;
import task.utilities.Driver;

public class OpenInNewTab {


    OpenInNewTabPage openInNewTabPage = new OpenInNewTabPage();
    String expectedText = "New Window";
    String actualText;

    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/windows");
    }



    @Test
    public void testOpenInNewTab(){

        openInNewTabPage.link.click();


        BrowserUtils.switchWindow(expectedText);
        actualText = Driver.getDriver().getTitle();


        Assertions.assertEquals(expectedText, actualText);
    }




    @AfterEach
    public void tearDown() {
        Driver.closeDriver();
    }

}
