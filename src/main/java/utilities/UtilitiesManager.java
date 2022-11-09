package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UtilitiesManager {

    public static boolean ExpectedConditions(By ele, String type) {

        boolean result = false;
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        switch (type) {
            case "SELECTED":
                result = wait.until(ExpectedConditions.elementSelectionStateToBe(ele, true));
                break;
            case "UNSELECTED":
                result = wait.until(ExpectedConditions.elementSelectionStateToBe(ele, false));
                break;
            case "DISPLAYED":
                wait.until(ExpectedConditions.presenceOfElementLocated(ele));
                result = true;
                break;
            case "INVISIBLE":
                result = wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
                break;
            default:
                break;
        }
        return result;
    }

    public static boolean ExpectedConditions(WebElement ele, String type) {

        boolean result = false;
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        switch (type) {
            case "SELECTED":
                result = wait.until(ExpectedConditions.elementSelectionStateToBe(ele, true));
                break;
            case "UNSELECTED":
                result = wait.until(ExpectedConditions.elementSelectionStateToBe(ele, false));
                break;
            default:
                break;
        }
        return result;
    }

    public static WebElement FindElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public static List<WebElement> FindElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public static String ContextMenuClick(By by) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.contextClick(FindElement(by)).build().perform();
        Alert alert = DriverManager.getDriver().switchTo().alert();
        String textEdit = alert.getText();
        DriverManager.getDriver().switchTo().alert().accept();
        return textEdit;

    }

    public static void jsScroller() {
        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight);", "");

    }

}
