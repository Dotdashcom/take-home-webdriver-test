package task.stepDefinitions;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task.pages.*;
import task.utilities.ConfigurationReader;
import task.utilities.Driver;


import java.io.File;
import java.util.concurrent.TimeUnit;



public class task3 {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


    DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

    @Test
    public void dynamicControls() {
        //Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/dynamic_controls");


        //Test clicks on the Remove Button and uses explicit wait.
        wait.until(ExpectedConditions.elementToBeClickable(dynamicControlsPage.removeButton)).click();

        //Test asserts that the checkbox is gone.
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.itsGoneMess));
        Assert.assertTrue(dynamicControlsPage.itsGoneMess.isDisplayed());

        //Test clicks on Add Button and uses explicit wait.
        wait.until(ExpectedConditions.elementToBeClickable(dynamicControlsPage.addButton)).click();

        //Test asserts that the checkbox is present.
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.itsBackMess));
        Assert.assertTrue(dynamicControlsPage.itsBackMess.isDisplayed());

        //Test clicks on the Enable Button and uses explicit wait.
        wait.until(ExpectedConditions.elementToBeClickable(dynamicControlsPage.enableButton)).click();

        //Test asserts that the text box is enabled.
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.itsEnabledMess));
        Assert.assertTrue(dynamicControlsPage.itsEnabledMess.isDisplayed());

        //Test clicks on the Disable Button and uses explicit wait.
        wait.until(ExpectedConditions.elementToBeClickable(dynamicControlsPage.disableButton)).click();

        //Test asserts that the text box is disabled.
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.itsDisabledMess));
        Assert.assertTrue(dynamicControlsPage.itsDisabledMess.isDisplayed());


    }

    DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();

    @Test
    public void dynamicLoading() {
        //Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/dynamic_loading/2");

        //Test clicks the start button and uses explicit wait.
        wait.until(ExpectedConditions.elementToBeClickable(dynamicLoadingPage.startButton)).click();

        //Test asserts that “Hello World!” text is displayed.
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPage.helloWorldText));
        Assert.assertTrue(dynamicLoadingPage.helloWorldText.isDisplayed());
    }

    @Test
    public void fileDownload() throws InterruptedException {
        //File Download: http://localhost:7080/download Test File Download.
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/download");
        //Test clicks on the file.
        Driver.getDriver().findElement(By.xpath("//a[text()='some-file.txt']")).click();

        //Test asserts that the file is downloaded.
        Thread.sleep(3000);
        Assert.assertTrue(isFileDownloaded("C:\\Users\\jmber\\Downloads\\", "some-file.txt"));


    }
    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            System.out.println(dirContents[i].getName());
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    FileUploadPage fileUploadPage = new FileUploadPage();

    @Test
    public void fileUpload() {
        //File Upload: http://localhost:7080/upload Test File Upload.
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/upload");

        //Test uses Upload Button or Drag and Drop to upload a file.
        fileUploadPage.fileUploadInput.sendKeys("C:\\Users\\jmber\\Desktop\\Pictures\\download.jpg");
        Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        fileUploadPage.uploadButton.click();

        //Test asserts that the file is uploaded.

        Assert.assertTrue(fileUploadPage.fileUploadedHeader.isDisplayed());
    }

    FloatingMenuPage floatingMenuPage = new FloatingMenuPage();

    @Test
    public void floatingMenu() {
        //Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/floating_menu");
        Driver.getDriver().manage().window().maximize();

        //Test scrolls the page.
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("window. scrollBy(0,500)", "");


        //Test asserts that the floating menu is still displayed.
        Assert.assertTrue(floatingMenuPage.newsMenu.isDisplayed());

    }

    FramePage framePage = new FramePage();

    @Test
    public void iframe() {
        //Iframe: http://localhost:7080/iframe Test iframe.
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/iframe");

        //Test switches to Iframe and types some text.
        Driver.getDriver().switchTo().frame(0);
        framePage.iconForTextinFrame.sendKeys("Hello");


        //Test asserts that the typed text is as expected.
        String actual = framePage.iconForTextinFrame.getText();
        System.out.println("actual = " + actual);

        Assert.assertTrue(actual.contains("Hello"));

    }

    MouseHoverPage mouseHoverPage = new MouseHoverPage();

    @Test
    public void mouseHover() {

        //Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/hovers");

        //Test does a mouse hover on each image.
        Actions actions = new Actions(Driver.getDriver());

        //Test asserts that additional information is displayed for each image.
        actions.moveToElement(mouseHoverPage.image1).perform();
        Assert.assertTrue(mouseHoverPage.textVerIMG1.isDisplayed());

        actions.moveToElement(mouseHoverPage.image2).perform();
        Assert.assertTrue(mouseHoverPage.textVerIMG2.isDisplayed());

        actions.moveToElement(mouseHoverPage.image3).perform();
        Assert.assertTrue(mouseHoverPage.textVerIMG3.isDisplayed());

    }

    JavaScriptAllertsPage jsAlertPage = new JavaScriptAllertsPage();

    @Test
    public void javaScriptAlerts() throws Exception {
        //JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/javascript_alerts");


        //Test Clicks on JS Alert Button.
        jsAlertPage.JSAlertButton.click();

        //Test asserts alert message
        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertEquals("I am a JS Alert", alert.getText());

        alert.accept();


        //Test clicks on JS confirm Button and clicks ok on alert.
        jsAlertPage.JSConfirmButton.click();

        //Test asserts the alert message.
        Assert.assertEquals("I am a JS Confirm", alert.getText());
        alert.accept();

        //Test clicks on JS Prompt Button and types a message on Prompt.
        jsAlertPage.JSPrompt.click();

        Alert al = Driver.getDriver().switchTo().alert();
        al.sendKeys("text");
        al.accept();
        Thread.sleep(2000);
        Assert.assertTrue(jsAlertPage.result.getText().contains("text"));



        //Test asserts that the alert message contains the typed message.
        //todo

    }

    @Test
    public void javaScriptError() {
        //JavaScript Error: http://localhost:7080/javascript_error Test JS error.
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/javascript_error");

        //Test finds the JavaScript error on the page.
        //Test asserts that the page contains error: Cannot read property 'xyz' of undefined.
        String actual = Driver.getDriver().manage().logs().get(LogType.BROWSER).toJson().toString();
        System.out.println("actual = " + actual);
        Assert.assertTrue(actual.contains("Cannot read property 'xyz' of undefined"));
    }

    OpenNewTabPage openNewTabPage = new OpenNewTabPage();

    @Test
    public void openNewTab() {
        //Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/windows");

        //Test clicks on the Click Here link.
        openNewTabPage.clickHereButton.click();
        //Test asserts that a new tab is opened with text New Window.

        Assert.assertTrue(openNewTabPage.headerNewWindown.isDisplayed());
    }

    @Test
    public void notificationMessage() throws InterruptedException {
        //Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/notification_message_rendered");
        Driver.getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        //Test clicks on the Click Here link a multiple times.
        NotificationMessagePage np = new NotificationMessagePage();
        np.clickHereButton.click();
        Thread.sleep(2000);
        String text1 = np.message.getText();
        System.out.println(text1);
        String text2 = "";
        int counter = 0;
        if (text1.contains("successful")) {
            text2 = "Action unsuccesful, please try again";
        } else {
            text2 = "Action successful";
        }
        System.out.println(text2);

        np.clickHereButton.click();
        Thread.sleep(2000);
        while (!np.message.getText().contains(text2) && counter++ < 10) {
            System.out.println(np.message.getText());
            np.clickHereButton.click();
            Thread.sleep(2000);
        }

        Assert.assertTrue(counter < 10);


        //Test asserts that one of the “Action Successful”, “Action unsuccessful, please try again” and “Action Unsuccessful” messages show on click.
    }


}