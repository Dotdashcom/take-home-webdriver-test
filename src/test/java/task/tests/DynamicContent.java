package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import task.pages.DynamicContentPage;
import task.utilities.Driver;

public class DynamicContent extends DynamicContentPage {




    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/dynamic_content");
    }




    @Test
    public void testDynamicContent(){


        String contentBeforeRefresh = Driver.getDriver().findElement(By.tagName("body")).getText();

        // Refresh the page multiple times and verify that the content changes each time
        for (int i = 0; i < 3; i++) {
            Driver.getDriver().navigate().refresh();
            String refreshedContent = Driver.getDriver().findElement(By.tagName("body")).getText();

            Assertions.assertNotEquals(refreshedContent, contentBeforeRefresh);
        }

    }





    @AfterEach
    public void tearDown(){
        Driver.closeDriver();
    }
}
