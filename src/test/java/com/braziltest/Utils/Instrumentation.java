package com.braziltest.Utils;

import com.braziltest.interfaces.DriverFactory;
import com.vimalselvam.cucumber.listener.Reporter;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.braziltest.Utils.Config.TIMEOUTAUTOMATION;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Instrumentation {


    
    public static void sendKeysWeb (WebDriver driver, String prmType,String prmTag,  String arg0, String StepLog) throws IOException {
        try {

            Reporter.addStepLog(StepLog);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            if(prmType.equals("xpath")){
            waitCad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prmTag))).sendKeys(arg0);}

            if(prmType.equals("className")){
                waitCad.until(ExpectedConditions.presenceOfElementLocated(By.className(prmTag))).sendKeys(arg0);}

            if(prmType.equals("cssSelector")){
                waitCad.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(prmTag))).sendKeys(arg0);}

            if(prmType.equals("id")){
                waitCad.until(ExpectedConditions.presenceOfElementLocated(new By.ByName(prmTag))).sendKeys(arg0);}

            DriverFactory.Evidencia(driver);
        } catch (
                NoSuchElementException exception) {
            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }


    public static void clickWeb(WebDriver driver, String prmType, String prmTag, String StepLog) throws IOException {
        try {
            Reporter.addStepLog(StepLog);
            System.out.println("Clique  " + prmType +" "+ prmTag);
            WebDriverWait waitCad = new WebDriverWait(driver, TIMEOUTAUTOMATION);
            if (prmType.equals("xpath")) {
                waitCad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prmTag))).click();
            }

            if (prmType.equals("className")) {
                waitCad.until(ExpectedConditions.visibilityOfElementLocated(By.className(prmTag))).click();
            }

            if (prmType.equals("cssSelector")) {
                waitCad.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(prmTag))).click();
            }

            if (prmType.equals("id")) {
                waitCad.until(ExpectedConditions.visibilityOfElementLocated(By.id(prmTag))).click();
            }

            DriverFactory.Evidencia(driver);
        } catch (
                NoSuchElementException exception) {



            assertFalse("This will fail!", true);
            System.out.println("FAILURE" + exception);
        }
    }

    public static void clear(WebDriver driver, String tag) {
        WebElement element = driver.findElement(By.id(tag));
        element.clear();


    }

    public static void verticesAreVisible(WebDriver driver, String xpath) {
        List<WebElement> rows = driver.findElements(By.className(".sidebar-navigation-menu-item"));
        WebElement button = rows.get(1);
        button.click();
    }


    public static void ClickOut(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0);
        actions.moveByOffset(500, 100).click().build().perform();
    }


    public static void clickRightMenu(WebDriver driver){
        try {

            By locator = By.id("hot-spot");
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            WebElement element=driver.findElement(locator);
            rightClick(element,driver);
        } catch (NoSuchElementException exception) {

        }

    }
    public static void dragAndDrop(WebDriver driver, int type) {
        WebElement drag = null;
        WebElement drop= null;
        if(type==0) {
            Actions act=new Actions(driver);
            drag=driver.findElement(By.xpath(".//*[@id='draggable']"));
             drop=driver.findElement(By.xpath(".//*[@id='droppable']"));
            act.dragAndDrop(drag, drop).build().perform();
        }

        if(type==1) {
            //This routine use localhost and dont get efect, i believe is nto html5, diferent types are tested and dosnt work!
            Actions builder = new Actions(driver);
            drag = driver.findElement(By.xpath(".//*[@id='column-a']"));
            drop = driver.findElement(By.xpath(".//*[@id='column-b']"));
            builder.clickAndHold(drag)
                    .pause(Duration.ofSeconds(2))
                    .moveToElement(drop)
                    .release(drop)
                    .build()
                    .perform();
        }
            String textTo = drop.getText();
            if (textTo.equals("Dropped!")) {
                System.out.println("PASS: File is dropped to target as expected");
                Assert.assertTrue(true);
            } else {
                System.out.println("FAIL: File couldn't be dropped to target as expected");
                Assert.assertFalse(true);
            }




    }






    public static void rightClick(WebElement element, WebDriver driver) {
        try {
            Actions action = new Actions(driver).contextClick(element);
            action.build().perform();

            System.out.println("Sucessfully Right clicked on the element");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "
                    + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM "
                    + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable "
                    + e.getStackTrace());
        }
    }

    public static void validContext( WebDriver driver){
        Alert alert=driver.switchTo().alert();
        String textEdit = alert.getText();
        Assert.assertEquals(textEdit, "You selected a context menu", textEdit);
    }




    public static String getVariantTextOnScreen(WebDriver driver, String type, String Text) throws IOException, InterruptedException {
        String result = "";
        List<WebElement> listElement = null;
        WebDriverWait wait = new WebDriverWait(driver,30);
        if(type.equals(Config.xpath)) {
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + Text + "')]")));
             listElement = driver.findElements(By.xpath("//*[contains(text(),'" + Text + "')]"));
        }
        if(type.equals(Config.id)){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
             listElement = driver.findElements(By.id("message"));
        }
        for (int i = 0; i < listElement.size(); i++) {
            String elementText = listElement.get(i).getText();
            if (elementText.toUpperCase().contains(Text.toUpperCase())) {
                result = elementText.replace("\n","").replace("×","");
                break;
            }
        }
        return result;
    }

    public static String getPageStatus(WebDriver driver) throws IOException, InterruptedException {
        String result = "";
        List<WebElement> listElement = driver.findElements(By.className("columns"));
        for (int i = 0; i < listElement.size(); i++) {
            String elementText = listElement.get(i).getText();
            result= elementText +";"+ result;

        }
        return result;
    }

    public static void checkBox(WebDriver driver, String arg0) {
        List<WebElement> listElement = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 0; i < listElement.size(); i++) {
            Boolean elementText = listElement.get(i).isSelected();
            if(arg0.equals("false")){
                if (elementText) {
                    listElement.get(i).click();
                }
            }
            if(arg0.equals("true")){
                if (!elementText) {
                    listElement.get(i).click();
                }
            }
        }
    }

    public static void checkBoxVal(WebDriver driver, String arg0) {
        List<WebElement> listElement = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 0; i < listElement.size(); i++) {
            Boolean elementText = listElement.get(i).isSelected();
            if(arg0.equals("false")) {
                if (!elementText) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertFalse(true);
                }
            }
            if(arg0.equals("true")) {
                if (elementText) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertFalse(true);
                }
            }
        }
    }


    public static void selectDropDown(WebDriver driver, String arg0) {
        By locatorA = By.id("dropdown");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorA));
        Select opt = new Select(driver.findElement(locatorA));
        opt.selectByVisibleText(arg0);
        WebElement optres= opt.getFirstSelectedOption();
        System.out.println(optres.getText());
        Assert.assertEquals("CHECKING OPTIONS",optres.getText(),arg0);
    }

    public static void uploadfile(WebDriver driver,String arg0) {
        String File = "";
        if(System.getProperty("os.name").contains("Windows")) {
            File = "C:\\Users\\braziltest\\Downloads\\"+arg0;
        }
        if(System.getProperty("os.name").contains("Linux")){
            File = "/home/bressan/Downloads/"+arg0;
        }
        By locatorA = By.id("file-upload");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorA));
        WebElement uploadElement = driver.findElement(locatorA);
        uploadElement.sendKeys(File);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form/input[2]")).click();
    }

    public static void mouseHover(WebDriver driver, String arg0) {
        By locatorA = null;
        if(arg0.equals("1")) {
            locatorA= By.xpath("//*[@id='content']/div/div[1]/img");
        }
        if(arg0.equals("2")) {
            locatorA= By.xpath("//*[@id='content']/div/div[2]/img");
        }
        if(arg0.equals("3")) {
            locatorA= By.xpath("//*[@id='content']/div/div[3]/img");
        }
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorA));
        WebElement ele = driver.findElement(locatorA);
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
    }

    public static void ClicksOnJSAlertButton(WebDriver driver, String arg0) {
        By locatorA = null;
        if(arg0.equals("1")) {
            locatorA= By.xpath("//*[@id='content']/div/ul/li[1]/button");
        }
        if(arg0.equals("2")) {
            locatorA= By.xpath("//*[@id='content']/div/ul/li[2]/button");
        }
        if(arg0.equals("3")) {
            locatorA= By.xpath("//*[@id='content']/div/ul/li[3]/button");
        }

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorA));
        WebElement element = driver.findElement(locatorA);
        element.click();

        if(arg0.equals("3")) {
            driver.switchTo().alert().sendKeys("TESTE 123");
        }


    }

    public static void ClickLink(WebDriver driver, String arg0,String Result) throws IOException, InterruptedException {
        By locatorA = null;
        if(arg0.equals("1")) {
            locatorA= By.xpath("//*[contains(text(),'Click Here')]");
        }
        if(arg0.equals("2")) {
            locatorA= By.xpath("//*[@id='content']/div/p/a");
        }

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorA));
        WebElement element = driver.findElement(locatorA);
        element.click();

        if(arg0.equals("2")) {
            String Ret3 = Instrumentation.getVariantTextOnScreen(driver, Config.xpath, Result);
            if (Ret3.contains(Result)) {
                Assert.assertEquals("VALIDATION", Result, Ret3);
            } else {
                ClickLink(driver,arg0,Result);
            }
        }
    }
}//--->
