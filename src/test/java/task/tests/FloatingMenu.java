package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import task.pages.FloatingMenuPage;
import task.utilities.Driver;



public class FloatingMenu {


    FloatingMenuPage floatingMenuPage = new FloatingMenuPage();


    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/floating_menu");
    }


    @Test
    public void testFloatingMenu(){


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,653)");



        Assertions.assertTrue(floatingMenuPage.floatingMenu.isDisplayed());

    }


    @AfterEach
    public void tearDown(){
        Driver.closeDriver();
    }
}
