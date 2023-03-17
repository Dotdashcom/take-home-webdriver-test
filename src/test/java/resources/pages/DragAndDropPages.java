package resources.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import resources.utilities.BaseClass;

public class DragAndDropPages extends BaseClass {

    public DragAndDropPages() {
        PageFactory.initElements(driver,this);
    }

    public void drgAndrop() throws InterruptedException, AWTException {
        WebElement columnA= driver.findElement(By.cssSelector("div#column-a"));
        WebElement columnB= driver.findElement(By.cssSelector("div#column-b"));

        Robot robot = new Robot();
        robot.setAutoDelay(3000);

        org.openqa.selenium.Dimension sizeA = columnA.getSize();
        org.openqa.selenium.Dimension sizeB = columnB.getSize();

        Point LocationA = columnA.getLocation();
        Point LocationB = columnB.getLocation();

        LocationB.x += sizeB.width / 2;
        LocationB.y += sizeB.height / 2 + sizeB.height * 2 / 3;
        LocationA.x += sizeA.width / 2;
        LocationA.y += sizeA.height / 2 + sizeA.height * 2 / 3;
        robot.mouseMove(LocationA.x, LocationA.y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(LocationB.x, LocationB.y);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

}
