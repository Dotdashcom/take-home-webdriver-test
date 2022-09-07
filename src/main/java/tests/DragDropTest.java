package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.DragDropPage;
import pages.utils;

public class DragDropTest {
    DragDropPage dragDropPage;

    public DragDropTest() {
        dragDropPage = new DragDropPage();
    }

    @Test
    public void dragDropTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/drag_and_drop");

        String expectedtextA = "A";
        String expectedtextB = "B";
        dragDropPage.dragDrop();

        String actualTextA = dragDropPage.getTextA();
        String actualTextB = dragDropPage.getTextB();

        try {
            Assert.assertEquals(actualTextA, expectedtextB);
            Assert.assertEquals(actualTextB, expectedtextA);
            System.out.println("Box A text is: " + actualTextA + ": passed");
            System.out.println("Box B text is: " + actualTextB + ": passed");
        } catch (AssertionError e) {
            System.out.println("Box A text is: " + expectedtextA + ": failed");
            System.out.println("Box B text is: " + expectedtextB + ": failed");
            throw e;
        }
    }

    @AfterTest
    public void teardown() {
        TestBase.getInstance().getDriver().quit();
    }
}



