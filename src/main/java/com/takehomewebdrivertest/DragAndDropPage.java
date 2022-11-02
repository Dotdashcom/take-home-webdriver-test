package com.takehomewebdrivertest;
import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }
    ConfigFileReader configFileReader;

    private final String URL = "/drag_and_drop";

    private final By pageTitle = By.cssSelector("h3");
    private final By squareA = By.id("column-a");
    private final By squareB = By.id("column-b");
    private final By squareAHeader = By.xpath("//div[@id=\"columns\"]/div[@id=\"column-a\"]/header");
    private final By squareBHeader = By.xpath("//div[@id=\"columns\"]/div[@id=\"column-b\"]/header");

    public void navigateToDragAndDropPage() throws Exception {
        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/drag_and_drop");
        assertThat(getCurrentUrl()).contains(URL);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains("Drag and Drop");
    }

    public void moveBoxAtoBoxB() throws Exception {
        String squareAHeaderText = driver.findElement(squareAHeader).getText();
        assertThat(squareAHeaderText).contains("A");
        dragAndDrop(squareA, squareB);
    }

    public void validateBoxAIsTheSecondBox() throws Exception {
        String squareAHeaderText = driver.findElement(squareAHeader).getText();
        assertThat(squareAHeaderText).contains("B");
    }

    public void moveBoxBtoBoxA() throws Exception {
        String squareBHeaderText = driver.findElement(squareBHeader).getText();
        assertThat(squareBHeaderText).contains("B");
        dragAndDrop(squareB, squareA);
    }

    public void validateBoxBIsTheFirstBox() throws Exception {
        String squareBHeaderText = driver.findElement(squareBHeader).getText();
        assertThat(squareBHeaderText).contains("A");
    }
}
