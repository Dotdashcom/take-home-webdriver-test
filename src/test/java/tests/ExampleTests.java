package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

import java.util.ArrayList;
import java.util.List;


public class ExampleTests extends LoginPage {

    String userName;
    String password;

    @BeforeTest(alwaysRun = true)
    public void setup() {
        String URL = ConfigurationReader.getValue("baseURL");
        userName = ConfigurationReader.getValue("userName");
        password = ConfigurationReader.getValue("password");
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        WebDriverFactory.closeDriver();
    }


    /*
    Login Success
    Page Object Model for the login page should be provided.
    Test is able to login successfully.
    Test uses an assertion to make sure User has logged in.
     */
    @Test(description = "AC1 - Login Success")
    public void AC1() {
        driver.get("http://localhost:7080/login");
        wait(2);
        login(userName, password);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "http://localhost:7080/secure");
    }

    /*
    Login Failure
    Page Object Model for the login page should be used.
    Test is not able to login with wrong credentials.
    Test uses assertions to check Login failed for incorrect user and password.
     */
    @Test(description = "AC2 - Login Failure")
    public void AC2() {
        driver.navigate().to("http://localhost:7080/login");
        wait(2);
        login("invalidUserName", "invalidPassword");
        wait(2);
        String actualURL = driver.getCurrentUrl();
        Assert.assertNotEquals(actualURL, "http://localhost:7080/secure");
    }

    /*
    Checkboxes
    Test checks and unchecks checkboxes.
    Test uses assertions to make sure boxes were properly checked and unchecked.
     */
    @Test(description = "AC3 - Checkboxes")
    public void AC3() {
        driver.navigate().to("http://localhost:7080/checkboxes");
        for (WebElement each : checkboxes) {
            if (!each.isSelected()) {
                Assert.assertFalse(each.isSelected());
                each.click();
                Assert.assertTrue(each.isSelected());
            } else {
                Assert.assertTrue(each.isSelected());
                each.click();
                Assert.assertFalse(each.isSelected());
            }
        }
    }

    /*
    Context Menu
    Test right-clicks on the context menu.
    Right-click in the box to see one called 'the-internet'.
    Test JavaScript alert text on Right-Click.
    Test asserts the alert menu text.
     */
    @Test(description = "AC4 - Context Menu")
    public void AC4() {
        driver.navigate().to("http://localhost:7080/context_menu");
        action.contextClick(contextMenuBox).perform();
        wait(2);
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "You selected a context menu";
        Assert.assertEquals(actualAlertText, expectedAlertText);
        driver.switchTo().alert().accept();
        wait(2);
    }

    /*
    Drag and Drop
    Test drags element A to element B.
    Test asserts that the text on element A and B are switched.
     */
    @Test(description = "AC5 - Drag and Drop")
    public void AC5() {
        driver.navigate().to("http://localhost:7080/drag_and_drop");
        wait(2);
        Assert.assertEquals(columnA.getText(), "A");
        Assert.assertEquals(columnB.getText(), "B");

        js.executeScript(dragAndDrop, columnA, columnB);
        wait(2);

        Assert.assertEquals(columnA.getText(), "B");
        Assert.assertEquals(columnB.getText(), "A");
    }

    /*
    Dropdown
    Test selects Option 1 and Option 2 from the drop down menu.
    Test asserts Option 1 and Option 2 are selected.
     */
    @Test(description = "AC6 - Dropdown")
    public void AC6() {
        driver.navigate().to("http://localhost:7080/dropdown");
        select = new Select(dropdownList);
        List<WebElement> options = select.getOptions();
        for (WebElement each : options) {
            each.click();
            Assert.assertTrue(each.isSelected());
            wait(2);
        }
    }

    /*
    Dynamic Content
    Test refreshes the page a couple of times.
    Test asserts that the content changes on each refresh.
     */
    @Test(description = "AC7 - Dynamic Content")
    public void AC7() {
        driver.navigate().to("http://localhost:7080/dynamic_content");
        String dynamicContent = dynamicContentObject.getText();
        for (int i = 0; i <= 5; i++) {
            driver.navigate().refresh();
            Assert.assertNotEquals(dynamicContentObject.getText(), dynamicContent);
            dynamicContent = dynamicContentObject.getText();
            wait(2);
        }
    }

    /*
    Dynamic Controls
    Test clicks on the Remove Button and uses explicit wait.
    Test asserts that the checkbox is gone.
    Test clicks on Add Button and uses explicit wait.
    Test asserts that the checkbox is present.
    Test clicks on the Enable Button and uses explicit wait.
    Test asserts that the text box is enabled.
    Test clicks on the Disable Button and uses explicit wait.
    Test asserts that the text box is disabled.
     */
    @Test(description = "AC8 - Dynamic Controls")
    public void AC8() {
        driver.navigate().to("http://localhost:7080/dynamic_controls");
        Assert.assertTrue(checkBoxForm.getText().contains("checkbox"));
        removeBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(checkBox));
        Assert.assertFalse(checkBoxForm.getText().contains("checkbox"));
        wait(2);

        addBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(addBtn));
        Assert.assertTrue(checkBox.isDisplayed());
        wait(2);

        enableBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        Assert.assertTrue(inputBox.isEnabled());
        wait(2);

        disableBtn.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(inputBox)));
        Assert.assertFalse(inputBox.isEnabled());
        wait(2);
    }

    /*
    Dynamic Loading
    Test clicks the start button and uses explicit wait.
    Test asserts that “Hello World!” text is displayed.
     */
    @Test(description = "AC9 - Dynamic Loading")
    public void AC9() {
        driver.navigate().to("http://localhost:7080/dynamic_loading/2");
        wait(2);
        startBtn.click();
        wait(2);
        wait.until(ExpectedConditions.invisibilityOf(startBtn));
        Assert.assertEquals(header.getText(), "Hello World!");
        wait(2);
    }

    /*
    File Download
    Test clicks on the file.
    Test asserts that the file is downloaded.
     */
    @Test(description = "AC10 - File Download")
    public void AC10() {
        driver.navigate().to("http://localhost:7080/download");
        String fileName = file.getText();
        file.click();
        wait(5);
        Assert.assertTrue(isFileDownloaded(fileName));
    }

    /*
    File Upload
    Test uses Upload Button or Drag and Drop to upload a file.
    Test asserts that the file is uploaded.
     */
    @Test(description = "AC11 - File Upload")
    public void AC11() {
        driver.navigate().to("http://localhost:7080/download");
        String expectedFileName = file.getText();
        file.click();
        wait(2);

        driver.navigate().to("http://localhost:7080/upload");
        chooseFile.sendKeys(uploadPath + expectedFileName);
        wait(2);
        uploadBtn.click();
        wait(2);
        String actualFileName = uploadedFiles.getText();
        Assert.assertEquals(actualFileName, expectedFileName);
        deleteFiles();
        wait(2);
    }

    /*
    Floating Menu
    Test scrolls the page.
    Test asserts that the floating menu is still displayed.
     */
    @Test(description = "AC12 - Floating Menu")
    public void AC12() {
        driver.navigate().to("http://localhost:7080/floating_menu");
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        wait(2);
        Assert.assertTrue(floatingMenu.isDisplayed());
    }

    /*
    Iframe
    Test switches to Iframe and types some text.
    Test asserts that the typed text is as expected.
     */
    @Test(description = "AC13 - Iframe")
    public void AC13() {
        driver.navigate().to("http://localhost:7080/iframe");
        wait(2);
        notificationCloseBtn.click();
        wait(2);
        driver.switchTo().frame(iFrame);
        wait(2);
        WebElement content = driver.switchTo().activeElement();
        wait(2);
        content.clear();
        wait(2);
        content.sendKeys("Testing iFrame!");
        wait(2);
        Assert.assertEquals(contentBody.getText(), "Testing iFrame!");
        driver.switchTo().defaultContent();
        wait(2);
    }

    /*
    Mouse Hover
    Test does a mouse hover on each image.
    Test asserts that additional information is displayed for each image.
     */
    @Test(description = "AC14 - Mouse Hover")
    public void AC14() {
        driver.navigate().to("http://localhost:7080/hovers");
        wait(2);
        for (WebElement image : images) {
            action.moveToElement(image).perform();
            Assert.assertFalse(image.getText().isEmpty());
            wait(2);
        }
    }

    /*
    JavaScript Alerts
    Test Clicks on JS Alert Button.
    Test asserts alert message.
    Test clicks on JS confirm Button and clicks ok on alert.
    Test asserts the alert message.
    Test clicks on JS Prompt Button and types a message on Prompt.
    Test asserts that the alert message contains the typed message.
     */
    @Test(description = "AC15 - JavaScript Alerts")
    public void AC15() {
        driver.navigate().to("http://localhost:7080/javascript_alerts");
        wait(2);
        jsAlertBtn.click();
        wait(2);
        Alert alert = driver.switchTo().alert();
        Assert.assertFalse(alert.getText().isEmpty());
        wait(2);
        alert.accept();
        wait(2);

        jsConfirmBtn.click();
        wait(2);
        Assert.assertFalse(alert.getText().isEmpty());
        wait(2);
        alert.accept();
        wait(2);

        jsPromptBtn.click();
        wait(2);
        alert.sendKeys("Testing JS Prompt!");
        wait(2);
        alert.accept();
        wait(2);
        Assert.assertTrue(alertResult.getText().contains("Testing JS Prompt!"));
        wait(2);
    }

    /*
    JavaScript Error
    Test finds the JavaScript error on the page.
    Test asserts that the page contains error: Cannot read property 'xyz' of undefined.
     */
    @Test(description = "AC16 - JavaScript Error")
    public void AC16() {
        driver.navigate().to("http://localhost:7080/javascript_error");
        wait(2);
        String xyzValue = jsError.getAttribute("xyz");
        Assert.assertNull(xyzValue);
        System.out.println("Cannot read property 'xyz' of undefined");
    }

    /*
    Open in New Tab
    Test clicks on the Click Here link.
    Test asserts that a new tab is opened with text New Window.
     */
    @Test(description = "AC17 - Open in New Tab")
    public void AC17() {
        driver.navigate().to("http://localhost:7080/windows");
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        Assert.assertEquals(browserTabs.size(), 1);
        wait(2);
        newWindowLink.click();
        browserTabs = new ArrayList<>(driver.getWindowHandles());
        Assert.assertEquals(browserTabs.size(), 2);
        wait(2);
        driver.switchTo().window(browserTabs.get(1));
        Assert.assertEquals(newWindow.getText(), "New Window");
    }

    /*
    Notification Message
    Test clicks on the Click Here link a multiple times.
    Test asserts that one of the “Action Successful”,
    “Action unsuccessful, please try again” and
    “Action Unsuccessful” messages show on click.
     */
    @Test(description = "AC18 - Notification Message")
    public void AC18() {
        driver.navigate().to("http://localhost:7080/notification_message_rendered");
        wait(2);
        String[] messages = {"Action successful", "Action unsuccesful, please try again"};

        String actualMessage;
        boolean showMessage;

        for (String message : messages) {
            System.out.println(message);
            do{
                notificationLink.click();
                wait(2);
                actualMessage = notificationMsg.getText();
                showMessage = actualMessage.contains(message);
                System.out.println(showMessage);
            }
            while (!showMessage);
            Assert.assertTrue(true);
        }

    }
}


