package library;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumLibrary extends BrowserFactory {
    public void clickOnElement(WebElement element) {
        element.click();
    }

    public boolean isElementSelected(WebElement element) {
        boolean flag = element.isSelected();
        if (flag)
            System.out.println("***********The WebElement is Selected ************");
        else
            System.out.println(" ***********The WebElement is not Selected ********");
        return flag;
    }

    public boolean isElementEnable(WebElement element)
    {
        boolean flag = element.isEnabled();
        return flag;
    }

    public boolean isElementDisplayed(WebElement element) {
        boolean flag = false;
        try {
           flag =  element.isDisplayed();
            if (flag)
                System.out.println("********The WebElement is Present ************");
            else
                System.out.println("***********The WebElement is not Present ***************");
        } catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public WebElement selectAnWebElementFromList(List<WebElement> webElements, String key) {
        for (WebElement webElement : webElements) {
            if (webElement.getText().equals(key))
                return webElement;
        }
        return null;  // if the list is empty
    }

    public void enterTextIntoTextBox(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void contextClickAction(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).contextClick().perform();
    }

    public void clickOkOnAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("*********Successfully Handle the Alert Popup*************");
    }

    public void dragAndDropActions(WebElement source, WebElement target) {
        Actions action = new Actions(driver);
        action.dragAndDrop(source, target);
    }


//    private void waitUntilSelectOptionsPopulated(final Select select){
//        new FluentWait<WebDriver>(driver)
//                .withTimeout(60, TimeUnit.SECONDS)
//                .pollingEvery(10, TimeUnit.MILLISECONDS)
//                .until(new Predicate<WebDriver>() {
//                    public boolean apply(WebDriver d) {
//                        return (select.getOptions().size() > 1);
//                    }
//                });
//    }

    public void selectFromDropDown(WebElement element, String name) throws InterruptedException {

            Select select = new Select(element);
            if (select.isMultiple()) {
                List<WebElement> dropdownElements = select.getOptions();
                for (WebElement options : dropdownElements) {
                    if (options.getAccessibleName().equals(name)) {
                        Thread.sleep(2000);
                        options.click();
                    } else
                        System.out.println("********There's no such Element ***********");
                }
            }
    }

    public void scrolldown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }
    public void mouseHover(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public String extractJSLogsInfo(){
        StringBuilder message = new StringBuilder();
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for(LogEntry entry : logEntries){
            message.append(entry.getMessage());
        }

        return message.toString();

    }


}