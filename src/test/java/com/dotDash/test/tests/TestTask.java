package com.dotDash.test.tests;

import com.dotDash.test.pages.LoginDataDotDash;
import com.dotDash.test.pages.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;


public class TestTask extends TestBaseDotDash {

    @Test
    public void dynamicContentTest() {
        String urlPath = "/dynamic_content";
        driver.navigate().to(Url + urlPath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement displayedInfo = driver.findElement(By.xpath("//div[@class = 'large-10 columns large-centered']"));
        String elementBeforeRefresh = displayedInfo.getText();
        int amountOfRuns = 5;
        while (amountOfRuns > 0) {
            driver.navigate().refresh();
            displayedInfo = driver.findElement(By.xpath("//div[@class = 'large-10 columns large-centered']"));
            wait.until(ExpectedConditions.visibilityOf(displayedInfo));
            Assert.assertNotEquals(elementBeforeRefresh, displayedInfo.getText());
            elementBeforeRefresh = displayedInfo.getText();
            amountOfRuns--;
        }
    }

    @Test
    public void contextClickTest() {
        String urlPath = "/context_menu";
        driver.navigate().to(Url + urlPath);
        WebElement contextWindow = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(contextWindow).perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu", "Alert is not displayed");
    }

    @Test
    public void drugAndDropTest() {
        String urlPath = "/drag_and_drop";
        driver.navigate().to(Url + urlPath);
        WebElement elementA = driver.findElement(By.id("column-a"));
        WebElement elementB = driver.findElement(By.id("column-b"));
        BrowserUtils.dragAndDropJS(driver, elementA, elementB);
        Assert.assertEquals(elementA.getText(), "B", "Element value has never changed");
        Assert.assertEquals(elementB.getText(), "A", "Element value has never changed");
    }

    @Test
    public void dropDownTest() {
        String urlPath = "/dropdown";
        driver.navigate().to(Url + urlPath);
        WebElement dropDown = driver.findElement(By.xpath("//select[@id = 'dropdown']"));
        Select dropdown = new Select(dropDown);

        dropdown.selectByVisibleText("Option 1");
        Assert.assertTrue(dropdown.getOptions().get(1).isSelected());

        dropdown.selectByValue("2");
        Assert.assertTrue(dropdown.getOptions().get(2).isSelected());
    }


    @Test(dataProvider = "loginParameters", dataProviderClass = LoginDataDotDash.class)
    public void loginTest(String username, String password, String message) {
        String urlPath = "/login";
        driver.navigate().to(Url + urlPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginOnPage(username, password);
        Assert.assertTrue(loginPage.getMessage().getText().contains(message));
    }

    @Test
    public void dynamicControlsTest() {
        String urlPath = "/dynamic_controls";
        driver.navigate().to(Url + urlPath);
        WebElement checkBox = driver.findElement(By.xpath("//input[@type = 'checkbox']"));
        WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(), 'Remove')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        removeButton.click();
        wait.until(ExpectedConditions.invisibilityOf(checkBox));
        WebElement removeMessage = driver.findElement(By.xpath("//p[@id = 'message']"));
        Assert.assertTrue(removeMessage.isDisplayed());
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(), 'Add')]"));
        addButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id = 'message']")));
        checkBox = driver.findElement(By.xpath("//input[@type = 'checkbox']"));
        Assert.assertTrue(checkBox.isDisplayed());
        WebElement enableButton = driver.findElement(By.xpath("//button[contains(text(), 'Enable')]"));
        enableButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id = 'message']")));
        WebElement textBar = driver.findElement(By.xpath("//input[@type = 'text']"));
        Assert.assertTrue(textBar.isEnabled());
        WebElement disableButton = driver.findElement(By.xpath("//button[contains(text(), 'Disable')]"));
        disableButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id = 'message']")));
        textBar = driver.findElement(By.xpath("//input[@type = 'text']"));
        Assert.assertFalse(textBar.isEnabled());
    }

    @Test
    public void dynamicLoadingTest() {
        String urlPath = "/dynamic_loading/2";
        driver.navigate().to(Url + urlPath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement startButton = driver.findElement(By.xpath("//button[contains(text(), 'Start')]"));
        startButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(), 'Hello ')]")));
        Assert.assertTrue(driver.findElement(By.xpath("//h4[contains(text(), 'Hello ')]")).isDisplayed());
    }

    @Test
    public void checkboxesTest() {
        String urlPath = "/checkboxes";
        driver.navigate().to(Url + urlPath);
        WebElement firstCheckBox = driver.findElement(By.xpath("//input[@type = 'checkbox'][1]"));
        WebElement secondCheckBox = driver.findElement(By.xpath("//input[@type = 'checkbox'][2]"));
        firstCheckBox.click();
        Assert.assertTrue(firstCheckBox.isSelected());
        secondCheckBox.click();
        Assert.assertFalse(secondCheckBox.isSelected());
    }

    String file = "/some-file.txt";
    String path = System.getProperty("user.home") + "/Downloads";

    @Test(priority = 1)
    public void fileDownloadTest() {
        String urlPath = "/download";
        driver.navigate().to(Url + urlPath);
        WebElement fileDownload = driver.findElement(By.linkText("some-file.txt"));
        fileDownload.click();
        Path filePath = Paths.get(path, file);
        Assert.assertTrue(Files.exists(filePath), "File is not downloaded");
    }

    @Test(priority = 2)
    public void fileUploadTest() {
        String urlPath = "/upload";
        driver.navigate().to(Url + urlPath);
        Path filePath = Paths.get(path, file);
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        WebElement fileUploadButton = driver.findElement(By.id("file-submit"));
        chooseFile.sendKeys(filePath.toString());
        fileUploadButton.click();
        WebElement successMessage = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(successMessage.getText(), "File Uploaded!");
    }

    @Test
    public void floatingMenuTest() {
        String urlPath = "/floating_menu ";
        driver.navigate().to(Url + urlPath);
        List<WebElement> menuOptions = driver.findElements(By.tagName("li"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        for (WebElement element : menuOptions) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @Test
    public void iframeTest() {
        String text = "HelloWorld";
        String urlPath = "/iframe ";
        driver.navigate().to(Url + urlPath);
        WebElement closePopButton = driver.findElement(By.xpath("//div[@class = 'tox-notifications-container']//button"));
        closePopButton.click();
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBar = driver.findElement(By.xpath("//body[@id = 'tinymce']"));
        textBar.clear();
        textBar.sendKeys(text);
        Assert.assertEquals(textBar.getText(), text);
    }

    @Test
    public void notificationMessageTest() {
        String urlPath = "/notification_message_rendered";
        driver.navigate().to(Url + urlPath);
        WebElement clickHereButton;
        int amountOfRuns = 10;
        List<String> possibleMessages = Arrays.asList("Action successful", "Action unsuccesful, please try again");
        for (int i = 0; i < amountOfRuns; i++) {
            clickHereButton = driver.findElement(By.linkText("Click here"));
            clickHereButton.click();
            WebElement message = driver.findElement(By.xpath("//div[@id = 'flash']"));
            if (message.getText().contains("successful")) {
                Assert.assertTrue(message.getText().contains(possibleMessages.get(0)));
            } else {
                Assert.assertTrue(message.getText().contains(possibleMessages.get(1)));
            }
        }
    }

    @Test
    public void mouseHoverTest() {
        String urlPath = "/hovers";
        driver.navigate().to(Url + urlPath);
        Actions actions = new Actions(driver);
        List<WebElement> eachImage = driver.findElements(By.xpath("//div[@class = 'figure']"));
        List<WebElement> eachImageText = driver.findElements(By.tagName("h5"));

        for (int i = 0; i < eachImage.size(); i++) {
            actions.moveToElement(eachImage.get(i)).clickAndHold(eachImage.get(i)).perform();
            Assert.assertTrue(eachImageText.get(i).isDisplayed());
        }
    }

    @Test
    public void jsAlertTest() {
        String urlPath = "/javascript_alerts";
        driver.navigate().to(Url + urlPath);
        List<WebElement> jsAlerts = driver.findElements(By.xpath("//li//button"));
        String text = "Hello";
        WebElement message;
        for (int i = 0; i < jsAlerts.size(); i++) {
            jsAlerts.get(i).click();
            Alert alert = driver.switchTo().alert();
            if (i == 0) {
                alert.accept();
                message = driver.findElement(By.xpath("//p[@id = 'result']"));
                Assert.assertEquals(message.getText(), "You successfuly clicked an alert");
            } else if (i == 1) {
                alert.accept();
                message = driver.findElement(By.xpath("//p[@id = 'result']"));
                Assert.assertEquals(message.getText(), "You clicked: Ok");
            } else {
                alert.sendKeys(text);
                alert.accept();
                message = driver.findElement(By.xpath("//p[@id = 'result']"));
                Assert.assertTrue(message.getText().contains(text));
            }
        }
    }

    @Test
    public void jsErrorTest() {
        String urlPath = "/javascript_error";
        driver.navigate().to(Url + urlPath);
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<String> severeErrors = new ArrayList<>();

        for (LogEntry entry : logEntries) {
            if (entry.getLevel() == Level.SEVERE) {
                severeErrors.add(entry.getMessage());
            }
        }

        if (severeErrors.size() == 1) {
            System.out.println(severeErrors);
            Assert.assertTrue(severeErrors.get(0).contains("Cannot read properties of undefined (reading 'xyz')"));
        }
    }

    @Test
    public void openInNewTabTest() {
        String urlPath = "/windows";
        driver.navigate().to(Url + urlPath);
        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();
        String mainPageId = driver.getWindowHandle();
        System.out.println(mainPageId);

        Set<String> allPagesId = driver.getWindowHandles();
        System.out.println(allPagesId);

        for (String id : allPagesId) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
            }
        }
        WebElement header = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(header.getText(), "New Window");
    }


}
