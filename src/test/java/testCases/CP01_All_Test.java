package testCases;

import Utils.Utility;
import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;
import pages.Other;

import static Utils.Utility.deleteFile;
import static Utils.Utility.fileExist;

public class CP01_All_Test extends Base {

    String urlLoginSuccess = "http://localhost:7080/login ";
    String urlCheckBoxes  = "http://localhost:7080/checkboxes";
    String urlClickHere = "http://localhost:7080/notification_message_rendered";
    String urlContextMenu = "http://localhost:7080/context_menu";
    String urlDragAndDrop = "http://localhost:7080/drag_and_drop";
    String urlDropDown = "http://localhost:7080/dropdown";
    String urlDinamicContent = "http://localhost:7080/dynamic_content?with_content=static";
    String urlDinamicLoading = "http://localhost:7080/dynamic_loading/2";
    String urlDinamicControl = "http://localhost:7080/dynamic_controls";
    String urlDownload = "http://localhost:7080/download";
    String urlUpload = "http://localhost:7080/upload";
    String urlIframe = "http://localhost:7080/iframe";
    String urlFloating = "http://localhost:7080/floating_menu";
    String msgFail = "Your password is invalid!";
    String msgSecure = "You logged into a secure area!";

    @Test(description = "Login Success")
    public void testLoginSucess(){
        Login login = new Login(driver);
        driver.get(urlLoginSuccess);
        login.loginPage("tomsmith", "SuperSecretPassword!");
        boolean msg = login.getTitle(msgSecure);
        Assert.assertTrue(msg);
    }
    @Test(description = "Login Failure")
    public void testLoginFail(){
        Login login = new Login(driver);
        driver.get(urlLoginSuccess);
        login.loginPage("tomsmith", "passwordWrong");
        boolean msgError = login.getTitle(msgFail);
        Assert.assertTrue(msgError);
    }
    @Test(description = "Checkboxes")
    public void testCheckTwoBoxes(){
        Other other = new Other(driver);
        driver.get(urlCheckBoxes);
        //check one
        other.setCheckOne();
        //other.setCheckTwo();
        boolean check1 = other.getStateCheckOne();
        boolean check2 = other.getStateCheckTwo();
        //uncheck one
        other.setCheckOne();
        boolean uncheck1 = other.getStateCheckOne();
        if((uncheck1) && (!check2)){
            Assert.assertFalse(check1);
            Assert.assertFalse(check2);
        }else{
            Assert.fail("check boxes selected");
        }
    }

    @Test(description = "Checkboxes")
    public void testCheckOneBoxes(){
        Other other = new Other(driver);
        driver.get(urlCheckBoxes);
        //check one
        other.setCheckOne();
        //uncheck two
        other.setCheckTwo();
        boolean check1 = other.getStateCheckOne();
        boolean check2 = other.getStateCheckTwo();
        if((check1) && (!check2) ){
            Assert.assertTrue(check1);
            Assert.assertFalse(check2);
        }else{
            Assert.fail("check boxes selected");
        }
    }

    @Test(description = "Context Menu")
    public void testContextMenu(){
        Other other = new Other(driver);
        driver.get(urlContextMenu);
        boolean alert = other.rigthClickBox();
        if(alert){
            driver.switchTo().alert().accept();
        }else{
            Assert.fail("don't display alert msg");
        }
    }

    @Test(description = "Drag and Drop")
    public void testDragAndDropA(){
        Other other = new Other(driver);
        driver.get(urlDragAndDrop);
        String textA = other.moveAtoB();
        if(textA.equals("B")) {
            Assert.assertTrue(true, "The new value es B");
        }else {
            Assert.fail("The value is still A");
        }
    }
    @Test(description = "Drag and Drop")
    public void testDragAndDropB(){
        Other other = new Other(driver);
        driver.get(urlDragAndDrop);
        String textB = other.moveBtoA();
        if(textB.equals("A")) {
            Assert.assertTrue(true, "The new value es A");
        }else {
            Assert.fail("The value is still B");
        }
    }

    @Test(description = "Dropdown")
    public void testDropDown() {
        Other other = new Other(driver);
        driver.get(urlDropDown);
        boolean select1 = other.select(1);
        boolean select2 = other.select(2);
        if(select1 || select2) {
            Assert.assertTrue(true, "Option one or two was selected");
        }else {
            Assert.fail("error in select option");
        }
    }

    @Test(description = "Dynamic Content")
    public void testDinamicContent() {
        Other other = new Other(driver);
        driver.get(urlDinamicContent);
        String textBefore1 = other.getDinamicContentOne();
        String textBefore2 = other.getDinamicContentTwo();
        String textBefore3 = other.getDinamicContentThree();
        //made a few refresh
        other.click_Here();
        other.click_Here();
        other.click_Here();
        String textAfter1 = other.getDinamicContentOne();
        String textAfter2 = other.getDinamicContentTwo();
        String textAfter3 = other.getDinamicContentThree();
        if( (textBefore1.contains(textAfter1)) && textBefore2.contains(textAfter2) && textBefore3.contains(textAfter3)){
            Assert.fail("The message are equals");
        }else{
            Assert.assertTrue(true, "The message are different");
        }
    }

    @Test(description = "Dynamic Control")
    public void testDinamicControl() {
        Other other = new Other(driver);
        driver.get(urlDinamicControl);
        boolean checkbox = other.clickRemove();
        if(!checkbox){
            Assert.assertTrue(true, "The checkobx is erased");
        }else{
            Assert.fail("The checkbox is present");
        }
        boolean btnAdd = other.clickAdd();
        if(btnAdd){
            Assert.assertTrue(true, "The checkobx is present again");
        }else{
            Assert.fail("The checkbox is not present");
        }
        boolean btnEnabled = other.clickEnable();
        if(btnEnabled){
            Assert.assertTrue(true, "The input is enabled");
        }else{
            Assert.fail("The input is not enabled");
        }
        boolean btnDisable = other.clickDisable();
        if(!btnDisable){
            Assert.assertTrue(true, "The input is disable");
        }else{
            Assert.fail("The input is enabled");
        }
    }

    @Test(description = "Dynamic Loading")
    public void testDinamicLoading() {
        Other other = new Other(driver);
        driver.get(urlDinamicLoading);
        String text = other.clickStart();
        System.out.println(text);
        if(text.contains("Hello World!")){
            Assert.assertTrue(true,"Message expected");
        }else{
            Assert.fail("Message not expected");
        }
    }

    @Test(description = "File Download")
    public void testFileDownloading() {
        Other other = new Other(driver);
        driver.get(urlDownload);
        other.downloadFile();
        boolean file = fileExist();
        if(file){
            Assert.assertTrue(true,"file download");
            //erase the file
            deleteFile();
        }else{
            Assert.fail("error with the download");
        }
    }

    @Test(description = "File Upload")
    public void testFileUpload() {
        Other other = new Other(driver);
        driver.get(urlUpload);
        boolean file = other.uploadFile();
        if(file){
            Assert.assertTrue(true,"file uploaded");
        }else{
            Assert.fail("error with the upload");
        }
    }

    @Test(description = "Floating Menu")
    public void testFloatingMenu() {
        Other other = new Other(driver);
        driver.get(urlFloating);
        boolean menu = other.scrollDown();
        if(menu){
            Assert.assertTrue(true,"menu displayed with scroll");
        }else{
            Assert.fail("error to display menu whit the scroll");
        }
    }

    @Test(description = "Iframe")
    public void testIframe() {
        Other other = new Other(driver);
        driver.get(urlIframe);
        boolean iframe = other.switchIframe("hi, this is a test");
        if(iframe){
            Assert.assertTrue(true,"I can switch to iframe and write");
        }else{
            Assert.fail("error when I tried to switch and write some text");
        }
    }

    @Test(description = "Notification Message")
    public void testClickHere(){
        Other other = new Other(driver);
        driver.get(urlClickHere);
        //click 3 times
        other.clickHere();
        other.clickHere();
        other.clickHere();
        boolean msgOk = other.getTitle("Action successful");
        boolean msgTryAgain = other.getTitle("Action unsuccesful, please try again");
        boolean msgUnsuccesful = other.getTitle("Action Unsuccessful");
        if(msgOk || msgTryAgain || msgUnsuccesful){
            Assert.assertTrue(true,"Message expected");
        }else{
            Assert.fail("Message not expected");
        }
    }

}
