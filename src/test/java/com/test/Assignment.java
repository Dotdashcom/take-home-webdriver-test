package com.test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Assignment extends TestBase {

    @BeforeClass
    public void setUp(){

        driver.manage().window().maximize(); //Maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // dynamic wait
    }

    //Test cases --- Starting with @test
    @Test
    public void Login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomsmith","SuperSecretPassword!");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"http://localhost:7080/secure");
    }

    @Test
    public void LoginFailure() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomAmith1","1SecretPass!");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"http://localhost:7080/login");
    }

    @Test
    public void CheckBox()  {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.check();
        Assert.assertTrue(driver.findElement(By.id("checkboxes")).isDisplayed());
    }

    @Test
    public void ContextMenu() {
        MenuPage menu = new MenuPage(driver);
        Assert.assertEquals(menu.contextMenu(),"You selected a context menu" );
    }

    @Test
    public void DropDrag()  {
       DropDragPage dropDragPage = new DropDragPage(driver);
       dropDragPage.dropdrag();
    }

    @Test
    public void DropDown() {
        DropDownPage dropDownPage = new DropDownPage(driver);
        dropDownPage.Dropdown().selectByVisibleText("Option 1");
        dropDownPage.Dropdown().selectByVisibleText("Option 2");

    }

    @Test
    public void DynamicContent() throws InterruptedException {
        driver.get("http://localhost:7080/dynamic_content");

        driver. navigate().refresh();
        String text =  driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]")).getText();
        System.out.println(text);
        Thread.sleep(3000);
        driver. navigate().refresh();
        String text2 =  driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]")).getText();
        System.out.println(text2);

        Thread.sleep(3000);

    }

    @Test
    public void DynamicControls() throws InterruptedException {
        DynamicPage dynamicPage = new DynamicPage(driver);
        dynamicPage.dynamiControl();
    }

    @Test
    public void DynamicLoading() throws InterruptedException {
        DynamicPage dynamicPage = new DynamicPage(driver);
        dynamicPage.dynamicLoading();
    }

    @Test
    public void FileDownloaded(){
        FilePage filePage = new FilePage(driver);
        filePage.FileDownloaded();
        File fileLocation = new File("C:\\Users\\user\\Downloads");
        File[] Allfile = fileLocation.listFiles();
        assert Allfile != null;
        for ( File file : Allfile ) {
            if(file.getName().equals("some-file.txt")){
                System.out.println("Downloaded");
            }
        }

    }

    @Test
    public void FileUpload() {
        FilePage filePage = new FilePage(driver);
        Assert.assertEquals(filePage.FileUploaded(),"File Uploaded!");
    }

    @Test
    public void FloatingMenu() {
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        Assert.assertEquals(floatingMenuPage.FloatingMenu(),"Home\n" +
                "News\n" +
                "Contact\n" +
                "About");
    }

    @Test
    public void Iframe() {
        IFramePage iFramePage = new IFramePage(driver);
        iFramePage.Frame();
    }

    @Test
    public void MouseHover() {
         MouseHoverPage mouseHoverPage = new MouseHoverPage(driver);
        mouseHoverPage.mouseHover();
    }

    @Test
    public void JSAlert() throws InterruptedException {
         JSPage jsPage= new JSPage(driver);
        jsPage.JSAlert();
    }

    @Test
    public void JSError() {
        JSPage jsPage= new JSPage(driver);
        jsPage.JSError();
    }

    @Test
    public void NewTab() {
        NewTabPage newTabPage = new NewTabPage(driver);
        newTabPage.newTab();
    }

    @Test
    public void NotificationMessage() {
        NotificationPage notificationPage = new NotificationPage(driver);
        Assert.assertEquals( notificationPage.NotificationMessage(),"Action successful\n" +
                "×");
    }

    @Test
    public void NotificationMessage2() {
        NotificationPage notificationPage = new NotificationPage(driver);
        Assert.assertEquals(notificationPage.NotificationMessage2(),"Action unsuccesful, please try again\n" +
                "×");
    }

    //Post conditions -- starting with @after
    @AfterClass
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}
