package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.BrowserUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class TestTasks extends TestBase {

    String fileName = "/some-file.txt";
    String downloadPath = System.getProperty("user.home") + "/Downloads";


    @Test(
            dataProvider = "loginCredentials",
            dataProviderClass = DataProviderLogin.class
    )
    public void loginTest(String username, String password, String message) {
        String path = "/login";
        this.driver.navigate().to(this.baseUrl + path);
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.getSuccessMessage().getText().trim().contains(message));
    }

    @Test
    public void checkBoxes() {
        String path = "/checkboxes";
        this.driver.navigate().to(this.baseUrl + path);
        WebElement checkbox1 = this.driver.findElement(By.xpath("//input[@type = 'checkbox'][1]"));
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
        WebElement checkbox2 = this.driver.findElement(By.xpath("//input[@type = 'checkbox'][2]"));
        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected());
    }

    @Test
    public void contextMenu() {
        String path = "/context_menu";
        this.driver.navigate().to(this.baseUrl + path);
        WebElement box = this.driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions action = new Actions(this.driver);
        action.contextClick(box).perform();
        Alert alert = this.driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(), "You selected a context menu");
        alert.accept();
    }

    @Test
    public void dragAndDrop() {
        String path = "/drag_and_drop";
        this.driver.navigate().to(this.baseUrl + path);
        WebElement box1 = this.driver.findElement(By.id("column-a"));
        WebElement box2 = this.driver.findElement(By.id("column-b"));
        Assert.assertEquals(box1.getText().trim(), "A");
        Assert.assertEquals(box2.getText().trim(), "B");
        new Actions(this.driver);
        BrowserUtils.dragAndDropUsingJavaScript(this.driver, box1, box2);
        Assert.assertEquals(box1.getText().trim(), "B");
        Assert.assertEquals(box2.getText().trim(), "A");
    }

    @Test
    public void dropDown() {
        String path = "/dropdown";
        this.driver.navigate().to(this.baseUrl + path);
        WebElement dropDown = this.driver.findElement(By.xpath("//select[@id='dropdown']"));
        BrowserUtils.selectBy(dropDown, "Option 1", "text");
        Select select = new Select(dropDown);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        Assert.assertEquals(BrowserUtils.getText(firstSelectedOption), "Option 1");
        BrowserUtils.selectBy(dropDown, "Option 2", "text");
        WebElement secondSelectedOption = select.getFirstSelectedOption();
        Assert.assertEquals(BrowserUtils.getText(secondSelectedOption), "Option 2");
    }

    @Test
    public void dynamicContent() {
        String path = "/dynamic_content ";
        this.driver.navigate().to(this.baseUrl + path);
        List<WebElement> dynamicElements = this.driver.findElements(By.className("//div[@id='content']//div[contains(@class,'large')]"));
        List<String> contentBeforeRefresh = new ArrayList<>();

        for(int i = 1; i <= dynamicElements.size(); ++i) {
            contentBeforeRefresh.add(BrowserUtils.getText(dynamicElements.get(i)));
        }

        int numberOfRefreshes = 2;

        for(int i = 0; i < numberOfRefreshes; ++i) {
            this.driver.navigate().refresh();
            dynamicElements = this.driver.findElements(By.className("//div[@id='content']//div[contains(@class,'large')]"));

            for(int j = 0; j < dynamicElements.size(); ++j) {
                WebElement element = dynamicElements.get(j);
                String contentAfterRefresh = element.getText();
                Assert.assertNotEquals("Dynamic content " + (j + 1) + " should change on refresh", contentBeforeRefresh.get(j), contentAfterRefresh);
                contentBeforeRefresh.set(j, contentAfterRefresh);
            }
        }

    }

    @Test
    public void dynamic_controls() {
        String path = "/dynamic_controls";
        this.driver.navigate().to(this.baseUrl + path);
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(45L));
        String commonPathForMessage = "//p[@id='message']";
        WebElement checkbox = this.driver.findElement(By.xpath("//div[@id='checkbox']"));
        WebElement removeButton = this.driver.findElement(By.xpath("//button[contains(text(), 'Remove')]"));
        removeButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(commonPathForMessage)));
        WebElement message = this.driver.findElement(By.xpath(commonPathForMessage));
        Assert.assertEquals(message.getText().trim(), "It's gone!");
        WebElement addButton = this.driver.findElement(By.xpath("//button[contains(text(), 'Add')]"));
        addButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(commonPathForMessage)));
        WebElement messageBack = this.driver.findElement(By.xpath(commonPathForMessage));
        Assert.assertEquals(BrowserUtils.getText(messageBack), "It's back!");
        this.driver.navigate().refresh();
        WebElement enableButton = this.driver.findElement(By.xpath("//button[contains(text(), 'Enable')]"));
        enableButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(commonPathForMessage)));
        WebElement messageEnabled = this.driver.findElement(By.xpath(commonPathForMessage));
        Assert.assertEquals(BrowserUtils.getText(messageEnabled), "It's enabled!");
        WebElement disableButton = this.driver.findElement(By.xpath("//button[contains(text(), 'Disable')]"));
        disableButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(commonPathForMessage)));
        WebElement messageDisabled = this.driver.findElement(By.xpath(commonPathForMessage));
        Assert.assertEquals(BrowserUtils.getText(messageDisabled), "It's disabled!");
    }

    @Test
    public void dynamicLoading() {
        String path = "/dynamic_loading/2";
        this.driver.navigate().to(this.baseUrl + path);
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30L));
        WebElement startButton = this.driver.findElement(By.xpath("//button[contains(text(), 'Start')]"));
        startButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(), 'Hello World!')]")));
        WebElement text = this.driver.findElement(By.xpath("//h4[contains(text(), 'Hello World!')]"));
        Assert.assertEquals(text.getText().trim(), "Hello World!");
    }

    @Test(
            priority = 1
    )
    public void fileDownload() {
        String path = "/download";
        this.driver.navigate().to(this.baseUrl + path);
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30L));
        WebElement dnwFile = this.driver.findElement(By.xpath("//a[contains(text(), 'some-file.txt')]"));
        dnwFile.click();
        Path filePath = Paths.get(this.downloadPath, this.fileName);
        wait.until((driver) -> Files.exists(filePath));
        Assert.assertTrue(Files.exists(filePath), "File is not downloaded");
    }

    @Test(
            priority = 2
    )
    public void fileUpload() {
        String path = "/upload";
        this.driver.navigate().to(this.baseUrl + path);
        WebElement uploadButton = this.driver.findElement(By.xpath("//input[@id = 'file-submit']"));
        Path filePath = Paths.get(this.downloadPath, this.fileName);
        WebElement fileInput = this.driver.findElement(By.xpath("//input[@id = 'file-upload']"));
        fileInput.sendKeys(filePath.toString());
        uploadButton.click();
        WebElement successMessage = this.driver.findElement(By.xpath("//h3[contains(text(), 'File Uploaded')]"));
        Assert.assertEquals(successMessage.getText().trim(), "File Uploaded!");
    }

    @Test
    public void floatingMenu() {
        String path = "/floating_menu";
        this.driver.navigate().to(this.baseUrl + path);
        WebElement lastElementOnAPage = this.driver.findElement(By.xpath("//a[contains(text(), 'Elemental Selenium')]"));
        BrowserUtils.scrollIntoView(this.driver, lastElementOnAPage);
        List<WebElement> menuElements = this.driver.findElements(By.tagName("li"));

        for (WebElement element : menuElements) {
            Assert.assertTrue(element.isDisplayed());
        }

    }

    @Test
    public void iFrame() {
        String path = "/iframe";
        this.driver.navigate().to(this.baseUrl + path);

        WebElement textPlace;
        try {
            textPlace = this.driver.findElement(By.xpath("//button//div[@class = 'tox-icon']"));
            textPlace.click();
        } catch (NoSuchElementException var4) {
            System.out.println("This element is not found");
        }

        this.driver.switchTo().frame("mce_0_ifr");
        textPlace = this.driver.findElement(By.xpath("//body[@id = 'tinymce']"));
        textPlace.clear();
        String text = "My text";
        textPlace.sendKeys(text);
        Assert.assertEquals(textPlace.getText().trim(), text);
    }

    @Test
    public void mouseHover() {
        String path = "/hovers";
        this.driver.navigate().to(this.baseUrl + path);
        Actions actions = new Actions(this.driver);
        List<WebElement> pictures = this.driver.findElements(By.xpath("//div[@class = 'figure']"));
        List<WebElement> texts = this.driver.findElements(By.tagName("h5"));

        for(int i = 0; i < pictures.size(); ++i) {
            actions.moveToElement(pictures.get(i)).clickAndHold(pictures.get(i)).perform();
            Assert.assertTrue(texts.get(i).isDisplayed(), "Text is not Displayed");
        }

    }

    @Test
    public void jsAlerts() {
        String path = "/javascript_alerts";
        this.driver.navigate().to(this.baseUrl + path);
        WebElement jsClickButton = this.driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Alert')]"));
        WebElement jsConfirmButton = this.driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]"));
        WebElement jsPromptButton = this.driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Prompt')]"));
        WebElement resultText = this.driver.findElement(By.xpath("//p[@id = 'result']"));
        String message = "Hello";
        jsClickButton.click();
        Alert alert = this.driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(resultText.getText().trim(), "You successfuly clicked an alert");
        jsConfirmButton.click();
        alert = this.driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(resultText.getText().trim(), "You clicked: Ok");
        jsPromptButton.click();
        alert.sendKeys(message);
        alert.accept();
        Assert.assertTrue(resultText.getText().contains(message));
    }

    @Test
    public void jsError() {
        String path = "/javascript_error";
        this.driver.navigate().to(this.baseUrl + path);
        LogEntries logEntries = this.driver.manage().logs().get("browser");
        String text = "Cannot read properties of undefined (reading 'xyz')";

        for (LogEntry entry : logEntries) {
            if (entry.getLevel() == Level.SEVERE) {
                Assert.assertTrue(entry.getMessage().contains(text));
            }
        }

    }

    @Test
    public void openInNewTab() {
        String path = "/windows";
        this.driver.navigate().to(this.baseUrl + path);
        WebElement clickHereButton = this.driver.findElement(By.xpath("//a[contains(text(), 'Click Here')]"));
        clickHereButton.click();
        BrowserUtils.switchById(this.driver);
        Assert.assertEquals(this.driver.getTitle().trim(), "New Window");
    }

    @Test
    public void notificationMessage() {
        String path = "/notification_message_rendered";
        this.driver.navigate().to(this.baseUrl + path);
        WebElement clickHereButton = this.driver.findElement(By.xpath("//a[contains(text(), 'Click here')]"));
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        int maxClicks = 10;

        for(int numClicks = 0; numClicks < maxClicks; ++numClicks) {
            clickHereButton.click();
            clickHereButton = this.driver.findElement(By.xpath("//a[contains(text(), 'Click here')]"));
            WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash-messages")));
            String messageText = messageElement.getText();
            if (messageText.contains("Action Successful")) {
                Assert.assertTrue(messageElement.isDisplayed());
            } else if (messageText.contains("Action unsuccesful, please try again")) {
                Assert.assertTrue(messageElement.isDisplayed());
            }
        }

    }
}
