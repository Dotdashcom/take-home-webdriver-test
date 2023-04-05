import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import myapp.ui.model.*;
import myapp.ui.test.UiTests;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends UiTests {
    
     @Test
    void testSuccessfulLogin() throws Exception {
        // Initialize test data
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        String expectedTitle = "Homepage";
        String expectedMessage = "You logged into a secure area!";
        String expectedPageTitle = "Secure Area";
        
        // Navigate to the login page
        LoginPage loginPage = LoginPage.navigateToLoginPage(driver, baseUrl);
        
        // Verify that the login page title matches the expected title
        assertEquals("Login Page", loginPage.getPageTitle(), "Invalid page title: login page");

        // Enter login credentials and click the login button
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        // Verify that the success message is displayed
        SecurePage securePage = new SecurePage(driver);
        assertTrue(securePage.getFlashMessage().contains(expectedMessage), "Invalid success message");

        // Verify that the secure page title matches the expected title
        assertEquals(expectedPageTitle, securePage.getTitle(), "Invalid page title: secure page");
    }

     @Test
    void testUnsuccessfulLogin() throws Exception {
        // Set test data for unsuccessful login
        String incorrectUsername = "incorrect_user";
        String incorrectPassword = "wrong_password";
        String expectedErrorMessage = "Your username or password is incorrect";
        String expectedPageTitle = "Login Page";
        
        // Navigate to the login page
        LoginPage loginPage = LoginPage.navigateToLoginPage(driver, baseUrl);
        
        // Enter incorrect login credentials and click the login button
        loginPage.enterUsername(incorrectUsername);
        loginPage.enterPassword(incorrectPassword);
        loginPage.clickLogin();

        // Verify that the error message is displayed
        assertTrue(loginPage.doesErrorMessageExist(), "Error message not displayed");
        assertTrue(loginPage.getErrorMessage().contains(expectedErrorMessage), "Invalid error message");

        // Verify that the login page title matches the expected title
        assertEquals(expectedPageTitle, loginPage.getPageTitle(), "Page title does not match");
    }

     @Test
    void testCheckboxFunctionality() throws Exception {
        // Set test data for checkboxes
        int checkBox1Index = 1;
        int checkBox2Index = 2;
        String expectedPageTitle = "Checkboxes";

        // Navigate to the checkboxes page
        CheckboxesPage checkboxesPage = CheckboxesPage.navigateToCheckBoxPage(driver, baseUrl);
        
        // Verify the page title
        assertEquals(expectedPageTitle, checkboxesPage.getPageTitle(), "Page title does not match");
        
        // Select both checkboxes and verify
        checkboxesPage.selectCheckbox(checkBox1Index);
        checkboxesPage.selectCheckbox(checkBox2Index);
        assertTrue(checkboxesPage.isCheckboxSelected(checkBox1Index), "Checkbox 1 is not selected");
        assertTrue(checkboxesPage.isCheckboxSelected(checkBox2Index), "Checkbox 2 is not selected");

        // Deselect both checkboxes and verify
        checkboxesPage.deSelectCheckbox(checkBox1Index);
        checkboxesPage.deSelectCheckbox(checkBox2Index);
        assertFalse(checkboxesPage.isCheckboxSelected(checkBox1Index), "Checkbox 1 is selected");
        assertFalse(checkboxesPage.isCheckboxSelected(checkBox2Index), "Checkbox 2 is selected");
    }

     @Test
    void testContextMenu() throws Exception {
        String expectedMessage = "You have selected a context menu";
        String expectedPageTitle = "Context Menu";

        ContextMenuPage contextMenuPage = ContextMenuPage.navigateToContextMenuPage(driver, baseUrl);
        // Assert page title
        assertEquals(expectedPageTitle, contextMenuPage.getPageTitle(), "Check page title is correct");
        // right click box and assert message
        String alertMessage = contextMenuPage.rightClickBoxAndGetAlertText();
        assertEquals(expectedMessage, alertMessage, "Check Javascript alert text is correct");
        contextMenuPage.acceptAlert();
    }

     @Test
    void dragAndDropTest() throws Exception {
        final String letterA = "A";
        final String letterB = "B";
        String expectedPageTitle = "Drag and Drop";

        // Navigate to Drag and Drop page and assert page title
        DragAndDropPage dragAndDropPage = DragAndDropPage.navigateToDragAndDropPage(driver, baseUrl);
        assertEquals(expectedPageTitle, dragAndDropPage.getTitle(), "Page title is correct");

        // Assert default box letters
        assertEquals(letterA, dragAndDropPage.getBoxALetter(), "Default box A letter is correct");
        assertEquals(letterB, dragAndDropPage.getBoxBLetter(), "Default box B letter is correct");

        // Drag box A to box B and assert new box letters
        dragAndDropPage.dragAndDropBoxAtoBoxB();
        assertEquals(letterB, dragAndDropPage.getBoxALetter(), "Box A letter is correct after drag and drop");
        assertEquals(letterA, dragAndDropPage.getBoxBLetter(), "Box B letter is correct after drag and drop");

        // Swap drag
        dragAndDropPage.dragAndDropBoxBtoBoxA();
        assertEquals(letterA, dragAndDropPage.getBoxALetter(), "Box A letter is correct after swap drag");
        assertEquals(letterB, dragAndDropPage.getBoxBLetter(), "Box B letter is correct after swap drag");
    }
     @Test
    void dropdownTest() throws Exception {
        String expectedPageTitle = "Dropdown List";
        int option1 = 1;
        int option2 = 2;

        DropdownPage dropdownPage = DropdownPage.navigateToDropdownPage(driver, baseUrl);

        // Check the page title
        String pageTitle = dropdownPage.getTitle();
        assertEquals(expectedPageTitle, pageTitle, "The page title should be correct");

        // Select option 1
        dropdownPage.clickDropdownField();
        dropdownPage.selectDropdownOption1();
        boolean isOption1Selected = dropdownPage.isDropdownOptionSelected(option1);
        assertTrue(isOption1Selected, "Option 1 should be selected");

        // Select option 2
        dropdownPage.clickDropdownField();
        dropdownPage.selectDropdownOption2();
        boolean isOption2Selected = dropdownPage.isDropdownOptionSelected(option2);
        assertTrue(isOption2Selected, "Option 2 should be selected");
    }

    @Test
    void dynamicContentTest() throws Exception {
        String expectedPageTitle = "Dynamic Content";
        int numberOfClicks = 5;
        DynamicContentPage dynamicContentPage = DynamicContentPage.navigateToDynamicContentPage(driver, baseUrl);
        // Confirm page title
        assertEquals(expectedPageTitle, dynamicContentPage.getTitle(), "Check page title is correct");
        // click link multiple times and check that content changes
        for (int i = 1; i < numberOfClicks; i++) {
            // Get contents before refresh
            String content1BeforeCLick = dynamicContentPage.getDynamicContent1();
            String content2BeforeCLick = dynamicContentPage.getDynamicContent2();
            String content3BeforeCLick = dynamicContentPage.getDynamicContent3();
            // Refresh page
            DynamicContentPage pageAfterRefresh = dynamicContentPage.refreshPage();
            // Assert contents changed after click
            assertNotEquals(content1BeforeCLick, pageAfterRefresh.getDynamicContent1(), "Check contents changed after click");
            assertNotEquals(content2BeforeCLick, pageAfterRefresh.getDynamicContent2(), "Check contents changed after click");
            assertNotEquals(content3BeforeCLick, pageAfterRefresh.getDynamicContent3(), "Check contents changed after click");
        }
    }

    @Test
    void dynamicControlsTest() throws Exception {
        String expectedPageTitle = "Dynamic Controls";

        DynamicControlsPage dynamicControlsPage = DynamicControlsPage.navigateToDynamicControlsPage(driver, baseUrl);
        // Assert page title
        assertEquals(expectedPageTitle, dynamicControlsPage.getPageTitle(), "Check page title is correct");
        // Click Remove and assert checkbox is removed
        assertFalse(dynamicControlsPage.clickRemoveButton().isCheckboxVisible(), "Check checkbox removed successfully");
        // Click Add and assert checkbox is added
        assertTrue(dynamicControlsPage.clickAddButton().isCheckboxVisible(), "Check checkbox added successfully");

        // Refresh page
        DynamicControlsPage dynamicControlsPage1 = dynamicControlsPage.refreshPage();

        // Click Enable and assert text box is enabled
        assertTrue(dynamicControlsPage1.clickEnableButton().isTextBoxEnabled(), "Check text box enabled successfully");
        // Click Disable and assert text box is disabled
        assertFalse(dynamicControlsPage1.clickDisableButton().isTextBoxEnabled(), "Check text box disabled successfully");
    }

    @Test
    void dynamicLoadingTest() throws Exception {
        // Define expected values
        String expectedMessage = "Welcome to the Jungle!";
        String expectedPageTitle = "Dynamic Loading";

        // Navigate to dynamic loading page and get page object
        DynamicLoadingPage dynamicLoadingPage = DynamicLoadingPage.navigateToDynamicLoadingPage(driver, baseUrl);

        // Confirm page title is correct
        assertEquals(expectedPageTitle, dynamicLoadingPage.getPageTitle(), "Verify page title is correct");

        // Click start button and verify loading message
        assertEquals(expectedMessage, dynamicLoadingPage.clickStartButton().getLoadingMessage(), "Verify loading message is correct");
    }

    @Test
    void fileDownloaderTest() throws Exception {
        // Define expected values
        String fileName = "sample-file.txt";
        String expectedPageTitle = "File Downloader";

        // Navigate to file downloader page and get page object
        FileDownloaderPage fileDownloaderPage = FileDownloaderPage.navigateToFileDownloaderPage(driver, baseUrl);

        // Confirm page title is correct
        assertEquals(expectedPageTitle, fileDownloaderPage.getPageTitle(), "Verify page title is correct");

        // Download file and verify file downloaded successfully
        assertTrue(fileDownloaderPage.downloadFile(fileName), "Verify file is downloaded successfully");
    }

    @Test
    void fileUploadTest() throws Exception {
        // Define expected values
        String fileName = "test-file.txt";
        String expectedTitleAfterUpload = "File Uploaded!";
        String expectedPageTitle = "File Uploader";
        String filePath = Paths.get(fileName).toAbsolutePath().toString();

        // Navigate to file upload page and get page object
        FileUploadPage fileUploadPage = FileUploadPage.navigateToFileUploadPage(driver, baseUrl);

        // Confirm page title is correct
        assertTrue(fileUploadPage.getPageTitle().contains(expectedPageTitle), "Verify page title is correct");

        // Upload file and verify file uploaded successfully
        fileUploadPage.uploadFile(filePath);
        assertEquals(expectedTitleAfterUpload, fileUploadPage.getUploadResultTitle(), "Verify upload result title is correct");
        assertEquals(fileName, fileUploadPage.getUploadedFileName(), "Verify uploaded file name is correct");
    }

    @Test
    void floatingMenuTest() throws Exception {
        // Define expected value
        String expectedPageTitle = "Floating Menu";

        // Navigate to floating menu page and get page object
        FloatingMenuPage floatingMenuPage = FloatingMenuPage.navigateToFloatingMenuPage(driver, baseUrl);

        // Confirm page title is correct
        assertEquals(expectedPageTitle, floatingMenuPage.getPageTitle(), "Verify page title is correct");

        // Get initial position of floating menu
        String initialPosition = floatingMenuPage.getMenuPosition();

        // Scroll down and verify menu position changes
        floatingMenuPage.scrollDown();
        assertNotEquals(initialPosition, floatingMenuPage.getMenuPosition(), "Verify floating menu position changes when scrolling down");
    }


    @Test
    void iframeTest() throws Exception {
        String expectedMessage = "Updated text in iframe!";
        String expectedPageTitle = "An iFrame containing the TinyMCE WYSIWYG Editor";
        IframePage iframePage = IframePage.navigateToIframePage(driver, baseUrl);
        // Assert page title
        assertTrue(iframePage.getPageTitle().contains(expectedPageTitle), "Check page title is correct");
        // Switch to iframe and Edit Iframe text
        iframePage.switchToIframe();
        iframePage.editIframeText(expectedMessage);
        assertEquals(expectedMessage, iframePage.getIframeText(), "Check Message is correct");
    }

    @Test
    void mouseHoverTest() throws Exception {
        int imageOneIndex = 1;
        int imageTwoIndex = 2;
        int imageThreeIndex = 3;
        String expectedPageTitle = "Hovers";

        MouseHoverPage mouseHoverPage = MouseHoverPage.navigateToMouseHoverPage(driver, baseUrl);
        // Assert page title
        assertEquals(expectedPageTitle, mouseHoverPage.getPageTitle(), "Check page title is correct");
        // Mouse over image and assert info is displayed
        mouseHoverPage.mouseOverImage1();
        assertTrue(mouseHoverPage.isInfoDisplayedForImage(imageOneIndex), "Check Info is displayed for image1 on mouse hover");
        mouseHoverPage.mouseOverImage2();
        assertTrue(mouseHoverPage.isInfoDisplayedForImage(imageTwoIndex), "Check Info is displayed for image2 on mouse hover");
        mouseHoverPage.mouseOverImage3();
        assertTrue(mouseHoverPage.isInfoDisplayedForImage(imageThreeIndex), "Check Info is displayed for image3 on mouse hover");
    }

    @Test
    void javaScriptAlertsTest() throws Exception {
        String text = "New message entered in JS Prompt!";
        String alertMessage = "I am an alert box!";
        String confirmMessage = "I am a confirmation box!";
        String promptMessage = "I am a prompt box!";
        String expectedPageTitle = "JavaScript Alerts";
        String expectedResult = String.format("You entered: %s", text);
        JavascriptAlertsPage javascriptAlertsPage = JavascriptAlertsPage.navigateToJavascriptAlertsPage(driver, baseUrl);
        // Assert page title
        assertEquals(expectedPageTitle, javascriptAlertsPage.getPageTitle(), "Check page title is correct");
        // click Js Alert button and assert message
        javascriptAlertsPage.clickJsAlert();
        assertEquals(alertMessage, javascriptAlertsPage.getAlertMessage(), "Check Message is correct");
        // click Js confirm button and assert message
        javascriptAlertsPage.clickJsConfirm();
        assertEquals(confirmMessage, javascriptAlertsPage.getAlertMessage(), "Check Message is correct");
        // click Js prompt button and assert default message
        javascriptAlertsPage.clickJsPrompt();
        javascriptAlertsPage.enterAlertText(text);
        assertEquals(promptMessage, javascriptAlertsPage.getAlertMessage(), "Check Message is correct");
        assertEquals(expectedResult, javascriptAlertsPage.getResultMessage(), "Check Message is correct");
    }

    @Test
    void javaScriptErrorTest() {
        String expectedMessage = "Cannot read properties of undefined (reading 'xyz')";
        JavascriptErrorPage javascriptErrorPage = JavascriptErrorPage.navigateToJavascriptErrorPage(driver, baseUrl);
        // Assert error message
        assertTrue(javascriptErrorPage.getErrorMessage().contains(expectedMessage), "Check Error message is correct");
    }

    @Test
    void windowsTest() throws Exception {
        String expectedPage1Title = "Opening a new window";
        String expectedPage2Title = "New Window";
        WindowsPage windowsPage = WindowsPage.navigateToWindowsPage(driver, baseUrl);

        // Assert page title
        assertEquals(expectedPage1Title, windowsPage.getPageTitle(), "Check page title is correct");

        // Click link to open new tab
        windowsPage.clickLink();

        // Switch to newly opened tab and assert page title
        windowsPage.switchTabs(driver, 2);
        assertEquals(expectedPage2Title, windowsPage.getPageTitle(), "Check page title is correct");

        // Close the new tab and switch back to the original tab
        windowsPage.closeCurrentTab(driver);
        windowsPage.switchTabs(driver, 1);
    }

    @Test
    void notificationMessageTest() throws Exception {
        String expectedPageTitle = "Notification Message";
        String expectedMessage1 = "Action successful";
        String expectedMessage2 = "Action unsuccesful, please try again";
        NotificationMessage notificationMessage = NotificationMessage.navigateToNotificationMessagePage(driver, baseUrl);

        // Assert page title
        assertEquals(expectedPageTitle, notificationMessage.getPageTitle(), "Check page title is correct");

        // Click the link repeatedly until expected message appears and assert message
        assertTrue(notificationMessage.clickLinkUntilExpectedMessage(expectedMessage1), "Check message is correct");
        assertTrue(notificationMessage.clickLinkUntilExpectedMessage(expectedMessage2), "Check message is correct");
    }

}

