package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.DragAndDropPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

import java.awt.*;
import java.awt.event.InputEvent;

public class DragAndDropCase {
    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "drag_and_drop";
        Driver.getDriver().get(url);
    }

    @Test
    public void test() throws AWTException {

        Robot robot = new Robot ();
        robot.mouseMove(270, 284);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(480, 261);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.mouseMove(270, 284);
        BrowserUtils.sleepSeconds(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(480, 261);
        BrowserUtils.sleepSeconds(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Assert.assertEquals("B", dragAndDropPage.headerA.getText());
        Assert.assertEquals("A", dragAndDropPage.headerB.getText());
    }
    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}