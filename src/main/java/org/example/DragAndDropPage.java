package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.event.InputEvent;


public class DragAndDropPage extends BasePage {

    protected WebDriver driver;

    By dragAndDropPage = By.cssSelector("[href='\\/drag_and_drop']");
    By elementA = By.cssSelector("div#column-a");
    By elementB = By.cssSelector("div#column-b");


    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getDragandDropPage(){
        return driver.findElement(dragAndDropPage);
    }

    public WebElement getElementA(){
        return driver.findElement(elementA);
    }

    public WebElement getElementB(){
        return driver.findElement(elementB);
    }

    public void dragAndDrop() throws AWTException, InterruptedException {
        getDragandDropPage().click();

            Robot robot = new Robot();
            robot.setAutoDelay(2000);

            org.openqa.selenium.Dimension fromSize = getElementA().getSize();
            System.out.println(fromSize);
            org.openqa.selenium.Dimension toSize = getElementB().getSize();
            System.out.println(toSize);
            Point toLocation = getElementB().getLocation();
            System.out.println(toLocation);
            Point fromLocation = getElementA().getLocation();
            System.out.println(fromLocation.getX());
            System.out.println(fromLocation.getY());
            System.out.println("Screen Size: " + driver.manage().window().getSize());

        toLocation.x += toSize.width / 2;
        toLocation.y += toSize.height / 2 + toSize.height * 2 / 3;
        fromLocation.x += fromSize.width / 2;
        fromLocation.y += fromSize.height / 2 + fromSize.height * 2 / 3;

            robot.mouseMove(fromLocation.x,fromLocation.y);
            robot.mousePress(InputEvent.BUTTON1_MASK);

            robot.mouseMove(fromLocation.x, fromLocation.y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(toLocation.x, toLocation.y);

            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }

}
