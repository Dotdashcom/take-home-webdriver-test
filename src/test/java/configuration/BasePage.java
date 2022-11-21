package configuration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;

public class BasePage {

    public static WebDriver driver;
    public String URL;
    public Actions actions;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        String os = System.getProperty("os.name");

        if (os.equalsIgnoreCase("mac os x")) {
            System.setProperty("webdriver.chrome.driver", "./src/test/java/drivers/windows/chromedriver");
        } else if (os.equalsIgnoreCase("linux")) {
            System.setProperty("webdriver.chrome.driver", "./src/test/java/drivers/linux/chromedriver");
        }

        driver = new ChromeDriver();
        getURL();
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void getURL() {
        driver.get(Objects.requireNonNullElse(URL, "http://localhost:7080/"));
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {
//        driver.close();
//        driver.quit();
    }

    public void selectOptionByText(String text) {
        driver.findElement(By.xpath("//a[text()='" + text + "']")).click();
    }

    public void waitForElement(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElement(By selector) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(selector)));
    }

    public void waitForElementToDisappear(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean elementIsDisplayed(WebElement element) {
        try {
            waitForElement(element);
            return true;
        } catch (NotFoundException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean elementIsPresent(WebElement element) {
        try {
            element.click();
            return true;
        } catch (NotFoundException | StaleElementReferenceException e) {
            return false;
        }
    }

    public void assertTitleIsDisplayed(String title) {

        try {
            Assert.assertTrue(elementIsDisplayed(
                    driver.findElement(By.xpath("//h3[text()='" + title + "']"))));
        } catch (NoSuchElementException e) {
            elementIsDisplayed(
                    driver.findElement(By.xpath("//h4[text()='" + title + "']")));
        }

    }

    public void assertTextDisplayed(String text) {
        Assert.assertTrue(elementIsDisplayed(driver.findElement(By.xpath("//p[text()='" + text + "']"))));
    }

    public void assertTitleIsNotDisplayed(String title) {
        Assert.assertEquals(driver.findElements(By.xpath("//h3[text()='" + title + "']")).size(), 0);
    }

    public void assertAlert(String expectedAlert) {
        String actualAlert = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlert, actualAlert);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void typeOnAlert(String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.sendKeys(text);
    }

    public void assertTextOnAlertIs(String text) {
        Assert.assertEquals(
                driver.switchTo().alert().getText(), text);
    }

    public void rightClickOn(WebElement element) {
        actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public void dragAndDrop(WebElement elementToMove, WebElement destination) {
        actions = new Actions(driver);
        actions.dragAndDrop(elementToMove, destination).build().perform();
    }

    public void clickOnButtonByText(String text) {
        By selector = By.xpath("//button[text()='" + text + "']");
        waitForElement(selector);
        driver.findElement(selector).click();
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }

    public void cleanTextArea(WebElement element) {
        element.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        element.sendKeys(Keys.BACK_SPACE);
    }

    public void hoverElement(WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void moveToWindow(String expectedTitle){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getTitle(),  expectedTitle);
    }
}
