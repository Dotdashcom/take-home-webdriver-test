package takehome.tests;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import takehome.base.AbstractTestBase;
import takehome.pages.LoginPage;
import takehome.utilities.BrowserUtilities;
import takehome.utilities.ConfigurationReader;
import takehome.utilities.Driver;
import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;


public class AllTest extends AbstractTestBase {
    Actions actions= new Actions(Driver.getDriver());
    @Test
    public void verifyValidLogin() {
        loginPage.clickOnLoginLink();
        loginPage.login(ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password"));
        String actual = ConfigurationReader.getProperty("welcomeMessage");
        Assert.assertEquals(actual, loginPage.getLoginSuccessMessage());
    }
    @Test
    public void verifyFailedLoginTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnLoginLink();
        loginPage.login(ConfigurationReader.getProperty("wrongUsername" ),
                ConfigurationReader.getProperty("password"));
        String actualPassword ="Your password is invalid!";
        String actualUsername="Your username is invalid!";
        if (loginPage.getInvalidPasswordMessage()==actualPassword){
            Assert.assertEquals(actualPassword, loginPage.getInvalidPasswordMessage());
        } else if(loginPage.getInvalidPasswordMessage()==actualUsername){
            Assert.assertEquals(actualUsername,loginPage.getInvalidPasswordMessage());
        }
    }


    @Test
    public void verifyCheckbox(){
        checkbox.clickOnCheckBox();
       String actual = "both checkbox work";
        Assert.assertEquals(actual, checkbox.putCheckMarks());

    }
    @Test
    public void verifyCheckDeselect(){
        checkbox.clickOnCheckBox();
        checkbox.un_clickCheckbox();
        Assert.assertTrue(!checkbox.firstCheckbox.isSelected(), "failed to select checkbox");

    }
    @Test
    public void verifyRightClickOnContextMenu(){
        loginPage.clickOnContextLink();
        Assert.assertEquals("You selected a context menu", loginPage.rightClickONContextMenu());
    }

    @Test
    public void verifyDropDownTest() {
        dropDownPage.selectDropdownOption();
        Select select = new Select(dropDownPage.dropdown );
        select.selectByVisibleText("Option 1");
        Assert.assertEquals("Option 1", select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Option 2");
        Assert.assertEquals("Option 2", select.getFirstSelectedOption().getText());
    }
    @Test
    public void verifyDynamicContent(){
        dynamicContent.clickOnDynamicContentLink();
//        String istTxtBeforeRefresh = dynamicContent.getContentText("1");
//        Driver.getDriver().navigate().refresh();
//        //compare the text after refresh
//        Assert.assertNotEquals(istTxtBeforeRefresh,dynamicContent.getContentText("1"));
//        String secondTxtBeforeRefresh = dynamicContent.getContentText("2");
//        Driver.getDriver().navigate().refresh();
//        Assert.assertNotEquals(secondTxtBeforeRefresh, dynamicContent.getContentText("2"));
//        String thirdTxtBeforeRefresh = dynamicContent.getContentText("3");
//        Driver.getDriver().navigate().refresh();
//        Assert.assertNotEquals(thirdTxtBeforeRefresh, dynamicContent.getContentText("3"));
            int counter=1;
            String textNumber="";
        for (int i = 0; i < 3; i++) {
            textNumber=Integer.toString(counter);
            String actual= dynamicContent.getContentText(textNumber);
            Driver.getDriver().navigate().refresh();
            Assert.assertNotEquals (actual,dynamicContent.getContentText(textNumber));
            counter++;
        }



    }
    @Test
    public void verifyRemoveButtonIsGone(){
        dynamicControlPage.clickOnDynamicControlLink();
        dynamicControlPage.clickOnRemoveButton();
        System.out.println(dynamicControlPage.confirmCheckboxExisting());
        Assert.assertEquals(true, dynamicControlPage.confirmCheckboxExisting());


    }
    @Test
    public void verifyAddButtonAppear(){
        dynamicControlPage.clickOnDynamicControlLink();
        dynamicControlPage.clickOnRemoveButton();
        BrowserUtilities.wait(5);
        dynamicControlPage.clickOnAddButton();
        Assert.assertEquals(false, dynamicControlPage.confirmCheckboxExisting());
    }
    @Test
    public void verifyEnableButtonFunction(){
        dynamicControlPage.clickOnDynamicControlLink();
        dynamicControlPage.clickEnableButton();
        Assert.assertEquals("It's enabled!", dynamicControlPage.getButtonText());
        BrowserUtilities.wait(2);
        dynamicControlPage.clickDisableButton();
        Assert.assertEquals("It's disabled!", dynamicControlPage.getButtonText());
    }

    @Test
    public void verifyStartButtonFunction(){
        dynamicLoadingPage.clickOnStartButton();
        Assert.assertEquals("Hello World!",dynamicLoadingPage.getText());
    }

    @Test
    public void verifyDownloadFile() throws InterruptedException {

        fileDownloadPage.clickOnDownloadLink();
        String user ="user.name";
       File f1 = new File("C:\\Users\\'"+user+"'\\Downloads\\some-file.txt");
        String fileName= f1.getName();
        Assert.assertEquals( fileName,  "some-file.txt");
        Thread.sleep(3000);


    }


    @Test
    public void verifyUploadFunction(){

        fileUploadPage.uploadFile();
        //please pass the name of the file that you intend to upload so it can be asserted.For example, I passed
        //some-file(6).txt
       Assert.assertEquals("some-file.txt",fileUploadPage.getText());
    }
    @Test
    public void verifyFloatingMenu(){
        floatingMenuPage.scroll();
        Assert.assertEquals(true, floatingMenuPage.checkFloatingMenu());
    }
    @Test
    public void verifyIFrameManipulation(){
        iFrame.writeIntoIFrame();
        String testText="In this testcase we will focus on accessing frame.";
        Assert.assertEquals(testText, iFrame.getTextFromFrame(testText));


    }
    @Test
    public void verifyImageHover(){
        hoverPage.clickOnHoverLink();
       hoverPage.hoverOverImages(hoverPage.firstImage);
       Assert.assertEquals(hoverPage.getImageText(hoverPage.firstImgTxt),"name: user1");
        hoverPage.hoverOverImages(hoverPage.secondImg);
        Assert.assertEquals(hoverPage.getImageText(hoverPage.secondImgText),
                "name: user2");



        }
        @Test
    public void jsErrorTest() {
       jsErrorPage.clickOnJSErrorLink();

        LogEntries logContent = Driver.getDriver().manage().logs().get(LogType.BROWSER);
        String logs = logContent.toJson().stream().map(LogEntry::getMessage).collect(Collectors.joining());

        Assert.assertTrue(logs.contains("Cannot read property 'xyz' of undefined"));
    }
//    @Test
//    public void verifyDragAndDrop(){
//        dragAndDrop.clickDDLink();
//        WebElement firstObject = Driver.getDriver(). findElement(By.id("column-a"));
//        WebElement secondObject = Driver.getDriver(). findElement(By.id("column-b"));;
//        String textABeforeDrag = firstObject.getText();
//
////        actions.clickAndHold(firstObject).moveToElement(secondObject).
////                release(secondObject).release().build().perform();
//        BrowserUtilities.wait(5);
//        actions.clickAndHold(firstObject).release(secondObject).build().perform();
//        BrowserUtilities.wait(5);
////        Assert.assertNotEquals(textABeforeDrag,firstObject.getText());
//    }
    @Test
    public void verifyWindowHandle(){
        ;
        newTabPage.clickOnMultipleWindowsLink();
        String pageTitleBeforeNewTab = Driver.getDriver().getTitle();
       String oldWinHandle = Driver.getDriver().getWindowHandle();
       BrowserUtilities.wait(2);
       newTabPage.clickOnNewTabLink();
       Set<String > windowHandles = Driver.getDriver().getWindowHandles();
       for(String windowHandle: windowHandles){
           if (!windowHandle.equals(oldWinHandle)){
               Driver.getDriver().switchTo().window(windowHandle);
           }
       }
       Assert.assertNotEquals(pageTitleBeforeNewTab, Driver.getDriver().getTitle());
     
    }
    @Test
    public void verifyNoMsg(){
        notifiMsgPage.clickOnNotifyMsgLink();
        Assert.assertTrue(notifiMsgPage.actionMessage.isDisplayed());

    }
    @Test
    public void verifyJsAlert(){
        jsAlertPage.clickOnJsLink();
        jsAlertPage.clickOnJsButton(jsAlertPage.JsAlertBtn);
        jsAlertPage.switchToAlert();
        Assert.assertEquals("I am a JS Alert", jsAlertPage.returnJsTxt());

        }
        @Test
    public void verifyJsConfirmAlert(){
            jsAlertPage.clickOnJsLink();
            jsAlertPage.clickOnJsButton(jsAlertPage.jsConfirmBtn);
            jsAlertPage.switchToAlert();
            Assert.assertEquals("I am a JS Confirm", jsAlertPage.returnJsTxt());
        }
    @Test
    public void verifyJsPromptAlert(){
        jsAlertPage.clickOnJsLink();
        jsAlertPage.clickOnJsButton(jsAlertPage.jsPromptBtn);
        jsAlertPage.switchToAlert();
        Assert.assertEquals("I am a JS prompt", jsAlertPage.returnJsTxt());
    }


    }









