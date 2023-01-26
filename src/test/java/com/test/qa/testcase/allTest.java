package com.test.qa.testcase;

import com.test.qa.base.TestBase;
import com.test.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class allTest extends TestBase {

    mainPages main1;
    checkBox cBoxes;
    contextMenu conT;
    dragAndDrop dragDr;
    dropdown drop;
    dynamicContent cont;
    dynamicControl control;
    dynamicLoading load;
    floatingMenu flaot;
    iFrame frame;
    mouseHover mHover;
    javaScript scriptAlert;
    newTab newTabPage;
    notificationPage notifi;
    downloadFile download;
    uploading upload;
    ScriptErr err;


    public allTest() {
        super();

    }

    @BeforeMethod

    public void setUp() {
        initialization();

    }

    @AfterMethod

    public void tearDown() {
        driver.quit();
    }

    //@Test
    public void titleTest() {
        driver.get(prop.getProperty("loginUrl"));
        main1 = new mainPages();
        String loginPageTitle = main1.getTitle();
        Assert.assertEquals(loginPageTitle, "");
    }

    @Test(priority = 1)
    public void successLoinTest() {
        driver.get(prop.getProperty("loginUrl"));
        main1 = new mainPages();
        main1.validLogin();
    }

    @Test(priority = 2)
    public void invalidLoginTest() {
        driver.get(prop.getProperty("loginUrl"));
        main1 = new mainPages();
        main1.invallidLogin();

    }

    @Test(priority = 3)

    public void verifyCheckBoxTest() throws InterruptedException {

        driver.get(prop.getProperty("checkBoxUrl"));
        cBoxes = new checkBox();

        cBoxes.verifyCheckboxesSelection();

    }

    @Test(priority = 4)
    public void contextTest() {

        driver.get(prop.getProperty("contextMenuUrl"));
        conT = new contextMenu();

        conT.context();
    }

    @Test(priority = 5)
    public void dragDropTest() throws InterruptedException {

        driver.get(prop.getProperty("dragAndDrop"));

        dragDr = new dragAndDrop();

        dragDr.dargDrop();
    }

    @Test(priority = 6)
    public void dropDownTest() {

        driver.get(prop.getProperty("dropDownUrl"));

        drop = new dropdown();
        drop.dropDownMenu();


    }

    @Test(priority = 7)
    public void contentTest() {
        driver.get(prop.getProperty("dynamicContentUrl"));

        cont = new dynamicContent();

        cont.dynaContact();
    }

    @Test(priority = 8)
    public void dynamicControlTest() {

        driver.get(prop.getProperty("dynamicControlUrl"));
        control = new dynamicControl();
        control.dynaControl();
    }

    @Test(priority = 9)
    public void loadingTest() {

        driver.get(prop.getProperty("dynamicLoadingUrl"));

        load = new dynamicLoading();

        load.loading();
    }

    @Test(priority = 12)
    public void floatingMenuTest() {
        driver.get(prop.getProperty("floatingMenuUrl"));

        flaot = new floatingMenu();
        flaot.floatMenu();
    }

    @Test(priority = 13)
    public void iFrameTest() {
        driver.get(prop.getProperty("frameUrl"));

        frame = new iFrame();
        frame.frame();
    }

    @Test(priority = 14)
    public void hoverTest() {
        driver.get(prop.getProperty("hoverUrl"));

        mHover = new mouseHover();
        mHover.mouseAction();
    }

    @Test (priority = 15)
    public void scriptTest() {
        driver.get(prop.getProperty("javaScriptUrl"));

        scriptAlert = new javaScript();
        scriptAlert.script();
    }

    @Test(priority = 18)
    public void scriptErrTest() {
        driver.get(prop.getProperty("javaScriptErrorUrl"));

        err = new ScriptErr();
        err.JavaScript_Error();
    }


    @Test (priority = 16)
    public void tabTest() {
        driver.get(prop.getProperty("newTabUrl"));
        newTabPage = new newTab();
        newTabPage.windowPage();
        // Assert.assertEquals(newTabPage.validateNewHeader(driver),"New Window");
    }

    @Test(priority = 17)
    public void notificationTest() {
        driver.get(prop.getProperty("notificationMessageUrl"));

        notifi = new notificationPage();
        notifi.noMessage();
    }

    @Test(priority = 10)
    public void downloadTest() throws InterruptedException {
        driver.get(prop.getProperty("fileDownloadUrl"));

        download = new downloadFile();
        download.fileDown();

    }

    @Test(priority = 11)
    public void uploadingTest() throws InterruptedException {
        driver.get(prop.getProperty("fileUplaodUrl"));

        upload = new uploading();
        upload.fileUploading();
    }



}

