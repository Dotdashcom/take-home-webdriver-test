package Helpers;

import Config.PageObjectCore;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.security.PublicKey;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Helpers {
    static WebDriverWait wait;
    static JavascriptExecutor js ;

    static Actions actions;

    static Select selector;

    static WebDriver driver;

    static  Alert alert;

    public static void InitCustomActions(int TimeOut, WebDriver odriver){

        wait = new WebDriverWait(odriver, Duration.ofSeconds(TimeOut));
        wait.ignoring(NoSuchElementException.class);
        js = (JavascriptExecutor) odriver;
        actions = new Actions(odriver);
        driver=odriver;

    }

    public static void WaitForElement(WebElement element){

        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void SecondsToWait(int time) throws InterruptedException {

       Thread.sleep(time*1000);
    }

    public static void WaitForElementToHide(WebElement element){

        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public  static  void ScrollToBotton()
    {

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    public  static  void ScrollToElement(WebElement element) {
        WaitForElement(element);
        actions.moveToElement(element).perform();
    }


    public  static  boolean ElementIsPresent(WebElement element) throws InterruptedException {

        try{
            return element.isDisplayed();
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public  static  boolean ElementIsEnabled(WebElement element){

        try{
            return element.isEnabled();
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public  static  void  MoveMouseOverElement(WebElement element){

        actions.moveToElement(element).perform();
    }

    public  static  boolean SearchElementValueList(List<WebElement> elements, String text){
        boolean exist=false;
        for (WebElement element:elements) {

            if (element.getText().toLowerCase().trim().contains(text.toLowerCase().trim())){
                exist=true;

            }
            else {
                exist=false;
                break;
            }
        }
        return  exist;
    }

    public  static  int GetIndexElementList(List<WebElement> elements, String text){
        int i;
        for (i=0;i<=elements.size();i++ ){

            if(elements.get(i).getText().toLowerCase().trim().contains(text.toLowerCase().trim())){
                return i;

            }
        }

        return i;
    }

    public  static  Select  SelectItemFromSelect(WebElement element){

         selector = new Select(element);

        return selector;
    }

    public  static  void SwitchTab(int index){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(tabs.get(index));
    }

    public  static  void SwitchIframe(WebElement element){

        WaitForElement(element);
        driver.switchTo().frame( element);
    }
    public static void  SendText(WebElement element,String text){
        WaitForElement(element);
        element.sendKeys(text);
    }
    public static void  ClickElement(WebElement element){
        WaitForElement(element);
        element.click();
    }

public static  void  ContextClickElement(WebElement element){

        WaitForElement(element);
        actions.contextClick(element).perform();


}

    public static  void  DragElementToElement(WebElement fromElement,WebElement toElement) throws InterruptedException {

        WaitForElement(fromElement);
        WaitForElement(toElement);
        actions.dragAndDrop(fromElement,toElement).perform();
        Thread.sleep(2000);
    }

    public  static void SelectElementByTextList(List<WebElement> elements,String text){

        for (WebElement el: elements) {

            if(el.getText().trim().equalsIgnoreCase(text.trim())){
               ClickElement(el);
               break;
            }
        }
    }

    public static boolean CheckDownloadedFile(String path,String file){
        File dir = new File(path);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(file)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    public static void AcceptAlert(){
        WaitForAlert();
       driver.switchTo().alert().accept();
    }
    public static void DismissAlert(){
        WaitForAlert();
        driver.switchTo().alert().dismiss();
    }

    public static void PromptAlert(String text){
        WaitForAlert();
        driver.switchTo().alert().sendKeys(text);
    }

    public static void WaitForAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static boolean SearchTextPageSource(String text){
        return driver.getPageSource().trim().toLowerCase().contains(text.toLowerCase().trim());
    }

public static String GetDoubleQuotedText(WebElement element){

    return (String) js.executeScript(" return arguments[0].textContent", element);
}

public static void Refresh(){
        driver.navigate().refresh();
}

public static LogEntries GetConsoleLogs(){
    LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
    //Gets all errors and puts them in a list
     return logs;

}
}

