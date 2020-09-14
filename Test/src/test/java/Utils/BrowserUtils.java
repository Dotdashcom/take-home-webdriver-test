package Utils;

import org.junit.Assert;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BrowserUtils {
    static WebDriver driver = Driver.getDriver("chrome");
    static WebDriverWait wait = new WebDriverWait(driver, 30);
    static Actions actions = new Actions(driver);
    static Select select;
    static JavascriptExecutor js = (JavascriptExecutor) driver;








    public static void sendKeys(WebElement element, String key) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(key);
    }

    public static void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public static String getElementText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public static void rightClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.contextClick(element).build().perform();
    }

    public static String getAlertText() {
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public static void dragAndDrop(WebElement source, WebElement target) {
        wait.until(ExpectedConditions.visibilityOf(source));
        wait.until(ExpectedConditions.visibilityOf(target));
        actions.dragAndDrop(source, target).build().perform();
    }

    public static Point getElementLocation(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getLocation();
    }

    public static void selectDropDown(WebElement element, int index) {
        wait.until(ExpectedConditions.visibilityOf(element));
        select = new Select(element);
        select.selectByIndex(index);
    }

    public static boolean elementIsSelected(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isSelected();
    }

    public static List<String> getElementsText(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements.stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public static int getFileName() throws IOException {
        File downloads = new File("/Users/aibek/Downloads");
        Stream<Path> file = Files.list(downloads.toPath());
        List<Path> collect = file.filter(filesNames -> filesNames.getFileName().
                toString().equals("some-file.txt")).collect(Collectors.toList());
        return collect.size();
    }

    public  static void scrollDownMenu(String y){
        js.executeScript("window.scrollBy(0,"+y+")");
    }

    public static boolean elementIsVisible(WebElement element) {
        return element.isDisplayed();
    }

    public static String enterTextInFrameElement(WebElement frame, WebElement element, String text) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        driver.switchTo().parentFrame();
        wait.until(ExpectedConditions.visibilityOf(element));
        for(int i=0; i<25; i++){
            element.sendKeys(Keys.DELETE);
        }
        element.sendKeys(text);
        String textNeeded = element.getText();
        driver.switchTo().defaultContent();
        return textNeeded;
    }

    public static WebElement hoverOver(WebElement element){
        actions.moveToElement(element).perform();
        return element;
    }

      public static  void  jSAlertTap (){
        driver.switchTo().alert().accept();


      }

       public static  void jSAlertSenKeys (String text) {
           driver.switchTo().alert().sendKeys(text);
       }

      public static  void switchToWindow(){
          Set<String> windowHandles = driver.getWindowHandles();
          Iterator<String> iterator = windowHandles.iterator();
          String currentWindowHandle = driver.getWindowHandle();
          while (iterator.hasNext()){
              String newHandle = iterator.next();
              if(!newHandle.equalsIgnoreCase(currentWindowHandle)){
                  driver.switchTo().window(newHandle);

              }
          }
      }
      public static void notificationMessageAlert(WebElement element, String messageText) {
          wait.until(ExpectedConditions.visibilityOf(element));
          if (!element.getText().equalsIgnoreCase("Action successful")) {
              element.click();
          } else if (element.getText().equalsIgnoreCase("Action unsuccesful, please try again")){
              element.click();
              Assert.assertEquals(messageText, element.getText());

      }
}

}