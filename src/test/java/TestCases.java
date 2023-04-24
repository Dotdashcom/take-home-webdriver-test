import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Instant;
import pages.*;

public class TestCases {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //setting path of chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C://Users//Kjuri//Documents//Chromedriver//chromedriver.exe");

        //to launch the chrome browser window
        driver = new ChromeDriver();

        //maximize the browser window
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    // Testcase 1
    // Test is able to login successfully.
    public void loginSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        SecurePage securePage = new SecurePage(driver);

        // Open Login page
        driver.get(loginPage.getUrl());

        // Login with username "tomsmith" and password "SuperSecretPassword!"
        loginPage.login("tomsmith", "SuperSecretPassword!");

        // Verify that the login was successful based on the page URL
        Assert.assertEquals(driver.getCurrentUrl(), securePage.getUrl(),
                "Login not successful, secure page was not loaded");

        // THIS IS IF WE WANT TO USE A WAIT INSTEAD OF JUST ASSERT TO ACCOUNT FOR LOAD TIME
        // Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        //         .withTimeout(Duration.ofSeconds(10))
        //         .pollingEvery(Duration.ofSeconds(2));
        //
        // wait.until(ExpectedConditions.urlMatches(internetSecurePage.getUrl()));
    }

    @Test
    // Testcase 2
    // Test is not able to login with wrong credentials.
    public void loginFailure() {
        LoginPage loginPage = new LoginPage(driver);
        // Open Login page
        driver.get(loginPage.getUrl());

        // Test wrong username
        loginPage.login("fakeUsername", "fakePassword");

        // check if there's a username error
        Assert.assertTrue(loginPage.hasUsernameError(),
                "Does not show username error on incorrect username");

        // Test wrong username
        loginPage.login("tomsmith", "fakePassword");

        // check if there's a password error
        Assert.assertTrue(loginPage.hasPasswordError(),
                "Does not show password error on incorrect password");
    }

    @Test
    // Testcase 3
    // Test checks and unchecks checkboxes
    public void checkboxVerify() {
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        // Open checkbox page
        driver.get(checkboxPage.getUrl());

        // Save current select values
        boolean checkbox1IsChecked = checkboxPage.checkbox1IsChecked();
        boolean checkbox2IsChecked = checkboxPage.checkbox2IsChecked();

        // Select both checkboxes
        checkboxPage.clickCheckbox1();
        checkboxPage.clickCheckbox2();

        // Verify values are no longer the same as before
        Assert.assertNotEquals(checkbox1IsChecked, checkboxPage.checkbox1IsChecked(),
                "Checkbox 1 did not change select status when clicked.");

        Assert.assertNotEquals(checkbox2IsChecked, checkboxPage.checkbox2IsChecked(),
                "Checkbox 2 did not change select status when clicked.");

        // Select both checkboxes
        checkboxPage.clickCheckbox1();
        checkboxPage.clickCheckbox2();

        // Verify values are changed back
        Assert.assertEquals(checkbox1IsChecked, checkboxPage.checkbox1IsChecked(),
                "Checkbox 1 did not change select status when clicked.");

        Assert.assertEquals(checkbox2IsChecked, checkboxPage.checkbox2IsChecked(),
                "Checkbox 2 did not change select status when clicked.");
    }

    @Test
    // Testcase 4
    // Test right clicks on the context menu.
    public void contextBoxVerify() {
        ContextPage contextPage = new ContextPage(driver);
        // Open Context page
        driver.get(contextPage.getUrl());

        // Right click context box
        contextPage.rightClickContextBox();

        // Check if an alert was created
        try {
            contextPage.accessAlert();
        } catch (NoAlertPresentException e) {
            Assert.fail("No alert was created on right click");
        }

        String alertText = contextPage.getAlertText();

        // Closing alert first in case of failure, to prevent future test cases
        // from breaking because of unexpected alert open
        contextPage.closeAlert();

        // Verify text is as expected
        Assert.assertEquals(alertText, "You selected a context menu",
                "Text in the alert does not equal \"You selected a context menu\"");
    }

    @Test
    // Testcase 5
    // Test drags element A to element B.
    public void dragDropVerify() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        // Open drag and drop page
        driver.get(dragAndDropPage.getUrl());

        String elementAText = dragAndDropPage.getAText();
        String elementBText = dragAndDropPage.getBText();

        // Drag and drop element A to element B
        dragAndDropPage.dragAtoB();

        // Assert that the text of the elements have been swapped after drag/drop
        Assert.assertEquals(dragAndDropPage.getAText(), elementBText,
                "Text of the first element did not change after drag/drop.");
        Assert.assertEquals(dragAndDropPage.getBText(), elementAText,
                "Text of the second element did not change after drag/drop.");
    }

    @Test
    // Testcase 6
    // Test selects Option 1 and Option 2 from the drop down menu.
    public void dropdownVerify() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        // Open dropdown page
        driver.get(dropdownPage.getUrl());

        dropdownPage.clickDropdown();
        dropdownPage.clickOption("Option 1");

        Assert.assertEquals(dropdownPage.getSelectedOption().getText(), "Option 1");

        dropdownPage.clickDropdown();
        dropdownPage.clickOption("Option 2");

        Assert.assertEquals(dropdownPage.getSelectedOption().getText(), "Option 2");
    }

    @Test
    // Testcase 7
    // Test refreshes the page a couple of times.
    // Test asserts that the content changes on each refresh.
    // ASSUMPTION: Icons occasionally stay the same after refresh is intended behavior
    //             due to a limited pool of icons that are being randomly chosen
    public void dynamicContentVerify() {
        DynamicPage dynamicPage = new DynamicPage(driver);
        // Open dynamic content page
        driver.get(dynamicPage.getUrl());

        String[] imgSrcStrs = new String[3];
        String[] textDescStrs = new String[3];

        // get the initial values
        for (int i = 0; i < 3; i++) {
            imgSrcStrs[i] = dynamicPage.getRowImgSrc(i+1);
            textDescStrs[i] = dynamicPage.getRowText(i+1);
        }

        // refresh 5 times to reduce chance of false fail assertations
        for (int i = 0; i < 5; i++) {
            dynamicPage.refreshPage();
            // Compare image and text to see if there's a change
            for (int j = 0; j < 3; j++) {
                if (!imgSrcStrs[j].equals(dynamicPage.getRowImgSrc(j+1))) {
                    imgSrcStrs[j] = "";
                }
                if (!textDescStrs[j].equals(dynamicPage.getRowText(j+1))) {
                    textDescStrs[j] = "";
                }
            }
        }

        // Verify that all images have changed at least once
        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(imgSrcStrs[i], "",
                    "The image in row " + i + " did not change after " +
                            "5 page refreshes. Verify if there is an issue.");
        }

        // Verify that all text has changed at least once
        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(textDescStrs[i], "",
                    "The text in row " + i + " did not change after " +
                            "5 page refreshes. Verify if there is an issue.");
        }
    }

    @Test
    // Testcase 8.1
    // Test Add/Remove Button, Enable/Disable Button
    // NOTE: I broke up the 8th test into two separate test cases because it seemed more appropriate
    public void dynamicControlsCheckboxVerify() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        // Open dynamic controls page
        driver.get(dynamicControlsPage.getUrl());

        // Verify checkbox exists
        Assert.assertTrue(dynamicControlsPage.checkboxExists(),
                "Checkbox does not exist in initial page load.");

        // Click button to remove checkbox
        dynamicControlsPage.clickRemoveButton();

        // Wait for checkbox to be removed
        dynamicControlsPage.waitForCheckboxRemoval(30);

        // Verify checkbox is removed
        Assert.assertFalse(dynamicControlsPage.checkboxExists(),
                "Checkbox was not removed when remove button was clicked.");

        // Click button to add checkbox
        dynamicControlsPage.clickAddButton();

        // Wait for checkbox to be added
        dynamicControlsPage.waitForCheckboxAdd(30);

        // Verify checkbox is added
        Assert.assertTrue(dynamicControlsPage.checkboxExists(),
                "Checkbox was not added when add button was clicked.");
    }

    @Test
    // Testcase 8.2
    // Test Enable/Disable Button
    // NOTE: I broke up the 8th test into two separate test cases because it seemed more appropriate
    public void dynamicControlsTextboxVerify() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        // Open dynamic controls page
        driver.get(dynamicControlsPage.getUrl());

        // Verify textbox is by default enabled
        Assert.assertFalse(dynamicControlsPage.isTextboxEnabled(),
                "Unexpected situation where textbox is enabled at initialization.");

        // Click button to enable textbox
        dynamicControlsPage.clickEnableButton();

        // Wait for textbox to be enabled
        dynamicControlsPage.waitForEnable(30);

        // Verify textbox is enabled
        Assert.assertTrue(dynamicControlsPage.textboxEnabled(),
                "Textbox was not enabled when enable button was clicked.");

        // Click button to disable textbox
        dynamicControlsPage.clickDisableButton();

        // Wait for textbox to be disabled
        dynamicControlsPage.waitForDisable(30);

        // Verify textbox is disabled
        Assert.assertFalse(dynamicControlsPage.textboxEnabled(),
                "Textbox was not disabled when disabled button was clicked.");
    }

    @Test
    // Testcase 9
    // Test clicks the start button and uses explicit wait, asserts that “Hello World!” text is displayed.
    public void dynamicLoadingVerify() {
        DynamicLoadingPage dynamicLoadingPage =  new DynamicLoadingPage(driver);
        // Open dynamic loading page
        driver.get(dynamicLoadingPage.getUrl());

        // Click start button
        dynamicLoadingPage.clickStartButton();

        // Wait for load
        dynamicLoadingPage.waitForLoad(30);

        // Verify "Hello World!" is displayed
        Assert.assertEquals(dynamicLoadingPage.getLoadedText(), "Hello World!",
                "Hello World message was not loaded after clicking Start button.");
    }

    @Test
    // Testcase 10
    // Test clicks on the file,  asserts that the file is downloaded.
    public void fileDownloadVerify() {
        FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);
        // Open file download page
        driver.get(fileDownloadPage.getUrl());

        long downloadStartTime = Instant.now().toEpochMilli();
        fileDownloadPage.clickFileDownloadLink();

        // Wait at least 10 seconds to see if downloads
        Assert.assertTrue(fileDownloadPage.waitForDownload(10, 1, downloadStartTime),
                "Document was not downloaded within 10 seconds.");

        // Delete downloaded file
        fileDownloadPage.deleteDownloadedFile();
    }

    @Test
    // Testcase 11.1
    // Test uses Upload Button to upload a file.
    // NOTE: I broke up the 10th test into two separate test cases because it seemed more appropriate
    public void fileUploadVerify() {
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        // Open file upload page
        driver.get(fileUploadPage.getUrl());

        fileUploadPage.addFileToInput();
        fileUploadPage.clickSubmitButton();

        Assert.assertTrue(fileUploadPage.verifyUpload(),
                "Standard input file upload is not working.");
    }

    @Test
    // Testcase 11.2
    // Test uses drag and drop to upload a file.
    // NOTE: I broke up the 10th test into two separate test cases because it seemed more appropriate
    // NOTE: Doesn't use a drag and drop motion to upload file. Might need to revisit.
    public void fileDragDropVerify() {
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        // Open file upload page
        driver.get(fileUploadPage.getUrl());

        fileUploadPage.addFileToDragDrop();

        Assert.assertTrue(fileUploadPage.verifyDragDropUpload(),
                "Drag and Drop upload is not working.");
    }

    @Test
    // Testcase 12
    // Test scrolls the page, asserts that the floating menu is still displayed
    // NOTE: I just realized I might have been able to mess with the div[@id='menu'] style
    //       attribute to check if the height is same height as the viewport, but technically
    //       the JS in the visibility check is more flexible so it should be okay.
    public void floatingMenuVerify() {
        FloatingPage floatingPage = new FloatingPage(driver);
        // Open floating page
        driver.get(floatingPage.getUrl());

        floatingPage.scrollDown();

        Assert.assertTrue(floatingPage.floatingMenuVisibleCheck(),
                "Floating menus are not still displayed in view.");
    }

    @Test
    // Textcase 13
    // Test switches to Iframe and types some text, asserts that the typed text is as expected.
    public void iframeVerify() {
        IframePage iframePage = new IframePage(driver);
        // Open iframe page
        driver.get(iframePage.getUrl());

        iframePage.waitForIframeLoad(10);

        iframePage.clearIframeText();
        iframePage.enterTextToIframe("Hello world");

        Assert.assertEquals(iframePage.getIframeText(), "Hello world",
                "Text unable to be entered into rich text editor.");
    }

    @Test
    // Testcase 14
    // Test does a mouse hover on each image asserts that additional information is displayed for each image.
    public void hoverVerify() {
        HoversPage hoversPage = new HoversPage(driver);
        // Open hovers page
        driver.get(hoversPage.getUrl());

        int imagesCount = hoversPage.numImages();

        for (int i = 0; i < imagesCount; i++) {
            Assert.assertFalse(hoversPage.infoVisible(i));
            hoversPage.hoverOverImage(i);
            Assert.assertTrue(hoversPage.infoVisible(i));
        }
    }

    @Test
    // Testcase 15.1
    // Test Clicks on JS Alert Button, asserts alert message.
    // NOTE: I broke up the 15th test into 3 separate test cases because it seemed more appropriate
    public void jsAlertButtonVerify() {
        JSAlertsPage jsAlertsPage = new JSAlertsPage(driver);
        // Open JS Alert page
        driver.get(jsAlertsPage.getUrl());

        // Test if alert is created and is accepted
        jsAlertsPage.clickJSAlertButton();
        jsAlertsPage.waitForJSAlert(10);
        jsAlertsPage.acceptJSAlert();
        Assert.assertTrue(jsAlertsPage.jsAlertSuccessResult());
    }

    @Test
    // Testcase 15.2
    // Test clicks on JS confirm Button and clicks ok on alert, asserts the alert message.
    // NOTE: I broke up the 15th test into 3 separate test cases because it seemed more appropriate
    public void jsConfirmButtonVerify() {
        JSAlertsPage jsAlertsPage = new JSAlertsPage(driver);
        // Open JS Alert page
        driver.get(jsAlertsPage.getUrl());

        // Test if confirm alert is created and is accepted
        jsAlertsPage.clickJSConfirmButton();
        jsAlertsPage.waitForJSAlert(10);
        jsAlertsPage.acceptJSAlert();
        Assert.assertTrue(jsAlertsPage.jsConfirmOKResult());

        // Test if confirm alert is created and is dismissed
        jsAlertsPage.clickJSConfirmButton();
        jsAlertsPage.waitForJSAlert(10);
        jsAlertsPage.dismissJSAlert();
        Assert.assertTrue(jsAlertsPage.jsConfirmCancelResult());
    }

    @Test
    // Testcase 15.3
    // Test Clicks on JS Prompt Button and types a message on Prompt,
    //      asserts that the alert message contains the typed message.
    // NOTE: I broke up the 15th test into 3 separate test cases because it seemed more appropriate
    public void jsPromptButtonVerify() {
        JSAlertsPage jsAlertsPage = new JSAlertsPage(driver);
        // Open JS Alert page
        driver.get(jsAlertsPage.getUrl());

        // Check prompt if no text is inputted and alert is accepted
        jsAlertsPage.clickJSPromptButton();
        jsAlertsPage.waitForJSAlert(10);
        jsAlertsPage.acceptJSAlert();
        Assert.assertTrue(jsAlertsPage.jsPromptSuccessResult(""));

        // Check prompt if text is inputted and alert is accepted
        jsAlertsPage.clickJSPromptButton();
        jsAlertsPage.waitForJSAlert(10);
        jsAlertsPage.enterPromptText("Test prompt input");
        jsAlertsPage.acceptJSAlert();
        Assert.assertTrue(jsAlertsPage.jsPromptSuccessResult("Test prompt input"));

        // Check prompt if text is not inputted and alert is dismissed
        jsAlertsPage.clickJSPromptButton();
        jsAlertsPage.waitForJSAlert(10);
        jsAlertsPage.dismissJSAlert();
        Assert.assertTrue(jsAlertsPage.jsPromptSuccessResult("null"));

        // Check prompt if text is inputted and alert is dismissed
        jsAlertsPage.clickJSPromptButton();
        jsAlertsPage.waitForJSAlert(10);
        jsAlertsPage.enterPromptText("Test prompt input");
        jsAlertsPage.dismissJSAlert();
        Assert.assertTrue(jsAlertsPage.jsPromptSuccessResult("null"));
    }

    @Test
    // Testcase 16
    // Test finds the JavaScript error on the page,
    //      asserts that the page contains error: Cannot read property 'xyz' of undefined.
    public void jsErrorVerify() {
        JSErrorPage jsErrorPage = new JSErrorPage(driver);
        driver.get(jsErrorPage.getUrl());

        jsErrorPage.saveErrorLog();
        Assert.assertTrue(jsErrorPage.logContainsError("Cannot read properties of undefined (reading 'xyz')"),
                "Unable to find error for \"Cannot read properties of undefined (reading 'xyz')\".");
    }

    @Test
    // Testcase 17
    // Test clicks on the Click Here link, asserts that a new tab is opened with text New Window.
    public void newWindowVerify() {
        WindowsPage windowsPage = new WindowsPage(driver);
        // Opens new window page
        driver.get(windowsPage.getUrl());

        // Get initial number of tabs open
        int numOfTabs = windowsPage.numOfTabs();

        windowsPage.clickNewWindowLink();

        // Verify that one new tab has opened up
        Assert.assertEquals(windowsPage.numOfTabs(), numOfTabs + 1,
                "A new tab was not opened.");

        numOfTabs = windowsPage.numOfTabs();

        // Make sure newly opened tab is active
        windowsPage.switchTabs(numOfTabs - 1);

        // Verify that the correct tab opened
        Assert.assertEquals(driver.getCurrentUrl(), windowsPage.getLinkUrl());
    }

    @Test
    // Testcase 18
    // Test clicks on the Click Here link a multiple times,
    //      asserts that one of the “Action Successful”, “Action unsuccessful, please try again”
    //      and “Action Unsuccessful” messages show on click.
    public void notificationMsgVerify() {
        NotificationMsgPage notificationMsgPage = new NotificationMsgPage(driver);
        // Open notification page
        driver.get(notificationMsgPage.getUrl());

        // Check message 10 times
        for (int i = 0; i < 10; i++) {
            notificationMsgPage.clickMessageLink();
            Assert.assertTrue(notificationMsgPage.validNotifMessage(notificationMsgPage.getNotifMsg()),
                    "Message was invalid: \"" + notificationMsgPage.getNotifMsg() + "\"");
        }
    }
}