package actions;

import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ActionHelper {
    private static String parentWindow;

    public static void waitUntilElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitUntilElementInVisible(By by) {
        goToSleep(1000);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static WebElement findElement(By by) {
        waitUntilElementVisible(by);
        return DriverManager.getDriver().findElement(by);
    }

    public static List<WebElement> findElements(By by) {
        waitUntilElementVisible(by);
        return DriverManager.getDriver().findElements(by);
    }

    public static void openUrl(String url) {
        DriverManager.getDriver().get(url);
    }

    public static void fill(By by, String value) {
        findElement(by).sendKeys(value);
    }

    public static void click(By by) {
        findElement(by).click();
    }

    public static String getText(By by) {
        return findElement(by).getText();
    }

    public static String getAttribute(By by, String attributeName) {
        return findElement(by).getAttribute(attributeName);
    }

    public static boolean isPresent(By by) {
        return DriverManager.getDriver().findElements(by).size() > 0 && DriverManager.getDriver().findElement(by).isDisplayed();
    }

    public static boolean isSelected(By by) {
        return findElement(by).isSelected();
    }

    public static void contextClick(By by) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.contextClick(findElement(by)).build().perform();
    }

    public static String getAlertText() {
        return DriverManager.getDriver().switchTo().alert().getText();
    }

    public static void fillAlertText(String value) {
        DriverManager.getDriver().switchTo().alert().sendKeys(value);
    }

    public static void alertAccept() {
        DriverManager.getDriver().switchTo().alert().accept();
    }

    public static void alertDismiss() {
        DriverManager.getDriver().switchTo().alert().dismiss();
    }

    public static void dragAndDrop(By from, By to) {
        Actions actions = new Actions(DriverManager.getDriver());
        WebElement source = findElement(from);
        WebElement target = findElement(to);
        actions.dragAndDrop(source, target).build().perform();
    }

    public static void selectFromDD(By by, String value) {
        new Select(findElement(by)).selectByVisibleText(value);
    }

    public static String getSelectedOption(By by) {
        return new Select(findElement(by)).getFirstSelectedOption().getText();
    }

    public static List<String> getAllSelectedOptions(By by) {
        List<String> output = new ArrayList<>();
        List<WebElement> list = new Select(findElement(by)).getAllSelectedOptions();
        for (WebElement element : list) {
            output.add(element.getText());
        }
        return output;
    }

    public static void refresh() {
        DriverManager.getDriver().navigate().refresh();
    }

    public static void scrollPageToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void switchToFrame(String id) {
        DriverManager.getDriver().switchTo().frame(id);
    }

    public static void mouseHoverElement(By by) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(findElement(by)).build().perform();
    }

    public static void switchToNewWindow() {
        parentWindow = DriverManager.getDriver().getWindowHandle();
        Set<String> handles = DriverManager.getDriver().getWindowHandles();
        for (String handle : handles) {
            DriverManager.getDriver().switchTo().window(handle);
        }
    }

    public static boolean isEnabled(By by) {
        return findElement(by).isEnabled();
    }

    public static void goToSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {

        }
    }

    public static void closeWindow() {
        DriverManager.getDriver().close();
    }

    public static void switchToParentWindow() {
        DriverManager.getDriver().switchTo().window(parentWindow);
    }

    public static String getBrowserLogs() {
        StringBuilder output = new StringBuilder();
        LogEntries logEntries = DriverManager.getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            output.append(logEntry.getMessage());
        }

        return output.toString();

    }
}


