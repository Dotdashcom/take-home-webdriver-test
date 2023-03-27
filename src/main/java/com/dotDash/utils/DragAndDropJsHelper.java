package com.dotDash.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.stream.Collectors;

public class DragAndDropJsHelper {

    String dragndrop_js = null;

    public DragAndDropJsHelper(String jsFile) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/resources/drag_and_drop_helper.js"))) {
            dragndrop_js = br
                    .lines()
                    .collect(Collectors.joining(" "));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Solution from elemental-selenium-tips
     * https://github.com/tourdedave/elemental-selenium-tips/blob/master/39-drag-and-drop/csharp/DragAndDrop.cs
     * JSDriver.ExecuteScript(dnd_javascript + "$('#column-a').simulateDragDrop({
     * dropTarget: '#column-b'});");
     *
     * NOTE: Seems fragile, not sure if this works for XPATH or other src/dst type strings
     * TODO: would be good if it worked with WebElement, or BY
     *
     * @param driver
     * @param src
     *            - css string for source element
     * @param dst
     *            - css string for destination element
     */
    public void dragDrop(WebDriver driver, String src, String dst) {
        String js = String.format("$('%s').simulateDragDrop({ dropTarget: '%s'});",src,dst);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(dragndrop_js + js);
    }

}
