package com.dotdash.pageobject;

import org.openqa.selenium.*;
import org.testng.Assert;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class DragandDrop extends BasePageObject{

    private WebElement from;
    private WebElement to;
    private String left_column_text_before_dnd = "";
    private String right_column_text_before_dnd = "";

    private final By left_element = By.id("column-a");
    private final By right_element = By.id("column-b");

    public DragandDrop(WebDriver driver) {
        this.driver = driver;
        open_page("drag_and_drop");
    }

    public DragandDrop dnd_left_to_right() throws Exception {
        this.from = this.driver.findElement(left_element);
        this.to = this.driver.findElement(right_element);
        this.left_column_text_before_dnd = from.getText();
        this.right_column_text_before_dnd = to.getText();
        this.from(from).to(to).perform_drag_n_drop();
        return this;
    }

    public DragandDrop dnd_right_to_left() throws Exception {
        this.from = this.driver.findElement(right_element);
        this.to = this.driver.findElement(left_element);
        this.left_column_text_before_dnd = to.getText();
        this.right_column_text_before_dnd = from.getText();
        this.from(from).to(to).perform_drag_n_drop();
        return this;
    }

    public void verify_text_after_dnd() {
        String left_column_text_after_dnd = driver.findElement(left_element).getText();
        String right_column_text_after_dnd = driver.findElement(right_element).getText();

        Assert.assertEquals(left_column_text_after_dnd, right_column_text_before_dnd, "[ERR] DnDPage failed!");
        Assert.assertEquals(right_column_text_after_dnd, left_column_text_before_dnd, "[ERR] DnDPage failed!");
    }

    private DragandDrop from(WebElement from) {
        this.from = from;
        return this;
    }

    private DragandDrop to(WebElement to) {
        this.to = to;
        return this;
    }

    public void perform_drag_n_drop() throws Exception {

        /*
         * This will not work due to chrome driver buf
         **/
        // Actions action = new Actions(this.driver);
        // action.dragAndDrop(from, to).build().perform();
        // action.clickAndHold(from).pause(2000).moveToElement(to).release().build().perform();

        /*
         * Refer: https://www.programering.com/a/MTN1kTMwATE.html
         **/
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // Get size of elements
        Dimension fromSize = from.getSize();
        System.out.println(fromSize);
        Dimension toSize = to.getSize();
        System.out.println(toSize);
        Point toLocation = to.getLocation();
        System.out.println(toLocation);
        Point fromLocation = from.getLocation();
        System.out.println(fromLocation.getX());
        System.out.println(fromLocation.getY());
        System.out.println("Screen Size: " + driver.manage().window().getSize());

        //Make Mouse coordinate centre of element
        toLocation.x += toSize.width / 2;
        toLocation.y += toSize.height / 2 + toSize.height * 2 / 3;
        fromLocation.x += fromSize.width / 2;
        fromLocation.y += fromSize.height / 2 + fromSize.height * 2 / 3;

        // Click first on screen
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseMove(fromLocation.x, fromLocation.y);
        robot.mousePress(InputEvent.BUTTON1_MASK);

        //Move to final position
        robot.mouseMove(toLocation.x, toLocation.y);

        //Drop
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

}
