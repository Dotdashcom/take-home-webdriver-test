
package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CommonMethods extends PageInitialized {

    protected static Select select;

    public static String randomsString(int size) {
        String generateString = RandomStringUtils.randomAlphabetic(size);
        return generateString;
    }

    /// ScreenShots ///
    public static String getTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy_MM_dd_HH:mm:ss");
        return sdf.format(date.getTime());
    }

    public static byte[] takeScreenshot(String filename) {
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

        File file = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = Constants.SREENSHOTS + filename + getTimeStamp() + ".png";
        try {
            FileUtils.copyFile(file, new File(destinationFile));
        } catch (Exception ex) {
            System.out.println("Cannot take screenshot!");
        }
        return picBytes;
    }

    public static byte[] takeScreenshot(String filename, WebElement element) {
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        byte[] picBytes = element.getScreenshotAs(OutputType.BYTES);

        File file = element.getScreenshotAs(OutputType.FILE);
        String destinationFile = Constants.SREENSHOTS + filename + getTimeStamp() + ".png";

        try {
            FileUtils.copyFile(file, new File(destinationFile));
        } catch (Exception ex) {
            System.out.println("Cannot take screenshot!");
        }
        return picBytes;
    }

    public static void selectObj(List<WebElement> list, String key) {
        for (WebElement option : list) {
            if (option.getText().contains(key)) {
                option.click();
                break;
            }
        }
    }

    public static void selectExactObj(List<WebElement> list, String key) {
        for (WebElement option : list) {
            if (option.getText().equals(key)) {
                option.click();
                break;
            }
        }
    }

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getJsAlert(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", element);
        System.out.println("Alert: " + validationMessage);
        return validationMessage;
    }

    public static JavascriptExecutor getJSObject() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        return js;
    }

    public static void jsClick(WebElement element) {
        getJSObject().executeScript("argument[0].click()", element);
    }

    public static void scrollToElement(WebElement element) {
        getJSObject().executeScript("argument[0].scrollIntoView(true)", element);
    }

    public static void scrollByPixel(int pixel) {
        // scroll down => positiveNumber
        // scroll up => negativeNumber
        getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
    }

    public static void verifyHeader(WebElement element, String expected) {
        Assert.assertTrue(element.getText().contains(expected));
        System.out.println("Actual: " + element.getText());
        System.out.println("Expected: " + expected);
    }

    public static WebElement waitForClickAbility(WebElement element) {
        return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebDriverWait getWaitObject() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Constants.EXPLICIR_WAIT);
        return wait;
    }

    public static void click(WebElement element) {
        waitForClickAbility(element).click();
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void rightClick(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(element).perform();
    }

    public static void getTextFromList(List<WebElement> listEle) {
        for (int i = 0; i < listEle.size(); i++) {
            System.out.println(listEle.get(i).getText());
        }
    }

    public static void hoverList(List<WebElement> element) {
        for (WebElement el : element) {
            Actions act = new Actions(getDriver());
            act.moveToElement(el).build().perform();
        }
    }

    public static void switchToSecondWindow() {
        String mainWindow = Driver.getDriver().getWindowHandle();
        Set<String> windows = Driver.getDriver().getWindowHandles();
        for (String eachWindow : windows) {
            if (!eachWindow.equals(mainWindow)) {
                Driver.getDriver().switchTo().window(eachWindow);
                break;
            }
        }
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void doubleClick(WebElement source) {
        Actions action = new Actions(Driver.getDriver());
        action.doubleClick(source).perform();
    }

    public static void dragAndDrop(WebElement elementA, WebElement elementB) {
        Actions action = new Actions(Driver.getDriver());
        action.dragAndDrop(elementA, elementB).build().perform();
    }

    public static String getTitle() {
        return getDriver().getTitle();
    }

    public static void switchToFrame(String nameOrId) {
        try {
            Driver.getDriver().switchTo().frame(nameOrId);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    public static void switchToFrame(WebElement element) {
        try {
            Driver.getDriver().switchTo().frame(element);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    public static void switchToFrame(int index) {
        try {
            Driver.getDriver().switchTo().frame(index);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    public static boolean isClickable(WebElement el) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Constants.EXPLICIR_WAIT);
            wait.until(ExpectedConditions.elementToBeClickable(el));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isClickable(List<WebElement> el) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Constants.EXPLICIR_WAIT);
            wait.until(ExpectedConditions.visibilityOfAllElements(el));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void visibleOfElements(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Constants.EXPLICIR_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void dismissAlert() {
        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public static void acceptAlert() {
        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public static void getAlertText() {
        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.getText();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public static double getPriceAsInt(WebElement element) {
        return Double.parseDouble(element.getText().substring(1));
    }

    public static void selectDropDown(WebElement ele, String name) {
        select = new Select(ele);
        select.selectByVisibleText(name);
    }

    public static boolean verifyFile(String downloadPath, String fileName) {
        File filePath = new File(downloadPath);
        File[] filePathContents = filePath.listFiles();

        for (int i = 0; i < filePathContents.length; i++) {
            if (filePathContents[i].getName().equals(fileName)) {
                filePathContents[i].delete();
                return true;
            }
        }
        return false;
    }

}









