package com.braziltest.Pages;
import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Steps.Hook.Hook;
import com.braziltest.Utils.Instrumentation;
import com.braziltest.Utils.Config;
import com.braziltest.interfaces.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.stream.StreamSupport;
import static com.braziltest.Utils.Config.PATHEVIDENCELINUX;
import static com.braziltest.Utils.Config.PATHEVIDENCEWIN;
import static org.junit.Assert.assertTrue;

public class LoginPage extends BaseStep {
    public static int x = 0;
    public static void thatTheUserIsOnTheHomeScreen(String arg0) throws Exception {
        DriverFactory.getDriver(arg0);
    }

    public static void SendCredentials(String arg0, String arg1) throws IOException {
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath, "//input[@name='username']", arg0, "Type User");
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath, "//input[@name='password']", arg1, "Type Pass");
        Instrumentation.clickWeb(Webdriver, Config.xpath, "//*[contains(text(),' Login')]", "Confirm");
    }
    public static void checkCheckBoxes(String arg0) {
        Instrumentation.checkBox(Webdriver,arg0);
    }

    public static void contextMenu(WebDriver driver) {
        Instrumentation.clickRightMenu(Webdriver);
    }

    public static void selectDoropdown(WebDriver driver, String arg0) {
        Instrumentation.selectDropDown(Webdriver,arg0);
    }

    public static void testRefresh(WebDriver driver,int arg0) throws IOException, InterruptedException {

        for(int i=1;i<arg0;i++){
            String[] arrOfStr=null;
            String[] arrOfStr2=null;
            String Res1 = Instrumentation.getPageStatus(Webdriver);
            arrOfStr = Res1.split(";");
            driver.navigate().refresh();
            String Res2 = Instrumentation.getPageStatus(Webdriver);
            arrOfStr2 = Res2.split(";");
            if(!arrOfStr.equals(arrOfStr2)){
                Assert.assertTrue(true);
            }else{
                Assert.assertFalse(true);
            };
        }
    }
    public static void ClicksOnREmoveButton(WebDriver driver,String arg0) throws IOException {
        Instrumentation.clickWeb(driver,Config.xpath,"//*[@id='checkbox-example']/button","Click remove Button");

    }

    public static void validateResult(String type,String arg0,String Result) throws Exception {
        File f = null;
        if(type.equals("LOGIN")) {
            String Ret3 = Instrumentation.getVariantTextOnScreen(Webdriver, Config.xpath, arg0);
            if (Ret3.contains(arg0)) {
                Assert.assertEquals("VALIDATION", arg0, Ret3);
            } else {
                Assert.assertTrue(false);
            }
        }
        if(type.equals("DC")) {
            String Ret3 = Instrumentation.getVariantTextOnScreen(Webdriver, Config.id, arg0);
            if (Ret3.contains(arg0)) {
                Assert.assertEquals("VALIDATION", arg0, Ret3);
            } else {
                Assert.assertTrue(false);
            }
        }
        if(type.equals("CKBX")) {
                Instrumentation.checkBoxVal(Webdriver,arg0);
        }
        if(type.equals("CON")){
                Instrumentation.validContext(Webdriver);
        }
        if(type.equals("FILE")){
            Thread.sleep(3000);
           if(System.getProperty("os.name").contains("Windows")) {
               f = new File("C:\\Users\\braziltest\\Downloads\\"+arg0);
            }
            if(System.getProperty("os.name").contains("Linux")){
                f = new File("/home/bressan/Downloads/"+arg0);
            }
            if(f.exists() && !f.isDirectory()) {
                Assert.assertTrue(true);
            }else{
                Assert.assertFalse(true);
            }
        }
        if(type.equals("JS1")) {
            String Res = Webdriver.switchTo().alert().getText();
            Webdriver.switchTo().alert().accept();
            Assert.assertEquals("This is a popup window", arg0, Res);
            String Ret3 = Instrumentation.getVariantTextOnScreen(Webdriver, Config.xpath, Result);
            if (Ret3.contains(Result)) {
                Assert.assertEquals("VALIDATION", Result, Ret3);
            } else {
                Assert.assertTrue(false);
            }
        }

        if(type.equals("NW")) {
            for (String winHandle : Webdriver.getWindowHandles()) {
                Webdriver.switchTo().window(winHandle);
            }
            String Ret3 = Instrumentation.getVariantTextOnScreen(Webdriver, Config.xpath, Result);
            if (Ret3.contains(arg0)) {
                Assert.assertTrue(true);
            }
        }

    }



    public static void switchIframe(WebDriver driver ) throws IOException {
        Webdriver.switchTo().frame("mce_0_ifr");
        Instrumentation.clear(Webdriver,"tinymce");
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath, "//*[@id='tinymce']","SOME TEXT", "");

    }



    public static void ClicksOnAddButton(WebDriver driver) throws IOException {
        Instrumentation.clickWeb(driver,Config.xpath,"//*[@id='checkbox-example']/button","Click Add ");
    }

    public static void ClicksOnEnableButton(WebDriver driver) throws IOException {
        Instrumentation.clickWeb(driver,Config.xpath,"//*[@id='input-example']/button","Click Enable");
    }

    public static void ClicksOnDisableButton(WebDriver driver) throws IOException {
        Instrumentation.clickWeb(driver, Config.xpath, "//*[@id='input-example']/button", "Click Disable");
    }

    public static void ClicksTheStartButton(WebDriver driver) throws IOException {
        Instrumentation.clickWeb(driver, Config.xpath, "//*[@id='start']/button", "Click Start");
    }

    public static void ClickFileDownload(WebDriver driver) throws IOException {
        Instrumentation.clickWeb(driver, Config.xpath, "//*[contains(text(),'some-file.txt')]", "Click some-file.txt");
    }

    public static void UploadFile(WebDriver driver,String arg0) throws IOException {
        Instrumentation.uploadfile(driver,arg0);
    }

    public static void testScrollPage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public static void mouseHover(WebDriver driver,String arg0) {
        Instrumentation.mouseHover(Webdriver,arg0);
    }

    public static void ClicksOnJSAlertButton(WebDriver driver,String arg0) throws IOException {
        Instrumentation.ClicksOnJSAlertButton(Webdriver,arg0);
    }

    public static void testFindsTheJavaScriptErrorOnThePage(WebDriver driver, String arg0) {
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        String ret="";
        for (LogEntry lgs : logs){
            ret = lgs.getMessage();
            if(ret.contains(arg0))
            {
                System.out.println(lgs.getMessage());
                Assert.assertTrue(true);
            }
        }
    }

    public static void testClicksOnTheClickHereLink(WebDriver driver ) throws IOException, InterruptedException {
        Instrumentation.ClickLink(driver,"1","");
    }

    public static void testClicksOnTheClickHereLinkAMultipleTimes(WebDriver driver,String arg0) throws IOException, InterruptedException {
        Instrumentation.ClickLink(driver,"2",arg0);
    }
}
