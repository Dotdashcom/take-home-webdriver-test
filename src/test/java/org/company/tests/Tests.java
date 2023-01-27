package org.company.tests;

import org.company.driver.Driver;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class Tests {

    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
        softAssert.assertAll();
    }

    @Test
   public void verifyLogInFunctionality(){

        LogingPage logingPage=new LogingPage(driver, softAssert);
        logingPage.verifyLogInFunctionality();
    }

    @Test
    public void verifyCheckUncheckBoxes(){
        CheckBoxes checkBoxes = new CheckBoxes(driver, softAssert);
        checkBoxes.checkAndUncheckBoxes();

    }

    @Test
    public void checkAlertWindow() throws InterruptedException {
        ContextMenu contextMenu = new ContextMenu(driver,softAssert);
        contextMenu.checkAlertWindow();
    }

    @Test
    public void verifyDragAnaDropFunctionality() throws InterruptedException {
        DragAndDrop dragAndDrop = new DragAndDrop(driver, softAssert);
        dragAndDrop.verifyDragAndDropFunctionality();
    }

    @Test
    public void verifyDropDownMenuFunctionality(){
        DropDown dropDown =new DropDown(driver, softAssert);
        dropDown.verifyDropDownMenu();
    }

    @Test
    public void verifyDynamicTextChange(){
        DynamicContent dynamicContent = new DynamicContent(driver, softAssert);
        dynamicContent.verifyDynamicText();
    }

    @Test
    public void checkDynamicControlWithImplicitWait(){
        DynamicControl dynamicControl = new DynamicControl(driver,softAssert);
        dynamicControl.useImplicitWaitOnDynamicControl();
    }

    @Test
    public void checkDynamicLoad(){
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver,softAssert);
        dynamicLoadingPage.verifyImplicitWaitDynamicLoadPage();
    }

    @Test
    public void downLoadFile() throws InterruptedException {
        FileDownloadPage fileDownloadPage = new FileDownloadPage(driver,softAssert);
        fileDownloadPage.downLoadFile();
    }

    @Test
    public void uploadFile(){
        FileUploadPage fileUploadPage = new FileUploadPage(driver,softAssert);
        fileUploadPage.uploadFile();
    }

    @Test
    public void testFloatingMenu() {
        FloatingMenu floatingMenu = new FloatingMenu(driver, softAssert);
        floatingMenu.testFloatingMenu();
    }

    @Test
    public void testIframe() {
        Iframe iframe = new Iframe(driver, softAssert);
        iframe.testIframe();
    }

    @Test
    public void testMouseHover()  {
        MouseHover mouseHover = new MouseHover(driver, softAssert);
        mouseHover.checkIfMouseHover();
    }

    @Test
    public void verifyJSAlertPage() {
        JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage(driver,softAssert);
        javaScriptAlertPage.checkJSAlerts();
    }

    @Test
    //TODO finish the test (assert)
    public void verifyJSError() throws InterruptedException {
        JavaScripError javaScripError = new JavaScripError(driver,softAssert);
        javaScripError.verifyJavaScripError();
    }

    @Test
    public void verifyNewWindowLink(){
        OpenNewWindow openNewWindow = new OpenNewWindow(driver,softAssert);
        openNewWindow.openNewWindowViaLink();
    }
}
