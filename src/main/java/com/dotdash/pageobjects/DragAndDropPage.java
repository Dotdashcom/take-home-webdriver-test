package com.dotdash.pageobjects;

import com.dotdash.utils.ScriptReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.Thread.sleep;

public class DragAndDropPage extends BasePage {

    @FindBy(how = How.CSS, using = "#column-a")
    private WebElement squareA;

    @FindBy(how = How.CSS, using = "#column-b")
    private WebElement squareB;

    @FindBy(how = How.CSS, using = "[class=column]:last-child")
    private WebElement switchedSquare;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public DragAndDropPage goToDragAndDropPage() {
        driver.get(BASEURL + "/drag_and_drop");
        return this;
    }

    public DragAndDropPage dragSquare() throws IOException {
        String content = ScriptReader.readScriptFile();
        ((JavascriptExecutor) driver).executeScript(content, squareA, squareB);
        return this;
    }

    public String getSwitchedSquareText() {
        return waitForVisibilityOf(switchedSquare).getText();
    }

}
