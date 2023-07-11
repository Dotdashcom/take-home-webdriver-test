/*
 * MIT License
 *
 * Copyright (c) 2018 Elias Nogueira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.takehome.test;

import com.takehome.BaseWeb;
import com.takehome.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static com.takehome.config.ConfigurationManager.configuration;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TakeHomeTests extends BaseWeb {

    @Test(description = "Test checks and unchecks checkboxes.")
    public void testChecksAndUnchecksCheckboxes() {

        open("/checkboxes");

        var checkboxOne = DriverManager.getDriver().findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        var checkboxTwo = DriverManager.getDriver().findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        checkboxOne.click();
        checkboxTwo.click();

        softAssertions.assertThat(checkboxOne.isSelected()).withFailMessage("First checkbox is not checked!")
                .isTrue();
        softAssertions.assertThat(checkboxTwo.isSelected()).withFailMessage("Second checkbox is checked!")
                .isFalse();
        softAssertions.assertAll();
    }

    @Test(description = "Test right clicks on the context menu")
    public void testRightClicksOnTheContextMenu() {
        open("context_menu");

        var boxElement = DriverManager.getDriver().findElement(By.cssSelector("#hot-spot"));
        var action = new Actions(DriverManager.getDriver());
        action.contextClick(boxElement).perform();

        try {
            var alert = DriverManager.getDriver().switchTo().alert();
            assertThat(alert.getText()).isEqualTo("You selected a context menu");
        } catch (NoAlertPresentException e) {
            fail("Alert is not present");
        }
    }

    @Test(description = "Drag and Drop")
    public void dragAndDropTest() {
        open("/drag_and_drop");

        var elementA = DriverManager.getDriver().findElement(By.cssSelector("#column-a"));
        var elementB = DriverManager.getDriver().findElement(By.cssSelector("#column-b"));
        var action = new Actions(DriverManager.getDriver());
        action.dragAndDrop(elementA, elementB).perform();

        softAssertions.assertThat(elementA.findElement(By.cssSelector("header")).getText()).isEqualTo("A");
        softAssertions.assertThat(elementB.findElement(By.cssSelector("header")).getText()).isEqualTo("B");
        softAssertions.assertAll();
    }

    @Test(description = "Dropdown")
    public void dropdownTest() {
        final String option1 = "Option 1";
        final String option2 = "Option 2";

        open("/dropdown");

        var selectElement = new Select(DriverManager.getDriver()
                .findElement(By.cssSelector("#dropdown")));

        selectElement.selectByVisibleText(option1);
        assertThat(selectElement.getFirstSelectedOption().getText()).isEqualTo(option1);

        selectElement.selectByVisibleText(option2);
        assertThat(selectElement.getFirstSelectedOption().getText()).isEqualTo(option2);
    }

    @Test(description = "Dynamic Content")
    public void dynamicContent() {
        final By contentLocator = By.cssSelector("#content > div.row");

        open("/dynamic_content");

        var contextListStrings = DriverManager.getDriver().findElements(contentLocator)
                .stream().map(WebElement::getText).toList();

        DriverManager.getDriver().navigate().refresh();

        var newContextListStrings = DriverManager.getDriver().findElements(contentLocator)
                .stream().map(WebElement::getText).toList();

        assertThat(contextListStrings).isNotEqualTo(newContextListStrings);
    }

    @Test(description = "Dynamic Controls")
    public void dynamicControlsTest() {
        var webDriverWait = new WebDriverWait(DriverManager.getDriver(), Duration.of(configuration().timeout(), ChronoUnit.SECONDS));
        final var CHECKBOX_CSS_SELECTOR = By.cssSelector("#checkbox-example [type=\"checkbox\"]");

        open("/dynamic_controls");
        var inputButton = DriverManager.getDriver().findElement(By.cssSelector("#input-example button"));
        var inputField = DriverManager.getDriver().findElement(By.cssSelector("#input-example input"));
        var checkboxButton = DriverManager.getDriver().findElement(By.cssSelector("#checkbox-example button"));

        checkboxButton.click();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(CHECKBOX_CSS_SELECTOR));
        assertThatThrownBy(() -> DriverManager.getDriver().findElement(CHECKBOX_CSS_SELECTOR).isDisplayed()).isInstanceOf(NoSuchElementException.class).hasMessageContaining("Unable to locate element");

        checkboxButton.click();
        var checkbox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CHECKBOX_CSS_SELECTOR));
        assertThat(checkbox.isDisplayed()).withFailMessage("Checkbox is visible!").isTrue();

        inputButton.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputField));
        assertThat(inputField.isEnabled()).withFailMessage("Input field is not enabled!").isTrue();

        inputButton.click();
        webDriverWait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(inputField)));
        assertThat(inputField.isEnabled()).withFailMessage("Input field is enabled!").isFalse();
    }

    @Test(description = "Dynamic Loading")
    public void dynamicLoadingTest() {
        var webDriverWait = new WebDriverWait(DriverManager.getDriver(), Duration.of(configuration().timeout(), ChronoUnit.SECONDS));

        open("/dynamic_loading/2");
        DriverManager.getDriver().findElement(By.cssSelector("#start button")).click();

        var finishText = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish")));
        assertThat(finishText.getText()).isEqualTo("Hello World!");
    }

    @Test(description = "File Download")
    public void FileDownloadTest() {
        open("/download");

        var fileDownload = DriverManager.getDriver().findElement(By.cssSelector(".example a"));
        String fileText = fileDownload.getText();
        fileDownload.click();


        File downloadedFile = new File(System.getProperty("user.dir") + "/src/" + fileText);
        int waitTime = 0;
        while (!downloadedFile.exists() && waitTime < configuration().timeout()*1000) {
            try {
                Thread.sleep(1000);
                waitTime++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assertThat(downloadedFile.exists()).withFailMessage(fileText + " file is not present in /src folder").isTrue();
    }

    @Test(description = "File Upload")
    public void FileUploadTest() {
        open("/upload");

        String uploadFile = "selenium-grid-execution.gif";

        DriverManager.getDriver().findElement(By.cssSelector("input[type=file]"))
                .sendKeys(System.getProperty("user.dir") + "/assets/" + uploadFile);

        DriverManager.getDriver().findElement(By.cssSelector("#file-submit")).click();

        String fileName = DriverManager.getDriver().findElement(By.cssSelector("#uploaded-files")).getText();
        assertThat(fileName).isEqualTo(uploadFile);
    }

    @Test(description = "Floating Menu")
    public void FloatingMenuTest() {
        open("/floating_menu");

        var menuElement = DriverManager.getDriver().findElement(By.cssSelector("#menu"));

        DriverManager.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
        assertThat(menuElement.isDisplayed()).isTrue();
    }

    @Test(description = "Iframe")
    public void IframeTest() {
        open("/iframe");

        var iframeElement = DriverManager.getDriver().findElement(By.cssSelector("#mce_0_ifr"));
        DriverManager.getDriver().switchTo().frame(iframeElement);

        var iframeBody = DriverManager.getDriver().findElement(By.cssSelector("body"));
        iframeBody.sendKeys("random text");
        assertThat(DriverManager.getDriver().findElement(By.cssSelector("body")).getText()).contains("random text");
    }

    @Test(description = "Mouse Hover")
    public void MouseHoverTest() {
        open("/hovers");

        Actions actions = new Actions(DriverManager.getDriver());
        var figures = DriverManager.getDriver().findElements(By.cssSelector(".figure"));
        IntStream.rangeClosed(1, figures.size()).forEach(i -> {
            actions.moveToElement(figures.get(i - 1)).perform();
            var additionalText = DriverManager.getDriver().findElement(By.xpath("//h5[text()='name: user" + i + "']"));
            assertThat(additionalText.isDisplayed()).isTrue();
        });
    }

    @Test(description = "JavaScript Alerts")
    public void JavaScriptAlertsTest() {
        final String PROMPT_TEXT = "js test";
        open("/javascript_alerts");

        DriverManager.getDriver().findElement(By.cssSelector("[onclick=\"jsAlert()\"]")).click();
        DriverManager.getDriver().switchTo().alert().accept();
        var resultElement = DriverManager.getDriver().findElement(By.cssSelector("#result"));
        assertThat(resultElement.getText()).isEqualTo("You successfuly clicked an alert");

        DriverManager.getDriver().findElement(By.cssSelector("[onclick=\"jsConfirm()\"]")).click();
        DriverManager.getDriver().switchTo().alert().accept();
        assertThat(resultElement.getText()).isEqualTo("You clicked: Ok");

        DriverManager.getDriver().findElement(By.cssSelector("[onclick=\"jsPrompt()\"]")).click();
        var alert = DriverManager.getDriver().switchTo().alert();
        alert.sendKeys(PROMPT_TEXT);
        alert.accept();
        assertThat(resultElement.getText()).isEqualTo("You entered: " + PROMPT_TEXT);
    }

    @Test(description = "JavaScript Error")
    public void JavaScriptErrorTests() {
        open("/javascript_error");

        LogEntries logEntries = DriverManager.getDriver().manage().logs().get(LogType.BROWSER);
        List<String> logMessages = logEntries.getAll().stream().map(LogEntry::getMessage).toList();
        assertThat(logMessages).anyMatch(log -> log.contains("Cannot read properties of undefined (reading 'xyz')"));
    }

    @Test(description = "Open in New Tab")
    public void OpenInNewTabTest() {
        open("/windows");

        DriverManager.getDriver().findElement(By.cssSelector("#content a")).click();

        Set<String> windowHandles = DriverManager.getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            DriverManager.getDriver().switchTo().window(windowHandle);
        }

        var newText = DriverManager.getDriver().findElement(By.cssSelector("h3")).getText();
        assertThat(newText).isEqualTo("New Window");
    }

    @Test(description = "Notification Message")
    public void NotificationMessageTest() {
        final List<String> expectedMessages = Arrays.asList("Action successful", "Action unsuccesful, please try again", "Action unsuccesful");

        open("/notification_message_rendered");

        for (int i = 0; i < 5; i++) {

            DriverManager.getDriver().findElement(By.cssSelector("[href=\"/notification_message\"]")).click();

            var newText = DriverManager.getDriver().findElement(By.cssSelector("#flash")).getText().split("\n")[0];
            assertThat(newText).containsAnyOf(expectedMessages.toArray(new String[0]));
        }
    }
}
