package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DragAndDropPage extends Base {
    WebDriver driver;

    By boxA = By.xpath(readValue("dragPage.boxAXp"));
    By boxB = By.xpath(readValue("dragPage.boxBXp"));
    By textBoxA = By.xpath(readValue("dragPage.textBoxAXp"));
    By textBoxB = By.xpath(readValue("dragPage.textBoxBXp"));

    public void dragAndDrop() {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\dragAndDrop.js");
        try {
            // Read the entire content of dragAndDrop.js
            String content = FileUtils.readFileToString(file, "UTF-8");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(content + "$('#column-a').simulateDragDrop({ dropTarget: '#column-b'});");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTextBoxA() {
        return driver.findElement(textBoxA).getText();
    }

    public String getTextBoxB() {
        return driver.findElement(textBoxB).getText();
    }

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }
}
