package regression.ui.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import regression.ui.model.*;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class TestSolution extends UiTests {
    @Test
    void loginSuccessTest() throws Exception {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        String expectedLoginTitle = "Login Page";
        String expectedMessage = "You logged into a secure area!";
        String expectedSecurePageTitle = "Secure Area";

        LoginPage loginPage = LoginPage.navigateToLoginPage(driver, baseUrl);
        assertEquals(expectedLoginTitle, loginPage.getPageTitle(), "Check Login page title is correct");
        // Login to secure page with correct details
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        SecurePage securePage = new SecurePage(driver);
        assertTrue(securePage.getFlashMessage().contains(expectedMessage), "Check Flash message is correct");
        assertEquals(expectedSecurePageTitle, securePage.getTitle(), "Check Secure page title is correct");
    }

    @Test
    void loginFailureTest() throws Exception {
        String username = "wrongusername";
        String password = "WrongPassword!";
        String expectedMessage = "Your username is invalid!";
        String expectedPageTitle = "Login Page";

        LoginPage loginPage = LoginPage.navigateToLoginPage(driver, baseUrl);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        assertTrue(loginPage.doesErrorMessageExist(), "Check Error message exist");
        assertTrue(loginPage.getErrorMessage().contains(expectedMessage), "Check Error message is correct");
        // Assert that page is the same
        assertEquals(expectedPageTitle, loginPage.getPageTitle(), "Check webpage remains on login page");
    }

    @Test
    void checkboxesTest() throws Exception {
        int checkBox1 = 1;
        int checkBox2 = 2;
        String expectedPageTitle = "Checkboxes";

        CheckboxesPage checkboxesPage = CheckboxesPage.navigateToCheckBoxPage(driver, baseUrl);
        // assert page title
        assertEquals(expectedPageTitle, checkboxesPage.getPageTitle(), "Check Webpage is correct");
        // select both check box and assert
        checkboxesPage.selectCheckbox(checkBox1);
        checkboxesPage.selectCheckbox(checkBox2);
        // assert both boxes are checked
        assertTrue(checkboxesPage.isCheckboxSelected(checkBox1), "Check Checkbox 1 is selected");
        assertTrue(checkboxesPage.isCheckboxSelected(checkBox2), "Check Checkbox 2 is selected");

        // deselect both check box and assert
        checkboxesPage.deSelectCheckbox(checkBox1);
        checkboxesPage.deSelectCheckbox(checkBox2);
        // assert both boxes are not checked
        assertFalse(checkboxesPage.isCheckboxSelected(checkBox1), "Check Checkbox 1 is not selected");
        assertFalse(checkboxesPage.isCheckboxSelected(checkBox2), "Check Checkbox 2 is not selected");
    }

    @Test
    void contextMenuTest() throws Exception {
        String expectedMessage = "You selected a context menu";
        String expectedPageTitle = "Context Menu";

        ContextMenuPage contextMenuPage = ContextMenuPage.navigateToContextMenuPage(driver, baseUrl);
        // Assert page title
        assertEquals(expectedPageTitle, contextMenuPage.getTitle(), "Check page title is correct");
        // right click box and assert message
        Alert alert = contextMenuPage.rightClickBox();
        assertEquals(expectedMessage, alert.getText(), "Check Javascript alert text is correct");
        alert.dismiss();
    }

    @Test
    void dragAndDropTest() throws Exception {
        final String letterA = "A";
        final String letterB = "B";
        String expectedPageTitle = "Drag and Drop";

        DragAndDropPage dragAndDropPage = DragAndDropPage.navigateToDragAndDropPage(driver, baseUrl);
        // Assert page title
        assertEquals(expectedPageTitle, dragAndDropPage.getTitle(), "Check page title is correct");
        // Get box default letters
        assertEquals(letterA, dragAndDropPage.getBoxALetter(), "Check Default box A letter is correct");
        assertEquals(letterB, dragAndDropPage.getBoxBLetter(), "Check Default box B letter is correct");
        // Drag A to B and get box letters
        dragAndDropPage.dragAndDropBoxAtoBoxB();
        // Confirm drag and drop by checking new box letters
        assertEquals(letterB, dragAndDropPage.getBoxALetter(), "Check Default box A letter is correct");
        assertEquals(letterA, dragAndDropPage.getBoxBLetter(), "Check Default box B letter is correct");

        // Swap drag
        dragAndDropPage.dragAndDropBoxBtoBoxA();
        assertEquals(letterA, dragAndDropPage.getBoxALetter(), "Check Default box A letter is correct");
        assertEquals(letterB, dragAndDropPage.getBoxBLetter(), "Check Default box B letter is correct");
    }

    @Test
    void dropdownTest() throws Exception {
        String expectedPageTitle = "Dropdown List";
        int option1 = 1;
        int option2 = 2;

        DropdownPage dropdownPage = DropdownPage.navigateToDropdownPage(driver, baseUrl);
        // Assert page title
        assertEquals(expectedPageTitle, dropdownPage.getTitle(), "Check page title is correct");
        // select option 1
        dropdownPage.clickDropdownField();
        dropdownPage.selectDropdownOption1();
        assertTrue(dropdownPage.isDropdownOptionSelected(option1), "Check Option 1 is selected");
        // select option 2
        dropdownPage.clickDropdownField();
        dropdownPage.selectDropdownOption2();
        assertTrue(dropdownPage.isDropdownOptionSelected(option2), "Check Option 2 is selected");
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
            assertNotEquals(content1BeforeCLick, pageAfterRefresh.getDynamicContent1(), "Check Contents changed after click");
            assertNotEquals(content2BeforeCLick, pageAfterRefresh.getDynamicContent2(), "Check Contents changed after click");
            assertNotEquals(content3BeforeCLick, pageAfterRefresh.getDynamicContent3(), "Check Contents changed after click");
        }
    }

    @Test
    void dynamicControlsTest() throws Exception {
        String expectedPageTitle = "Dynamic Controls";

        DynamicControlsPage dynamicControlsPage = DynamicControlsPage.navigateToDynamicControlsPage(driver, baseUrl);
        // Assert page title
        assertEquals(expectedPageTitle, dynamicControlsPage.getPageTitle(), "Check page title is correct");
        // Click Remove and assert checkbox is removed
        assertFalse(dynamicControlsPage.clickRemoveButton().isCheckboxVisible(), "Check Checkbox removed successfully");
        // Click Add and assert checkbox is added
        assertTrue(dynamicControlsPage.clickAddButton().isCheckboxVisible(), "Check Checkbox added successfully");

        // Refresh page
        DynamicControlsPage dynamicControlsPage1 = dynamicControlsPage.refreshPage();

        // Click Enable and assert text box is enabled
        assertTrue(dynamicControlsPage1.clickEnableButton().isTextBoxEnabled(), "Check Text box enabled successfully");
        // Click Disable and assert text box is disabled
        assertFalse(dynamicControlsPage1.clickDisableButton().isTextBoxEnabled(), "Check Text box disabled successfully");
    }

    @Test
    void dynamicLoadingTest() throws Exception {
        String expectedMessage = "Hello World!";
        String expectedPageTitle = "Dynamically Loaded Page Elements";
        DynamicLoadingPage dynamicLoadingPage = DynamicLoadingPage.navigateToDynamicLoadingPage(driver, baseUrl);
        // Assert page title
        assertEquals(expectedPageTitle, dynamicLoadingPage.getPageTitle(), "Check page title is correct");
        // click start button and assert message
        assertEquals(expectedMessage, dynamicLoadingPage.clickStart().getMessageAfterLoading(), "Check Message is correct");
    }

    @Test
    void fileDownloaderTest() throws Exception {
        String fileName = "some-file.txt";
        String expectedPageTitle = "File Downloader";
        FileDownloaderPage fileDownloaderPage = FileDownloaderPage.navigateToFileDownloaderPage(driver, baseUrl);
        // Assert page title
        assertEquals(expectedPageTitle, fileDownloaderPage.getPageTitle(), "Check page title is correct");
        // download file
        fileDownloaderPage.clickFile();
        // Assert file downloaded
        assertTrue(fileDownloaderPage.isFileDownloaded(downloadFilePath, fileName));
    }

    @Test
    void fileUploadTest() throws Exception {
        String fileName = "Code Challenge.txt";
        String expectedTitleAfterUpload = "File Uploaded!";
        String expectedPageTitle = "File Uploader";
        String filePath = Paths.get(fileName).toAbsolutePath().toString();

        FileUploadPage fileUploadPage = FileUploadPage.navigateToFileUploadPage(driver, baseUrl);
        // Assert page title
        assertTrue(fileUploadPage.getPageTitle().contains(expectedPageTitle), "Check page title is correct");
        // upload file
        fileUploadPage.addFilePathForUpload(filePath);
        // Assert file uploaded and name of uploaded file
        assertEquals(expectedTitleAfterUpload, fileUploadPage.getPageTitle(), "Check Title is correct");
        assertEquals(fileName, fileUploadPage.getUploadedFileName(), "Check File name is correct");
    }

    @Test
    void floatingMenuTest() throws Exception {
        String expectedPageTitle = "Floating Menu";
        FloatingMenuPage floatingMenuPage = FloatingMenuPage.navigateToFloatingMenuPage(driver, baseUrl);
        // Assert page title
        assertEquals(expectedPageTitle, floatingMenuPage.getPageTitle(), "Check page title is correct");
        // Get floating menu default position
        String startPosition = floatingMenuPage.getMenuPosition();
        // Scroll to end of page and assert that menu position also changed with the page scroll.
        floatingMenuPage.scrollToEndOfPage();
        assertNotEquals(startPosition, floatingMenuPage.getMenuPosition(), "Check Menu position changed with scroll");
    }

    @Test
    void iframeTest() throws Exception {
        String expectedMessage = "Hello World!";
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
        int image1 = 1;
        int image2 = 2;
        int image3 = 3;
        String expectedPageTitle = "Hovers";

        MouseHoverPage mouseHoverPage = MouseHoverPage.navigateToMouseHoverPage(driver, baseUrl);
        // Assert page title
        assertEquals(expectedPageTitle, mouseHoverPage.getPageTitle(), "Check page title is correct");
        // Mouse over image and assert info is displayed
        mouseHoverPage.mouseOverImage1();
        assertTrue(mouseHoverPage.isInfoDisplayedForImage(image1), "Check Info is displayed for image1 on mouse hover");
        mouseHoverPage.mouseOverImage2();
        assertTrue(mouseHoverPage.isInfoDisplayedForImage(image2), "Check Info is displayed for image2 on mouse hover");
        mouseHoverPage.mouseOverImage3();
        assertTrue(mouseHoverPage.isInfoDisplayedForImage(image3), "Check Info is displayed for image3 on mouse hover");
    }

    @Test
    void javaScriptAlertsTest() throws Exception {
        String text = "Hello World!";
        String alertMessage = "I am a JS Alert";
        String confirmMessage = "I am a JS Confirm";
        String promptMessage = "I am a JS prompt";
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
        String expectedMessage = "Cannot read property 'xyz' of undefined";
        JavascriptErrorPage javascriptErrorPage = JavascriptErrorPage.navigateToJavascriptErrorPage(driver, baseUrl);
        // Assert error message
        assertTrue(javascriptErrorPage.getErrorMessage().contains(expectedMessage), "Check Error message is correct");
    }

    @Test
    void windowsTest() throws Exception {
        String expectedPage1Title = "Opening a new window";
        String expectedPage2Title = "New Window";
        WindowsPage windowsPage = WindowsPage.navigateToWindowsPage(driver, baseUrl);
        // Assert error message
        assertEquals(expectedPage1Title, windowsPage.getPageTitle(), "Check page title is correct");
        // click link
        windowsPage.clickLink();
        // Switch to tab and get page title
        windowsPage.switchTabs(driver, 2);
        assertEquals(expectedPage2Title, windowsPage.getPageTitle(),"Check page title is correct");
        //close second tab
        windowsPage.closeCurrentTab(driver);
    }

    @Test
    void NotificationMessageTest() throws Exception {
        String expectedPageTitle = "Notification Message";
        String expectedMessage1 = "Action successful";
        String expectedMessage2 = "Action unsuccesful, please try again";
        NotificationMessage notificationMessage = NotificationMessage.navigateToNotificationMessagePage(driver, baseUrl);
        // Assert error message
        assertEquals(expectedPageTitle, notificationMessage.getPageTitle(), "Check page title is correct");
        // Click until change in notification message
        assertTrue(notificationMessage.clickLinkUntilExpectedMessage(expectedMessage1), "Check Error message is correct");
        assertTrue(notificationMessage.clickLinkUntilExpectedMessage(expectedMessage2), "Check Error message is correct");
    }
}
