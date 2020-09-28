package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

public class JavascriptUtilities {

    public static Boolean isVisibleInViewport(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        return (Boolean) executor.executeScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , element);
    }



    public static void scrollDownToBottomPage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }


    public static void scrollDownByPixels(WebDriver driver, int pixel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixel + ")", "");
    }

    public static List<LogEntry> getBrowserConsoleLogs(WebDriver driver)
    {
        LogEntries log= driver.manage().logs().get("browser");
        List<LogEntry> logs=log.getAll();
        return logs;
    }
}
