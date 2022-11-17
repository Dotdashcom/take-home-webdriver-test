package webdriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WebDriverTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\mywork\\Johnson-daman\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    void cleanUp() {
        if (driver != null) driver.quit();
    }

    @Test
    void checkForTitlePage() {
        String loginUrl = "http://localhost:7080/login";
        driver.get(loginUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);
    }

    @Test
    void testForUserAbleTologin() {
        String loginUrl = "http://localhost:7080/login";
        driver.get(loginUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        String actualUrl = "http://localhost:7080/secure";
        String pageSource = driver.getPageSource();

        boolean userAbleToLogin = actualUrl.equals(driver.getCurrentUrl());
        assertEquals(true, userAbleToLogin);

        assertTrue(pageSource.contains("You logged into a secure area!"));
    }

    @Test
    void whenInvalidUserNameIsSuppliedThenDisplayErrorMessage() {
        String loginUrl = "http://localhost:7080/login";
        driver.get(loginUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("tomsmith1");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        String actualUrl = "http://localhost:7080/login";
        String expectedUrl = driver.getCurrentUrl();
        String pageSource = driver.getPageSource();

        assertEquals(expectedUrl, actualUrl);
        assertTrue(pageSource.contains("Your username is invalid!"));
    }

    @Test
    void whenInvalidPasswordSuppliedShouldThrowErrorMessage() {
        String loginUrl = "http://localhost:7080/login";
        driver.get(loginUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!!");
        loginPage.clickLogin();

        String actualUrl = "http://localhost:7080/login";
        String expectedUrl = driver.getCurrentUrl();
        String pageSource = driver.getPageSource();

        assertEquals(expectedUrl, actualUrl);
        assertTrue(pageSource.contains("Your password is invalid!"));
    }


    @Test
    void testForCheckBoxes() {
        String loginUrl = "http://localhost:7080/checkboxes";
        driver.get(loginUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        assertNotNull(checkboxes);
        assertEquals(false, checkboxes.get(0).isSelected());
        assertEquals(true, checkboxes.get(1).isSelected());
    }

    @Test
    void testForJavaScriptAlert() {
        String loginUrl = "http://localhost:7080/context_menu";
        driver.get(loginUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).build().perform();
        String text = driver.switchTo().alert().getText();
        String message = "You selected a context menu";
        assertEquals(message, text);
    }

    // @Test
    void testForDragAndDrop() {

        String loginUrl = "http://localhost:7080/drag_and_drop";
        driver.get(loginUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        WebElement from = driver.findElement(By.xpath("//*[@id='column-a']"));
        WebElement to = driver.findElement(By.xpath("//*[@id='column-b']"));
        System.out.println("from" + from);
        System.out.println("to" + to);

        //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        int x = to.getLocation().x;
        int y = to.getLocation().y;

//        Actions actions = new Actions(driver);
//        actions.moveToElement(from)
//                .clickAndHold(from)
//                .moveToElement(to)
//                .release().build().perform();

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(from, 100, 100).build().perform();

        //     Action dragAndDrop = actions.clickAndHold(from.findElement(By.xpath("//header[text()='A']")));
//                .moveToElement(to.findElement(By.xpath("//header[text()='B']")))
//                .release(to.findElement(By.xpath("//header[text()='B']")))
//                .build();
//
//        dragAndDrop.perform();
    }

    @Test
    void testForDropdownList() {
        String loginUrl = "http://localhost:7080/dropdown";
        driver.get(loginUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        // check for default value
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        WebElement element = dropDown.getFirstSelectedOption();
        assertNotNull(element);
        assertEquals("Please select an option", element.getText());

        String option1 = dropDown.getOptions().get(1).getText();
        assertEquals("Option 1", option1);

        String option2 = dropDown.getOptions().get(2).getText();
        assertEquals("Option 2", option2);

        dropDown.selectByIndex(1);
        assertEquals("Option 1", dropDown.getFirstSelectedOption().getText());

        dropDown.selectByIndex(2);
        assertEquals("Option 2", dropDown.getFirstSelectedOption().getText());
    }

    @Test
    void testForDynamicContent() {
        String controlUrl = "http://localhost:7080/dynamic_content";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        //// remove button test, once clicked, the button text is changed to 'Add'
        List<WebElement> images = driver.findElements(By.xpath("//div/img"));
        assertEquals(3, images.size());
        List<String> firstImageList = new ArrayList<>();
        for (WebElement webElement : images) {
            firstImageList.add(webElement.getAttribute("src"));
        }
        // reload the page
        driver.navigate().refresh();
        // will get different image names
        List<WebElement> freshImages = driver.findElements(By.xpath("//div/img"));
        // compare image names
        boolean isDifferent = false;
        for (int i = 0; i < freshImages.size(); i++) {
            WebElement webElement = freshImages.get(i);
            if (!webElement.getAttribute("src").equals(firstImageList.get(i))) {
                isDifferent = true;
                break;
            }
        }
        assertEquals(true, isDifferent);

        // add the current images to the first list
        addImageToList(firstImageList, freshImages);
        isDifferent = false;
        // reload the page again
        driver.navigate().refresh();

        freshImages = driver.findElements(By.xpath("//div/img"));
        // compare image names
        for (int i = 0; i < freshImages.size(); i++) {
            WebElement webElement = freshImages.get(i);
            if (!webElement.getAttribute("src").equals(firstImageList.get(i))) {
                isDifferent = true;
                break;
            }
        }
        assertEquals(true, isDifferent);
    }

    @Test
    void testForDynamicControlForRemoveButton() {
        String controlUrl = "http://localhost:7080/dynamic_controls";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        //// remove button test, once clicked, the button text is changed to 'Add'
        WebElement checkboxElement = driver.findElement(By.xpath("//input[@type='checkbox']"));

        WebElement button = driver.findElement(By.xpath("//button[@type='button']"));
        button.click();
        WebElement waitResult = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button']")));

        assertEquals("Add", waitResult.getText());
        checkboxElement = null;
        try {
            checkboxElement = driver.findElement(By.xpath("//input[@type='checkbox']"));
        } catch (Exception e) {
        }

        /// check box is removed and null
        assertEquals(null, checkboxElement);

    }

    @Test
    void testForDynamicControlForAddButton() {
        String controlUrl = "http://localhost:7080/dynamic_controls";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        WebElement button = driver.findElement(By.xpath("//button[@type='button']"));
        button.click();

        WebElement waitResult = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button']")));

        assertEquals("Add", waitResult.getText());
        // clicks on add button
        waitResult.click();

        WebElement checkbox = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));

        assertTrue(checkbox != null);
    }

    @Test
    void testForDynamicControlForEnableTextbox() {
        String controlUrl = "http://localhost:7080/dynamic_controls";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        List<WebElement> buttons = driver.findElements(By.xpath("//button[@type='button']"));
        WebElement enableButton = buttons.get(1);
        enableButton.click();

        WebElement text = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));

        assertEquals(true, text.isEnabled());
    }

    @Test
    void testForDynamicControlForDisableTextbox() {
        String controlUrl = "http://localhost:7080/dynamic_controls";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        WebElement text = driver.findElement(By.xpath("//input[@type='text']"));
        List<WebElement> buttons = driver.findElements(By.xpath("//button[@type='button']"));
        WebElement enableButton = buttons.get(1);
        enableButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = webDriverWait.until(ExpectedConditions.elementToBeClickable(enableButton));
        button.click();
        WebElement textwait = new WebDriverWait(driver, Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        assertTrue(!text.isEnabled());
    }

    @Test
    void testForDynamicLoading2() {
        String controlUrl = "http://localhost:7080/dynamic_loading/2";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();
        WebElement textwait = new WebDriverWait(driver, Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));

        // check for the Hello world text
        assertEquals("Hello World!", textwait.getText());
    }

    @Test
    void testForDownload() {
        String controlUrl = "http://localhost:7080/download";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        WebElement btnDownload = driver.findElement(By.xpath("//a[@href='download/some-file.txt']"));
        btnDownload.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.getPageSource());
        File file = new File(System.getProperty("user.home") + "/downloads/some-file.txt");
        assertEquals(true, file.exists());
    }

    @Test
    void testFoFileUpload() {

        String controlUrl = "http://localhost:7080/upload";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        WebElement uploadElement = driver.findElement(By.id("file-upload"));
        final String fileName = "webdriver.txt";
        uploadElement.sendKeys("D:\\mywork\\Johnson-daman\\" + fileName);

        WebElement uploadButton = driver.findElement(By.xpath("//input[@type='submit']"));
        uploadButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.id("uploaded-files"));
        assertEquals(fileName, element.getText());
    }

    @Test
    void testForFloatingMenu() {
        String controlUrl = "http://localhost:7080/floating_menu";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        WebElement menu = driver.findElement(By.id("menu"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, document.body.scrollHeight)");
        assertEquals(true, menu.isDisplayed());
    }

    // Note: The tinyMCE WYSWYG editor should be wrapped inside an iframe tag and it is
    // possible to switch to iframe calling driver.switchTo().frame(iframe element).
    // In the current HTML, this  editor is not wrapped inside an iframe.
    // Refer:https://yizeng.me/2014/01/31/test-wysiwyg-editors-using-selenium-webdriver/
    //@Test
    void testForIFrame() {

        String controlUrl = "http://localhost:7080/iframe";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        WebElement textArea = driver.findElement(By.xpath("//textarea"));
        WebElement frame = driver.findElement(By.id("tinymce-editor_ifr"));
        driver.switchTo().frame(frame);

        final String msg = "hello";
        String js = "document.getElementsByTagName('textarea')[0].innerHTML='hello';";
        ((JavascriptExecutor) driver).executeScript(js);
        System.out.println(textArea.getText());
    }

    @Test
    void testForHover() {
        String controlUrl = "http://localhost:7080/hovers";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        List<WebElement> images = driver.findElements(By.xpath("//div/img"));

        Actions actions = new Actions(driver);
        actions.moveToElement(images.get(0)).perform();

        List<WebElement> infoList = new WebDriverWait(driver, Duration.ofSeconds(1))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div/h5")));
        assertEquals(true, infoList.get(0).isDisplayed());

        actions.moveToElement(images.get(1)).perform();

        infoList = new WebDriverWait(driver, Duration.ofSeconds(1))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div/h5")));

        assertEquals(true, infoList.get(1).isDisplayed());

        actions.moveToElement(images.get(2)).perform();
        infoList = new WebDriverWait(driver, Duration.ofSeconds(4))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div/h5")));

        assertEquals(true, infoList.get(2).isDisplayed());
    }

    @Test
    void testForJavaScriptAlerts() {
        String controlUrl = "http://localhost:7080/javascript_alerts";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> buttons = driver.findElements(By.xpath("//ul/li/button"));
        buttons.get(0).click();
        String textAlert = driver.switchTo().alert().getText();
        assertEquals("I am a JS Alert", textAlert);
        Alert jsAlert = driver.switchTo().alert();
        jsAlert.accept();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        buttons.get(1).click();
        String textConfirm = driver.switchTo().alert().getText();
        assertEquals("I am a JS Confirm", textConfirm);
        Alert jsConfirm = driver.switchTo().alert();
        jsConfirm.accept();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        buttons.get(2).click();
        Alert jsPrompt = driver.switchTo().alert();
        jsPrompt.sendKeys("hello");
        jsPrompt.accept();

        WebElement result = driver.findElement(By.id("result"));
        String word = result.getText().split(":")[1].trim();
        assertEquals("hello", word);
    }

    @Test
    void testForJavaScriptError() {
        String controlUrl = "http://localhost:7080/javascript_error";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> lg = logEntries.getAll();
        String runtimeError = null;
        for (LogEntry logEntry : lg) {
            if (logEntry.getMessage().contains("Uncaught TypeError")) {
                runtimeError = logEntry.getMessage().split("Uncaught TypeError")[1];
                break;
            }
        }
        runtimeError = runtimeError.replace(": ", "");
        assertEquals("Cannot read properties of undefined (reading 'xyz')", runtimeError);
    }

    @Test
    void testForBrowserTab() {
        String controlUrl = "http://localhost:7080/windows";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        WebElement href = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        href.click();
        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // test for new tab
        assertEquals(2, driver.getWindowHandles().size());

        driver.get("http://localhost:7080/windows/new");
        WebElement h3 = driver.findElement(By.xpath("//div/h3"));
        assertEquals("New Window", h3.getText());
    }

    @Test
    void testForNotification() {
        String controlUrl = "http://localhost:7080/notification_message_rendered";
        driver.get(controlUrl);
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);

        WebElement href = driver.findElement(By.xpath("//a[@href='/notification_message']"));
        href.click();
        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<String> messageList = new ArrayList<>();
        messageList.add("Action successful×");
        messageList.add("Action unsuccesful, please try again×");

        WebElement element = driver.findElement(By.id("flash"));
        String message = element.getText();
        message = message.replace("\n", "");
        System.out.println(message);
        boolean expected = messageList.contains(message);
        assertEquals(true, expected);
    }

    private void addImageToList(List<String> firstImageList, List<WebElement> freshImages) {
        firstImageList = new ArrayList<>();
        for (WebElement webElement : freshImages) {
            firstImageList.add(webElement.getAttribute("src"));
        }
    }
}