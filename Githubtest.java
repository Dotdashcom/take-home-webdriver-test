package test_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.GetText;
import page_objects.LandingDashboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GitHubTest extends DriverWrapper {
    private static String BaseUrl = "http://localhost:7080/";

    @Test
    public void GitTest_01() {
        //testing to verify successful login
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "login");
        landingDashboard.enterUsername("tomsmith");
        landingDashboard.enterPassword("SuperSecretPassword!");
        landingDashboard.clickLogin();
        Assert.assertEquals(getText.getLoginSuccessMessage(), "Welcome to the Secure Area. When you are done click logout below.");
    }

    @Test
    public void GitTest_02() {
        //testing to verify failed login with valid username and invalid password
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "login");
        landingDashboard.enterUsername("tomsmith");
        landingDashboard.enterPassword("addasfjdsnf");
        landingDashboard.clickLogin();
        Assert.assertEquals(getText.getLoginFailMessage(), "Your password is invalid!\n×");
    }

    @Test
    public void GitTest_03() {
        //testing to verify failed login with invalid username
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "login");
        landingDashboard.enterUsername("fafsds");
        landingDashboard.enterPassword("addasfjdsnf");
        landingDashboard.clickLogin();
        Assert.assertEquals(getText.getLoginFailMessage(), "Your username is invalid!\n×");
    }

    @Test
    public void GitTest_04() {
        //unchecking Box 2
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "checkboxes");
        landingDashboard.clickCheckBox2();
        Assert.assertFalse(getText.isCheckBox2Selected());
    }

    @Test
    public void GitTest_05() {
        //checking Box 1
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "checkboxes");
        landingDashboard.clickCheckBox1();
        Assert.assertTrue(getText.isCheckBox1Selected());
    }

    @Test
    public void GitTest_06() {
        //right click context menu item
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "context_menu");
        landingDashboard.rightClickContextMenuItem();
        String alertText = DriverWrapper.getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertText, "You selected a context menu");

    }

    @Test
    public void GitTest_07() {
        //drag&&drop
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "drag_and_drop");
        //destination locator is missing for drop
    }

    @Test
    public void GitTest_08() {
        //dropdown
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "dropdown");
        landingDashboard.selectOptionFromDropDown("Option 1");
        Assert.assertTrue(getText.isOptionOneSelected());
    }

    @Test
    public void GitTest_09() {
        //verifying dynamic content
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        String dynamic = "dynamic_content?with_content=static";
        getDriver().navigate().to(BaseUrl + dynamic);
        String textFromFirstPageLoad = getText.getTextFromDynamicElement();
        getDriver().navigate().to(BaseUrl + dynamic);
        String textFromSecondPageLoad = getText.getTextFromDynamicElement();
        Assert.assertNotEquals(textFromFirstPageLoad, textFromSecondPageLoad);

    }

    @Test
    public void GitTest_10() {
        //explicit wait
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "dynamic_controls");
        landingDashboard.clickEnableButton();
        landingDashboard.clickRemoveButton();
        WebDriverWait wait = new WebDriverWait(DriverWrapper.getDriver(), 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(getText.getText1()));
        wait.until(ExpectedConditions.presenceOfElementLocated(getText.getText2()));
        Assert.assertEquals(getText.getMessagefromText1(), "It's gone!");
        Assert.assertEquals(getText.getMessagefromText2(), "It's enabled!");
    }

    @Test
    public void GitTest_11() {
        //explicit wait
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "dynamic_loading/2");
        landingDashboard.clickStartButton();
        WebDriverWait wait = new WebDriverWait(DriverWrapper.getDriver(), 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(getText.getHelloWorldText()));
        Assert.assertEquals(getText.getHelloWorldMessage(), "Hello World!");
    }

    @Test
    public void GitTest_12() {
        //verifying file is downloaded
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "download");
        landingDashboard.clickDownloadLink();
        String filePath = "C:\\Users\\fayee\\Downloads\\some-file.txt";
        File file = new File(filePath);
        File[] totalFiles = file.listFiles();
        boolean isFileDownloaded = false;
        for (File f : totalFiles) {
            if (f.getName().equals("some-file.txt"))
                isFileDownloaded = true;
        }
        Assert.assertTrue(isFileDownloaded);
    }

    @Test
    public void GitTest_13() {
        //verifying upload
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "upload");
        landingDashboard.uploadFile("C:\\Users\\fayee\\Downloads\\some-file.txt");
        landingDashboard.clickUpload();
        Assert.assertEquals(getText.getUploadConfirmation(), "File Uploaded!");
    }

    @Test
    public void GitTest_15() {
        //iframe
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "iframe");
        getDriver().manage().window().maximize();
        getDriver().switchTo().frame("mce_0_ifr");
        Assert.assertEquals(getText.getiFrameText(), "Your content goes here.");

    }

    @Test
    public void GitTest_16() {
        //HoverOver
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "hovers");
        WebElement avatar = DriverWrapper.getDriver().findElement(By.xpath("//div[@class='example']//div[1]//img[1]"));
        Actions actions = new Actions(DriverWrapper.getDriver());
        actions.moveToElement(avatar).build().perform();
        getDriver().findElement(By.partialLinkText("profile")).click();
        Assert.assertEquals(getText.getSinatraMessage(), "Sinatra doesn’t know this ditty.");

    }

    @Test
    public void GitTest_17() {
        //alerts
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "javascript_alerts");
        landingDashboard.clickJSAlert();
        getDriver().switchTo().alert().accept();
        Assert.assertEquals(getText.getSucessAlertMessage(), "You successfuly clicked an alert");


    }

    @Test
    public void GitTest_18() {
        //test JS error
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "javascript_error");
        Assert.assertEquals(getText.getJSerrorMessage(), "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.");
    }

    @Test
    public void GitTest_19() {
        //test new window
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "windows");
        landingDashboard.clickNewWindow();
        List<String> windows = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windows.get(1));
        Assert.assertEquals(getText.getNewWindowMessage(),"New Window");

    }

    @Test
    public void GitTest_20() {
        //test notification message
        LandingDashboard landingDashboard = new LandingDashboard();
        GetText getText = new GetText();
        getDriver().navigate().to(BaseUrl + "notification_message_rendered");
        landingDashboard.clickNotificationMessage();
        Assert.assertEquals(getText.getNotificationSuccessMessage(),"Notification Message");
    }
}
