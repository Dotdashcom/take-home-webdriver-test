package com.utils;

import com.testbase.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CommonMethods extends BaseClass {

           /*  Browser Functions Forward Backward ,refresh and scroll down     */

    public static void BrowserNavigateBack() {

        driver.navigate().back();

    }

    public static void BrowserNavigateForward() {

        driver.navigate().forward();

    }

    public static  void BrowserPageRefresh() {

        driver.navigate().refresh();

    }

    public static  void PageScrollDown() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

    }

    /*  Methods for explicit wait   */


    public static void WaitTillElementIsVisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void WaitTillElementIsInvisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    public static void WaitTillElementIsClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }





    public static void Wait_ajax() throws InterruptedException {
        String a = null;
        for (int i = 0; i < 80; i++) {
            a = (String) ((JavascriptExecutor) driver)
                    .executeScript("var data=window.$.active; return data.toString();");
            Thread.sleep(50);
            if (!a.equals("0")) {
                a = (String) ((JavascriptExecutor) driver)
                        .executeScript("var data=window.$.active; return data.toString();");

                break;

            }
        }
        int z = 0;
        while (!a.equals("0")) {
            a = (String) ((JavascriptExecutor) driver)
                    .executeScript("var data=window.$.active; return data.toString()");
            Thread.sleep(300);
            z++;
            if (z > 1200) {
                break;
            }
        }
    }

                        /*  Methods for,Hover, Double click, right click drag and drop (Actions Class)   */

    public static void Context_Click(WebElement element){
        Actions action = new Actions(driver);
        action.contextClick(element).build().perform();
    }

    public static void HoverOverElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }



    public static void DragAndDrop(WebElement fromElement,WebElement toElement){
       // Actions action = new Actions(driver);
      //  action.clickAndHold(fromElement).build().perform();
      //  action.moveToElement(toElement).build().perform();
       // action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
       // action.dragAndDrop(fromElement,toElement).build().perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", fromElement, toElement);


    }

                       /*  Alert or popup */
    public static void AlertAccept(){
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    public static void AlertDismiss(){
        driver.switchTo().alert().dismiss();
        driver.switchTo().defaultContent();
    }

    public static String GetAlertText(){
        return driver.switchTo().alert().getText();
    }

    public static void TypeAlertText(String _textInput){
         driver.switchTo().alert().sendKeys(_textInput);
         driver.switchTo().alert().accept();
         driver.switchTo().defaultContent();
    }

                       /*  Select Value from DropDown */

    public static void SelectDropDownByText(WebElement element, String option){
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

    public static void SelectDropDownByIndex(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static void SelectDropDownByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static String GetSelectedDropdownValue(WebElement element){
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

                               /* Browser  -  New tab handling */

    public static void Switch_New_Tab() {

        Window_Handle = driver.getWindowHandle();

        List<String> ID = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(ID.get(1));

    }

    public static void Switch_New_Tab2() {

        Window_Handle = driver.getWindowHandle();

        List<String> ID = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(ID.get(2));

    }

    public static void Switch_Old_Tab() {

        driver.close();

        driver.switchTo().window(Window_Handle);

    }
                           /* DownloadedFile Verification */

    public static  boolean VerifyDownloadedFile(String _downloadPath, String _fileName) {
        boolean flag = false;
        File dir = new File(_downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(_fileName))
                flag = true;
        }

        return flag;
    }
                      /*iFrame Handling */

    public static void SwitchToiFrameByName(String _frameName) {

        driver.switchTo().frame(_frameName);

    }

    public static void SwitchToiFrameByWebElement(WebElement element) {

        driver.switchTo().frame(element);
    }

}
