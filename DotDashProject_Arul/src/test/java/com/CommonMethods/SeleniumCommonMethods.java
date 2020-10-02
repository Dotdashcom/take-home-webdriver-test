package com.CommonMethods;

import com.BaseTest.TestEngine;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SeleniumCommonMethods extends TestEngine {

    //clear textboxes before providing inputs
    public static void TextFieldClear(WebElement _element){
        _element.clear();
    }

    //explicit wait implementation
    public static void WaitUntilElementAppears(WebElement _element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(_element));
    }

    //fetch alert message
    public static String GetJSAlertText(){
        return driver.switchTo().alert().getText();
    }

   //Java Script Alert accept
    public static void JSAlertAccept(){
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    // javascript alert Cancel
    public static void JSAlertCancel(){
        driver.switchTo().alert().dismiss();
        driver.switchTo().defaultContent();
    }

   //Send Keys to alert
    public static void TypeJSAlertText(String _textInput){
        driver.switchTo().alert().sendKeys(_textInput);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    //context click / right click using actions class
    public static void ContextClick(WebElement _element) {
        Actions actions = new Actions(driver);
        actions.contextClick(_element).build().perform();
    }

    //Drag and drop using actions class
    public static void DragAndDropMethod(WebElement _fromLocator, WebElement _toLocator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(JSfordraganddrop, _fromLocator, _toLocator);
    }

    public static void DragAndDrop(WebElement fromElement,WebElement toElement){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(fromElement,toElement).build().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(JSfordraganddrop, fromElement, toElement);

    }

    //Drop down values select by visible text
    public static void SelectDropDownByVisibleText(WebElement element, String option){
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

    //Browser refresh
    public static void BrowserRefresh() {
        driver.navigate().refresh();
    }

    //Check if file is downloaded
    public static boolean IsFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();
        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag=true;
        }
        return flag;
    }

    //page scroll down using javascript
    public static void ScrollDownTillPageEnd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //Switch to iframe in the page
    public static void SwitchToiFrameByWebElement(WebElement element) {
        driver.switchTo().frame(element);
    }

    //mouse hover action class
    public static  void MouseHoverFunctionality(WebElement _element){
        Actions action = new Actions(driver);
        action.moveToElement(_element).build().perform();
    }

    //browser back navigation
    public static void BrowserBack() {
        driver.navigate().back();
    }

    //wait till Full Page Loads
    public static void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    //open a new tab
    public static void SwitchBetweenTabs(int tabNum) {
        windowHandle = driver.getWindowHandle();
        List<String> ID = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(ID.get(tabNum));
    }

    //Switch back to old tab
    public static void SwitchBackTab() {
        driver.close();
        driver.switchTo().window(windowHandle);

    }


}
