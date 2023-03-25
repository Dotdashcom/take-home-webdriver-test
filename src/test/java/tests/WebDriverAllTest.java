package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WebDriverAllTest extends TestConfiguration {

    //@Test(priority = 1)
    public void login_Success_Test() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("loginUrl"));

        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        Assert.assertEquals(homePage.getUrl(),properties.getProperty("secureUrl"));
        Assert.assertTrue(homePage.getHomePageMessage().contains(properties.getProperty("homePageMessage")));
    }

    //@Test(priority = 2)
    public void login_Failure_Test() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("loginUrl"));

        //test invalid username
        loginPage.login(properties.getProperty("invalidUsername"), properties.getProperty("password"));
        Assert.assertTrue(loginPage.getLoginMessage().contains(properties.getProperty("invalidUsernameMessage")));

        //test invalid password
        loginPage.login(properties.getProperty("username"), properties.getProperty("invalidPassword"));
        Assert.assertTrue(loginPage.getLoginMessage().contains(properties.getProperty("invalidPasswordMessage")));

    }

   // @Test(priority = 3)
    public void checkBoxes_Test() {
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("checkBoxesUrl"));

        checkBoxesPage.resetCheckBoxes();

        //check and uncheck checkbox1
        checkBoxesPage.clickCheckBox1();
        Assert.assertTrue(checkBoxesPage.isCheckBox1Selected());
        checkBoxesPage.clickCheckBox1();
        Assert.assertFalse(checkBoxesPage.isCheckBox1Selected());

        //check and uncheck checkbox2
        checkBoxesPage.clickCheckBox2();
        Assert.assertTrue(checkBoxesPage.isCheckBox2Selected());
        checkBoxesPage.clickCheckBox2();
        Assert.assertFalse(checkBoxesPage.isCheckBox2Selected());
    }

   // @Test(priority = 4)
    public void contextMenu_Test() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("contextMenuUrl"));

        contextMenuPage.rightClickOnContextMenu();
        Assert.assertTrue(contextMenuPage.getAlertText().equals(properties.getProperty("contextMenuMessage")));
    }

    //@Test(priority = 5)
    public void drag_and_Drop_Test() throws Exception {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("dragAndDropUrl"));

        dragAndDropPage.dragAndDrop();
        Assert.assertTrue(dragAndDropPage.getColumnAText().equals("B"));
        Assert.assertTrue(dragAndDropPage.getColumnBText().equals("A"));
    }

   // @Test(priority = 6)
    public void dropDown_Test() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("dropdownUrl"));

        dropdownPage.selectOption("Option 1");
        Assert.assertTrue(dropdownPage.getSelectedOptionText().equals("Option 1"));
        dropdownPage.selectOption("Option 2");
        Assert.assertTrue(dropdownPage.getSelectedOptionText().equals("Option 2"));
    }

   // @Test(priority = 7)
    public void dynamic_Content_Test() {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        dynamicContentPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("dynamicContentUrl"));

        String firstImageSrc = dynamicContentPage.getFirstImageSrc();
        String secondImageSrc = dynamicContentPage.getSecondImageSrc();
        String thirdImageSrc = dynamicContentPage.getThirdImageSrc();
        String firstText = dynamicContentPage.getFirstText();
        String secondText = dynamicContentPage.getSecondText();
        String thirdText = dynamicContentPage.getThirdText();

        dynamicContentPage.refreshPage();

        String newFirstImageSrc = dynamicContentPage.getFirstImageSrc();
        String newSecondImageSrc = dynamicContentPage.getSecondImageSrc();
        String newThirdImageSrc = dynamicContentPage.getThirdImageSrc();
        String newFirstText = dynamicContentPage.getFirstText();
        String newSecondText = dynamicContentPage.getSecondText();
        String newThirdText = dynamicContentPage.getThirdText();

        Assert.assertFalse(firstImageSrc.equals(newFirstImageSrc));
        Assert.assertFalse(firstText.equals(newFirstText));
        Assert.assertFalse(secondImageSrc.equals(newSecondImageSrc));
        Assert.assertFalse(secondText.equals(newSecondText));
        Assert.assertFalse(thirdImageSrc.equals(newThirdImageSrc));
        Assert.assertFalse(thirdText.equals(newThirdText));

    }

   // @Test(priority = 8)
    public void dynamic_Controls_Test() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicControlsPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("dynamicControlsUrl"));

        dynamicControlsPage.clickRemoveAddButton();
        Assert.assertTrue(dynamicControlsPage.getMessage().equals(properties.getProperty("dynamicControlsRemoveMessage")));

        dynamicControlsPage.clickRemoveAddButton();
        Assert.assertTrue(dynamicControlsPage.getMessage().equals(properties.getProperty("dynamicControlsAddMessage")));
        Assert.assertTrue(dynamicControlsPage.isCheckboxEnabled());

        dynamicControlsPage.clickEnableDisableButton();
        Assert.assertTrue(dynamicControlsPage.getMessage().equals(properties.getProperty("dynamicControlsEnableMessage")));
        Assert.assertTrue(dynamicControlsPage.isInputFieldEnabled());

        dynamicControlsPage.clickEnableDisableButton();
        Assert.assertTrue(dynamicControlsPage.getMessage().equals(properties.getProperty("dynamicControlsDisableMessage")));
        Assert.assertFalse(dynamicControlsPage.isInputFieldEnabled());
    }

   // @Test(priority = 9)
    public void dynamic_Loading_Test() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("dynamicLoadingUrl"));

        dynamicLoadingPage.clickStartButton();
        Assert.assertTrue(dynamicLoadingPage.getMessage().equals(properties.getProperty("dynamicLoadingMessage")));
    }

    //@Test(priority = 10)
    public void file_Download_Test() {
        DownloadPage downloadPage = new DownloadPage(driver);
        downloadPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("downloadUrl"));

        downloadPage.downLoadFile();
        Assert.assertTrue(downloadPage.checkFileDownloaded(properties.getProperty("downloadPath")));
    }

    //@Test(priority = 11)
    public void file_Upload_Test() {
        UploadPage uploadPage = new UploadPage(driver);
        uploadPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("uploadUrl"));

        uploadPage.uploadFile(properties.getProperty("uploadPath"));
        uploadPage.clickSubmitButton();
        Assert.assertTrue(uploadPage.getMessage().equals(properties.getProperty("uploadMessage")));
    }

    //@Test(priority = 12)
    public void floating_Menu_Test() {
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        floatingMenuPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("floatingMenuUrl"));

        floatingMenuPage.scrollDown();
        Assert.assertTrue(floatingMenuPage.menuDisplayed());
    }

   // @Test(priority = 13)
    public void iframe_Test() {
        IframePage iframePage = new IframePage(driver);
        iframePage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("iframeUrl"));

        iframePage.switchIframe();
        iframePage.clearText();
        iframePage.typeText(properties.getProperty("iframeText"));
        Assert.assertTrue(iframePage.getText().equals(properties.getProperty("iframeText")));
    }

    //@Test(priority = 14)
    public void mouse_Hover_Test() {
        MouseHoverPage mouseHoverPage = new MouseHoverPage(driver);
        mouseHoverPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("mouseHoverUrl"));

        List<WebElement> images = mouseHoverPage.getImages();
        List<WebElement> infos = mouseHoverPage.getInfo();
        for(int i=0; i<images.size();i++){
            mouseHoverPage.mouseHover(images.get(i));
            Assert.assertTrue(mouseHoverPage.isInfoDisplayed(infos.get(i)));
        }
    }

    //@Test(priority = 15)
    public void javaScript_Alerts_Test() {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("javascriptAlertUrl"));

        javaScriptAlertsPage.clickJsAlertButton();
        javaScriptAlertsPage.acceptAlert();
        Assert.assertTrue(javaScriptAlertsPage.getMessage().equals(properties.getProperty("jsAlertMessage")));

        javaScriptAlertsPage.clickJsConfirmButton();
        javaScriptAlertsPage.acceptAlert();
        Assert.assertTrue(javaScriptAlertsPage.getMessage().equals(properties.getProperty("jsConfirmMessage")));

        javaScriptAlertsPage.clickJsPromptButton();
        javaScriptAlertsPage.typeMessageOnPrompt(properties.getProperty("typeJsPromptMessage"));
        javaScriptAlertsPage.acceptAlert();
        Assert.assertTrue(javaScriptAlertsPage.getMessage().equals(properties.getProperty("jsPromptMessage")));
    }

    @Test
    public void javaScript_Error_Test() {
        JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage(driver);
        javaScriptErrorPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("javascriptErrorUrl"));

        Assert.assertTrue(javaScriptErrorPage.getJsErrorMessage().contains(properties.getProperty("javaScriptErrorMessage")));
    }

   // @Test(priority = 17)
    public void open_In_New_Tab_Test () {
        OpenInNewTabPage openInNewTabPage = new OpenInNewTabPage(driver);
        openInNewTabPage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("openInNewTabUrl"));

        openInNewTabPage.clickLink();
        openInNewTabPage.switchToNewWindow();
        Assert.assertTrue(openInNewTabPage.getNewWindowText().equals(properties.getProperty("newWindowTitle")));
    }

    //@Test
    public void notification_Message_Test () throws IOException {
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
        notificationMessagePage.goToUrl(properties.getProperty("baseUrl") , properties.getProperty("notificationMessageUrl"));

        try {
            for (int i = 0; i < 10; i++) {
                notificationMessagePage.clickLink();
                Assert.assertTrue(notificationMessagePage.checkMessagesValid(properties.getProperty("notificationMessage")));
            }
        }catch (AssertionError e){
            System.out.println("The test failed with the following error message: " + e.getMessage());
            // take a screenshot of the browser
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("error.png"));
            // fail the test case
            Assert.fail("The test failed with the following error message: " + e.getMessage());
        }
    }
}

