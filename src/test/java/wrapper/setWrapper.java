package wrapper;

import com.github.dockerjava.api.model.Link;
import io.github.bonigarcia.wdm.WebDriverManager;

import static  org.junit.Assert.*;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class setWrapper {
    static WebDriver driverDotDash;
    Alert alert_ins;
    public String UrlPref= "http://localhost:7080/";

    public void isPresentonScreen (By locator){
        int ispresent = driverDotDash.findElements(locator).size();
        if (ispresent!=0)System.out.println("Element is present");
        else System.out.println("Element is not present");
    }
    public setWrapper(WebDriver driverDotDash){
        this.driverDotDash=driverDotDash;
    }
    public WebDriver chromeDriverSetUp (){
        if (driverDotDash==null){
            WebDriverManager.chromedriver().setup();
            driverDotDash=new ChromeDriver();
        }
        return driverDotDash;
    }
    public void goToURL (String goToUrl){
    driverDotDash.navigate().to(goToUrl);
    }
    public void sendKeys (By locator, String inputText){
        driverDotDash.findElement(locator).sendKeys(inputText);
    }

    String filePath;
    public void createFileNdPath (String NameFileToUpload) {
        filePath = System.getProperty("java.io.tmpdir") + NameFileToUpload;
        Path path = Paths.get(filePath);
        try {
            Files.write(path, Arrays.asList("test", "test"), StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        }catch (IOException e) {
            System.out.println(e);
        }
        System.out.println(filePath);
    }
    public void sendPathToBttn (By locator){
        driverDotDash.findElement(locator).sendKeys(filePath);
    }

    public void waitFor (int timeInSeconds,By locator){
        new WebDriverWait(driverDotDash,timeInSeconds).
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    public void clickonButton (By locator){
        driverDotDash.findElement(locator).click();

    }

    public WebElement webelement_meth (By locator){
        WebElement tro=driverDotDash.findElement(locator);
        return tro;
    }
    public void closeAllWindows (){
        driverDotDash.close();
        //driverDotDash.quit();
    }
    public void myassertValidation(String expectOrUnexpected,String CurrentText,int equalsNdNotEquals){
        if (equalsNdNotEquals==1)
        assertEquals(expectOrUnexpected,CurrentText);
        else
        assertNotEquals(expectOrUnexpected,CurrentText);

    }

    public void assertisDisplayed (String booleanValue, By locator){
        String s=String.valueOf(webelement_meth(locator).isDisplayed());
        System.out.println(s);
        assertEquals(booleanValue,String.valueOf(webelement_meth(locator).isDisplayed()));
    }
    public String getTextFromLocator (By locator){
        WebElement webelement= driverDotDash.findElement(locator);
        String ots=webelement.getText();
        return ots;
    }
    public void rightClickContext (WebElement action_webelement){
        Actions action_ins=new Actions(driverDotDash);
        action_ins.contextClick(action_webelement).perform();
    }
    public void switchToalert (){
        alert_ins=driverDotDash.switchTo().alert();
        System.out.println(alert_ins.getText());
    }
    public String printAlertText () {
        String alertText_var= alert_ins.getText();
        return alertText_var;
    }
    public void implicitWait (int timeinSeconds){
        driverDotDash.manage().timeouts().implicitlyWait(timeinSeconds, TimeUnit.SECONDS);
    }
    public void dissmissOrAcceptAlert (boolean dissmisTrueAcceptFalse) {
        if (dissmisTrueAcceptFalse)alert_ins.accept();
        else alert_ins.dismiss();
    }
    public void sendKeysToAlert(String TextToSend){
        alert_ins.sendKeys(TextToSend);
    }


    public void dragHerendDropThere (By DragLocator, By DropLocator){
        //,WebElement dragWebElement,WebElement dropWebElement
        WebElement dragWebEl = driverDotDash.findElement(DragLocator);
        WebElement dropWebEl = driverDotDash.findElement(DropLocator);

        Actions drag=new Actions(driverDotDash);
        drag.dragAndDrop(dragWebEl,dropWebEl).build().perform();
        drag.dragAndDropBy(dragWebEl,248,88).build().perform();
        implicitWait(5);

    }
    public void dragDropJs (WebElement elemFrom,WebElement elemTo,String ValueA,String ValueB){
    //Assert Before Twist Boxes
    assertTrue(elemFrom.getText().contains(ValueA));
    assertTrue(elemTo.getText().contains(ValueB));
    //JavaScript Executor
    JavascriptExecutor js=(JavascriptExecutor) driverDotDash;
    js.executeScript(JsFunction(),elemFrom,elemTo);
    Actions drag=new Actions(driverDotDash);
    Action dragNddrop= drag.clickAndHold(elemFrom).moveToElement(elemTo).release().build();
    dragNddrop.perform();
    //Assert After Twist Boxes
    assertTrue(elemFrom.getText().contains(ValueB));
    assertTrue(elemTo.getText().contains(ValueA));
    }
    private String JsFunction (){
        return "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                        "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                        "ction(format,data){this.items[format]=data;this.types.append(for" +
                        "mat);},getData:function(format){return this.items[format];},clea" +
                        "rData:function(format){}};var emit=function(event,target){var ev" +
                        "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                        "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                        "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                        "'drop',tgt);emit('dragend',src);";
    }
    public void SelectDropDownList (WebElement elem, String optionText){

        Select selectList=new Select(elem);
        selectList.selectByVisibleText(optionText);
    }

    public void refreshPage (){
        JavascriptExecutor refreshJavaScript=((JavascriptExecutor)driverDotDash);
        refreshJavaScript.executeScript("window.location.reload(true)");
    }
    HashMap <String,Object> chromePref;
    public void chromePreferencies (){
        chromePref=new HashMap<String,Object>();
        chromePref.put("profile.default_content_settings.popups",0);
        chromePref.put("download.default_directory",System.getProperty("user.dir"));
    }
    ChromeOptions chromeOP;
    public void chromeOptions (){
        chromeOP=new ChromeOptions();
        chromeOP.setExperimentalOption("prefs",chromePref);

    }
    public WebDriver chromeDriverSetUpOP (){
        WebDriverManager.chromedriver().setup();
        driverDotDash = new ChromeDriver(chromeOP);
        return driverDotDash;
    }
    public void scrollingThePage (){
        JavascriptExecutor js= (JavascriptExecutor)driverDotDash;
        //Scrolling down to the bottom by steps
        js.executeScript("window.scrollBy(0,200)","");
        js.executeScript("window.scrollBy(200,1000)","");
        js.executeScript("window.scrollBy(1000,2000)","");
        js.executeScript("window.scrollBy(2000,2050)","");
    }

    public void switchotherFrame(WebElement elem){
        driverDotDash.switchTo().frame(elem);

    }
    public void hoverMouse(WebElement elem){
        Actions hovers=new Actions(driverDotDash);
        hovers.moveToElement(elem).perform();
    }

    public void getAvailableLogType (){
        Set<String> logTypes=driverDotDash.manage().logs().getAvailableLogTypes();
        for (String e: logTypes) {
            System.out.println(e);
        }
    }
    public void findJsErrorLogEntry(){
        LogEntries logEntries=driverDotDash.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs=logEntries.getAll();
        System.out.println(logs.size());
        for (LogEntry e:logs) {
            System.out.println(e);
        }
        boolean errorFound = logs.stream()
                .anyMatch((logEntry)
                        -> logEntry.getMessage()
                        .contains(" Cannot read properties of undefined (reading 'xyz')"));
        assertTrue(errorFound);
    }

    public void handleNewWindow(){
        List<String> es=new ArrayList<String>(driverDotDash.getWindowHandles());
        driverDotDash.switchTo().window(es.get(1));
        es.stream().forEach(System.out::println);
    }
    public void returnToPreviousWindow(){
        List<String> es=new ArrayList<String>(driverDotDash.getWindowHandles());
        driverDotDash.switchTo().window(es.get(0));
    }
    List<String>notification;
    public void clickonLinkNdAssert (By LinkToClick,By ActionMesagelocator,String successMsg,String notSuccessMsg){
        notification=new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            waitFor(3, LinkToClick);
            clickonButton(LinkToClick);
            implicitWait(3);
            System.out.println(getTextFromLocator(ActionMesagelocator));
            notification.add(getTextFromLocator(ActionMesagelocator));

        }
        for (String se:notification) {
            System.out.println("------------");
            System.out.println(se);
            if (se.contains(successMsg))

            System.out.println("Action successful is a message Match");
            else if (se.contains(notSuccessMsg)) {
                System.out.println("Action unsuccesful, please try again -  message Match");
            }else System.out.println("This Action Message is not founded");
        }
    }
}
