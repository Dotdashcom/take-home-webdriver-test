package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class HelpfulMethods {
    public static void staticWait(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setWaitTime() {
        Driver.GetDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    public static void clickWithWait(WebElement webElement) {

        Wait wait = new FluentWait(Driver.GetDriver())
                .withTimeout(Duration.ofSeconds(15)) //wait for 15 seconds
                .pollingEvery(Duration.ofMillis(800))//polling > it will check for that elements for > 5
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class);

        WebElement element = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> webElement);

        try {
            element.click();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.GetDriver(), Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void waitForPageTitle(String pageTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.GetDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleIs(pageTitle));
    }

    public static List<String> getListOfString(List<WebElement> listOfWebElements) {
        List<String> listOfStrings = new ArrayList<>();
        for (WebElement element : listOfWebElements) {
            String value = element.getText().trim();
            //if there is no text
            //do not add this blank text into list
            if (value.length() > 0) {
                listOfStrings.add(value);
            }
        }
        return listOfStrings;
    }

    public boolean switchWindow() {
        String parent_win = Driver.GetDriver().getWindowHandle();
        Set<String> windows = Driver.GetDriver().getWindowHandles();
        boolean flag = true;
        for (String winID : windows) {

            if (!winID.equals(parent_win)) {
                Driver.GetDriver().switchTo().window(winID);
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    public void scrollToElement(WebElement element) {

        JavascriptExecutor js = ((JavascriptExecutor) Driver.GetDriver());
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public void switchFrame(String frameXpath) {
        Driver.GetDriver().switchTo().frame(Driver.GetDriver().findElement(By.xpath(frameXpath)));
    }


    private static WebDriverWait wait = new WebDriverWait(Driver.GetDriver(), Duration.ofSeconds(20));

    public static void enterText(WebElement element, String text) {
        waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        wait.until(ExpectedConditions.attributeToBe(element, "value", text));
        System.out.println("Entering text: " + text);
    }

    public static void getDownloadedFile(String fileName) {
        File fileLocation = new File("/Users/seraytugcu/Downloads/");
        System.out.println(fileLocation);
        File[] Allfile = fileLocation.listFiles();
        assert Allfile != null;
        for (File file : Allfile) {
            if (file.getName().equals(fileName)) {
                System.out.println("Downloaded");
            }
        }
    }
    public static void takeScreenShot(String testName) throws IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String timeFormat = DateTimeFormatter.ofPattern("MMM-dd-yyyy_HH-mm").format(localDateTime);
        TakesScreenshot screenshot = ((TakesScreenshot) Driver.GetDriver());
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(testName + "_" + timeFormat + ".png");
        FileUtils.copyFile(file, destination);
    }
}

