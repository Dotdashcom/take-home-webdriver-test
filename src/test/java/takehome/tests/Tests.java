package takehome.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import takehome.utilities.Driver;
import takehome.utilities.ReusableMethods;
import takehome.pages.LoginPage;
import takehome.pages.HomePage;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Tests {
    LoginPage loginPage;
    HomePage homePage;

    public static String baseURL = "http://localhost:7080";
    public static String loginURL = "http://localhost:7080/login";

    @AfterTest
    public void afterTest(){
        Driver.closeDriver();
    }

    @BeforeTest
    public void beforeTest(){
    }

    @Test
    public void TC01_loginSuccess() {
        //Page Object Model for the login page should be provided.
        //Test is able to login successfully.
        //Test uses an assertion to make sure User has logged in.
        //Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!

        Driver.getDriver().navigate().to(loginURL);
        loginPage = new LoginPage();
        loginPage.userName.sendKeys("tomsmith");
        loginPage.passWord.sendKeys("SuperSecretPassword!");
        loginPage.submitButton.click();

        ReusableMethods.verifyElementDisplayed(loginPage.secureArea);
    }

    @Test
    public void TC02_loginFailure() {

//        Page Object Model for the login page should be used.
//        Test is not able to login with wrong credentials.
//        Test uses assertions to check Login failed for incorrect user and password.

        Driver.getDriver().navigate().to(loginURL);
        loginPage = new LoginPage();
        loginPage.userName.sendKeys("tomsmithXX");
        loginPage.passWord.sendKeys("SuperSecretPassword!");
        loginPage.submitButton.click();

        ReusableMethods.verifyElementDisplayed(loginPage.invalidUsernameWarning);
    }

    @Test
    public void TC02_loginFailure_2() {

//        Page Object Model for the login page should be used.
//        Test is not able to login with wrong credentials.
//        Test uses assertions to check Login failed for incorrect user and password.

        Driver.getDriver().navigate().to(loginURL);
        loginPage = new LoginPage();
        loginPage.userName.sendKeys("tomsmith");
        loginPage.passWord.sendKeys("SuperSecretPassword!XX");
        loginPage.submitButton.click();
        ReusableMethods.verifyElementDisplayed(loginPage.invalidUsernameWarning);

    }

    @Test
    public void TC03_checkBoxes() throws InterruptedException {
        //    Checkboxes
        //    Test checks and unchecks checkboxes.
        //    Test uses assertions to make sure boxes were properly checked and unchecked.
        Driver.getDriver().get(baseURL);
        homePage=new HomePage();
        homePage.CheckboxesLink.click();

        Assert.assertFalse(homePage.checkBox1.isSelected());
        Assert.assertTrue(homePage.checkBox2.isSelected());

        homePage.checkBox1.click();
        Assert.assertTrue(homePage.checkBox1.isSelected());

        homePage.checkBox2.click();
        Assert.assertFalse(homePage.checkBox2.isSelected());
    }

    @Test
    public void TC04_contextMenu() throws InterruptedException {
//        Test right clicks on the context menu.
//        Test asserts the alert menu text.
        Driver.getDriver().get(baseURL);
        homePage = new HomePage();
        homePage.ContextMenuLink.click();
        Actions action = new Actions(Driver.getDriver());

        try {
            action.contextClick(homePage.contextArea).perform();
            Assert.assertTrue(Driver.getDriver().switchTo().alert().getText().contains("You selected a context menu"));

        } catch (UnhandledAlertException f) {
            try {
                Alert alert = Driver.getDriver().switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void TC05_dragAndDrop() throws InterruptedException {

//    Test drags element A to element B.
//    Test asserts that the text on element A and B are switched.
//    Drag and Drop: http://localhost:7080/drag_and_drop Perform Drag And Drop in a Webdriver test.

        Driver.getDriver().get(baseURL);
        homePage = new HomePage();
        homePage.DragandDropLink.click();
        Actions action = new Actions(Driver.getDriver());
        action.clickAndHold(homePage.areaA).moveToElement(homePage.areaB).release(homePage.areaB).build().perform();
        ReusableMethods.waitFor(2);

        Assert.assertEquals("B",homePage.areaA.getText());
        Assert.assertEquals("A",homePage.areaB.getText());

        //I wanted no note here that these action methods are highly unreliable. in this case strange enough, the action seems
        //to be dropping the element where the mouse is left at this last moment.
    }

    @Test
    public void TC06_dropdown() {

//    Test selects Option 1 and Option 2 from the drop down menu.
//    Test asserts Option 1 and Option 2 are selected.
        Driver.getDriver().get(baseURL);
        homePage = new HomePage();
        homePage.DropdownLink.click();
        Select dropdown = new Select(homePage.dropdown);
        dropdown.selectByValue("1");
        Assert.assertTrue(homePage.dropdownSelected.getText().equals("Option 1"));
        dropdown.selectByValue("2");
        Assert.assertTrue(homePage.dropdownSelected.getText().equals("Option 2"));
    }

    @Test
    public void TC07_dynamic() {
//        Test refreshes the page a couple of times.
//        Test asserts that the content changes on each refresh.
        Driver.getDriver().get(baseURL);
        homePage = new HomePage();
        homePage.DynamicContentLink.click();
        String firstAppearContent = homePage.content.getText();

        Driver.getDriver().navigate().refresh();
        String secondAppearContentAfterRefresh = homePage.content.getText();

        Driver.getDriver().navigate().refresh();
        String thirdAppearContentAfterRefresh = homePage.content.getText();

        Assert.assertFalse(firstAppearContent.equals(secondAppearContentAfterRefresh));
        Assert.assertFalse(secondAppearContentAfterRefresh.equals(thirdAppearContentAfterRefresh));
    }

    @Test
    public void TC08_dynamic_controls() {
//        Test clicks on the Remove Button and uses explicit wait.
//        Test asserts that the checkbox is gone.
//        Test clicks on Add Button and uses explicit wait.
//        Test asserts that the checkbox is present.

//        Test clicks on the Enable Button and uses explicit wait.
//        Test asserts that the text box is enabled.
//        Test clicks on the Disable Button and uses explicit wait.
//        Test asserts that the text box is disabled.
        Driver.getDriver().get(baseURL);
        homePage = new HomePage();
        homePage.DynamicControlsLink.click();
        homePage.removeButton.click();
        ReusableMethods.waitForVisibility(homePage.message, 10);
        Assert.assertTrue(homePage.message.getText().equals("It's gone!"));

        homePage.addButton.click();
        ReusableMethods.waitForVisibility(homePage.message, 10);
        Assert.assertTrue(homePage.message.getText().equals("It's back!"));
        Assert.assertTrue(homePage.checkbox.isDisplayed());

        homePage.enableButton.click();
        ReusableMethods.waitForClickablility(homePage.textInput, 10);
        Assert.assertTrue(homePage.message.getText().equals("It's enabled!"));
        Assert.assertTrue(homePage.disableButton.isDisplayed());

        homePage.disableButton.click();
        ReusableMethods.waitForVisibility(homePage.disableButton, 10);
        Assert.assertTrue(homePage.message.getText().equals("It's disabled!"));
        Assert.assertTrue(homePage.enableButton.isDisplayed());
    }

    @Test
    public void TC09_dynamic_loading() throws InterruptedException {

//        Test clicks the start button and uses explicit wait.
//        Test asserts that “Hello World!” text is displayed.}
        Driver.getDriver().get(baseURL);
        homePage = new HomePage();
        homePage.DynamicLoadingLink.click();
        homePage.DynamicLoadingLink2.click();
        homePage.startButton.click();

        ReusableMethods.waitForVisibility(homePage.finishText, 10);
        Assert.assertTrue(homePage.finishText.getText().equals("Hello World!"));
    }

    @Test
    public void TC10_file_download() {
//
//        Test clicks on the file.
//        Test asserts that the file is downloaded.
        Driver.getDriver().get(baseURL);
        homePage = new HomePage();
        homePage.FileDownloadLink.click();
        homePage.fileDownloadLink.click();

        ReusableMethods.waitFor(4);
        Assert.assertTrue(Files.exists(Paths.get("/Users/omerkanca/Downloads/some-file.txt")));
    }

    @Test
    public void TC11_file_upload() {

//    Test uses Upload Button or Drag and Drop to upload a file.
//    Test asserts that the file is uploaded.
        Driver.getDriver().get(baseURL);
        homePage = new HomePage();
        homePage.FileUploadLink.click();
        String filepath = "/Users/omerkanca/Downloads/usa.png";
        homePage.fileUploadPath.sendKeys(filepath);
        homePage.fileSubmitButton.click();

        ReusableMethods.waitFor(3);
        Boolean isUploaded = homePage.fileUploaded.getText().equals("File Uploaded!");
        Assert.assertTrue(isUploaded);
    }

    @Test
    public void TC12_floatingMenu() throws IOException {

//        Test scrolls the page.
//        Test asserts that the floating menu is still displayed.
        Driver.getDriver().get(baseURL);
        homePage = new HomePage();
        homePage.FloatingMenuLink.click();

        Actions action = new Actions(Driver.getDriver());
        action.scrollByAmount(0, 1000).perform();

        Assert.assertTrue(homePage.floatingMenuItem.isDisplayed());
        File image = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));

        //isDiplayed method will not verify optically.
        //so there needs be a human eye checking this verification.
    }

    @Test
    public void TC13_iframe() {

//        Test switches to Iframe and types some text.
//        Test asserts that the typed text is as expected.
        Driver.getDriver().get(baseURL);
        homePage = new HomePage();
        homePage.FramesLink.click();
        homePage.iFrameLink.click();
        Driver.getDriver().switchTo().frame(0);
        homePage = new HomePage();
        homePage.iframeWritingArea.clear();

        String expectedText = "Faruk KANCA";
        homePage.iframeWritingArea.sendKeys(expectedText);

        String actualText = homePage.iframeWritingArea.getText();
        Assert.assertTrue(expectedText.equals(actualText));
    }

    @Test
    public void TC14_mouseHover() {
//        Test does a mouse hover on each image.
//        Test asserts that additional information is displayed for each image.
        Driver.getDriver().get(baseURL);
        homePage = new HomePage();
        homePage.HoversLink.click();
        Actions action = new Actions(Driver.getDriver());

        action.moveToElement(homePage.image1).perform();
        Assert.assertTrue(homePage.addInfo.get(0).isDisplayed());

        ReusableMethods.waitFor(2);

        action.moveToElement(homePage.image2).perform();
        Assert.assertTrue(homePage.addInfo.get(1).isDisplayed());

        ReusableMethods.waitFor(2);

        action.moveToElement(homePage.image3).perform();
        Assert.assertTrue(homePage.addInfo.get(2).isDisplayed());
    }

    @Test
    public void TC15_javaScriptAlert() throws InterruptedException {
//        Test Clicks on JS Alert Button.
//        Test asserts alert message.
//        Test clicks on JS confirm Button and clicks ok on alert.
//        Test asserts the alert message.
//        Test clicks on JS Prompt Button and types a message on Prompt.
//        Test asserts that the alert message contains the typed message.
        WebDriverManager.chromedriver().setup();
        WebDriver driver2 = new ChromeDriver();
        driver2.get("http://localhost:7080/javascript_alerts");

       driver2.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
       String alertText=driver2.switchTo().alert().getText();

       Assert.assertEquals("I am a JS Alert",alertText);

       driver2.switchTo().alert().accept();
       driver2.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

       String jsconfirm=driver2.switchTo().alert().getText();

       Assert.assertEquals("I am a JS Confirm",jsconfirm);
       driver2.switchTo().alert().accept();
       driver2.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
       driver2.switchTo().alert().sendKeys("Hello World!");
        driver2.switchTo().alert().accept();

       String result=driver2.findElement(By.id("result")).getText();
       Assert.assertTrue(result.contains("Hello World!"));

    //In this test, i had to switch to a new driver since for some strange reason "driver.manage().window().maximize();" was preventing the
    //program work
    }

    @Test
    public void TC16_jsError() {

    //JavaScript Error
    //Test finds the JavaScript error on the page.
    //Test asserts that the page contains error: Cannot read property 'xyz' of undefined.
        Driver.getDriver().get(baseURL);
        homePage = new HomePage();
        homePage.JSErrorLink.click();

        Set<String> logtyp = Driver.getDriver().manage().logs().getAvailableLogTypes();
        for (String s : logtyp) {
            System.out.println(logtyp);
        }

        LogEntries logEntries = Driver.getDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> lg = logEntries.getAll();
        for (LogEntry logEntry : lg) {
            System.out.println(logEntry);
        }
        Assert.assertTrue(lg.get(0).getMessage().contains("Cannot read properties of undefined (reading 'xyz')"));
    }

    @Test
    public void TC17_openInNewTab() {
//    Open in New Tab
//    Test clicks on the Click Here link.
//    Test asserts that a new tab is opened with text New Window.
        Driver.getDriver().get(baseURL);
        homePage = new HomePage();
        homePage.MultipleWindowsLink.click();
        String window1=Driver.getDriver().getWindowHandle();
        homePage.clickHere.click();

        Set<String> windows=Driver.getDriver().getWindowHandles();

        String window2="";
        for (String w: windows){
            if (!w.equals(window1)){
                window2=w;
                break;
            }
        }
        Driver.getDriver().switchTo().window(window2);
        Assert.assertTrue(homePage.newWindow.getText().equals("New Window"));
    }

    @Test
    public void TC18_notificationMessage(){

//        Test clicks on the Click Here link a multiple times.
//        Test asserts that one of the “Action Successful”, “Action unsuccessful,
//        please try again” and “Action unsuccessful,
////        please try again” messages show on click.
        Driver.getDriver().get(baseURL);
        homePage=new HomePage();
        homePage.NotificationMessagesLink.click();

        homePage.actionClickHere.click();
        String notification1= homePage.notification.getText();
        System.out.println(notification1);
        if (notification1.length()>20){
            notification1=notification1.substring(0,36);
            Assert.assertEquals(notification1, "Action unsuccesful, please try again");
        }
            else {
                notification1=notification1.substring(0,17);
                Assert.assertEquals(notification1,"Action successful");
        }

        homePage.actionClickHere.click();
        String notification2= homePage.notification.getText();
        System.out.println(notification2);
        if (notification2.length()>20){
            notification2=notification2.substring(0,36);
            Assert.assertEquals(notification2, "Action unsuccesful, please try again");
        }
        else {
            notification2=notification2.substring(0,17);
            Assert.assertEquals(notification2,"Action successful");
        }

        homePage.actionClickHere.click();
        String notification3= homePage.notification.getText();
        System.out.println(notification3);
        if (notification3.length()>20){
            notification3=notification3.substring(0,36);
            Assert.assertEquals(notification3, "Action unsuccesful, please try again");
        }
        else {
            notification3=notification3.substring(0,17);
            Assert.assertEquals(notification3,"Action successful");
        }
    }
}