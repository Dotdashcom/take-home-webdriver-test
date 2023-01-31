package Pages;

import WebdriverFactory.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class All_Pages {

    public static final Integer WAIT_TIME = 60;
    private static final Logger LOGGER = LoggerFactory.getLogger(All_Pages.class);
    private static final String LOGIN_URL = "http://localhost:7080/login";
    private static final String Checkbox_URL = "http://localhost:7080/checkboxes";
    private static final String DragNDropURL = "http://localhost:7080/drag_and_drop";
    private static final String DropDownURL = "http://localhost:7080/dropdown";
    private static final String RereshURL = "http://localhost:7080/dynamic_content";
    private static final String mouseHover="http://localhost:7080/hovers";
    private static final String IframeURL="http://localhost:7080/iframe";
    private static final String Notifications="http://localhost:7080/notification_message_rendered";
    private static final String JSErrorURL="http://localhost:7080/javascript_error";
    private static final String JSALerrtsURL="http://localhost:7080/javascript_alerts";
    private static final String DynamicCOntrolURL="http://localhost:7080/dynamic_controls";
    private static final String FileDwonloadRL="http://localhost:7080/download";
    private static final String FloatingMenuURL="http://localhost:7080/floating_menu";
    private static final String DynamicLoading="http://localhost:7080/dynamic_loading/2";
    private static final String NewTabURL="http://localhost:7080/windows";
    private static final String ContextBoxURL = "http://localhost:7080/context_menu";
    private static final String FileUploadRL="http://localhost:7080/upload";
    private static final String LOGIN_USERNAME = "tomsmith";
    private static final String LOGIN_PASSWORD = "SuperSecretPassword!";
    private static final String LOGIN_PASSWORD_incorrect = "SuperSecretPassword";

    public static void setText(By elementLocator, String text) {
        WebDriver driver = WebDriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        WebElement element = driver.findElement(elementLocator);
        element.clear();
        element.sendKeys(text);
    }

    public static void click(By elementLocator) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        WebElement element = driver.findElement(elementLocator);
        element.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        try {
            executor.executeScript("arguments[0].click();", element);
        } catch (StaleElementReferenceException ser) {
            LOGGER.info("Stale element exception waiting before clicking again");
            Thread.sleep(5000);
            executor.executeScript("arguments[0].click();", element);
        }
    }

    public static boolean isSelectedCheckbox(By elementLocator) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        WebElement element = driver.findElement(elementLocator);
        boolean selection = element.isSelected();
        return selection;
    }

    public static void login_correct() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(LOGIN_URL);
        setText(By.xpath("//input[@id='username']"), LOGIN_USERNAME);
        setText(By.xpath("//input[@id='password']"), LOGIN_PASSWORD);
        click(By.xpath("//form//button/child::i"));

    }

    public static void openCheckBoxUrl() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(Checkbox_URL);
    }
     public static void openNewTab() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(NewTabURL);
    }
    public static void openNotifications() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(Notifications);
    }
    public static void openContextBoxUrl() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(ContextBoxURL);
    }

        public static void openDynamicLoading() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(DynamicLoading);
    }

    public static void openDragAndDrop() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(DragNDropURL);
    }
    public static void openFloatingMenuURL() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(FloatingMenuURL);
    }

    public static void openDynamicCOntrolURL() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(DynamicCOntrolURL);
    }

    public static void openDropdownURL() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(DropDownURL);
    }

    public static void openRereshURL() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(RereshURL);}

     public static void openJSErrorURL() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(JSErrorURL);}

    public static void openFileDwonloadRL() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(FileDwonloadRL);}

     public static void openIframeURL() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(IframeURL);}

      public static void openmouseHover() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(mouseHover);}

        public static void login_incorrect () throws InterruptedException {
            WebDriver driver = WebDriverFactory.getDriver();
            driver.get(LOGIN_URL);
            setText(By.xpath("//input[@id='username']"), LOGIN_USERNAME);
            setText(By.xpath("//input[@id='password']"), LOGIN_PASSWORD_incorrect);
            click(By.xpath("//form//button/child::i"));

        }

        public static void logout () throws InterruptedException {
            Thread.sleep(5000);
            click(By.xpath("//*[@id=\'content']/div/a/i"));

        }
        public static boolean verify (By elementLocator){
            try {
                WebDriver driver = WebDriverFactory.getDriver();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
                wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
                return true;
            } catch (TimeoutException e) {
                throw new IllegalStateException("Element Not Found!", e);

            }
        }

        public static String getText (By elementLocator){
            WebDriver driver = WebDriverFactory.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            return driver.findElement(elementLocator).getText();
        }
        public static void RightClick (By elementLocator){
            WebDriver driver = WebDriverFactory.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            Actions actions = new Actions(driver);
            actions.contextClick(driver.findElement(elementLocator)).perform();

        }
    public static void openFileUploadRL() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(FileUploadRL);}

       public static void openJSALerrtsURL() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(JSALerrtsURL);}
        public static void DragDropTest (By elementLocator1, By elementLocator2){
            WebDriver driver = WebDriverFactory.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator1));
            Actions actions = new Actions(driver);
            actions.clickAndHold(driver.findElement(elementLocator1)).moveToElement(driver.findElement(elementLocator2)).release().build().perform();
            //actions.dragAndDrop(driver.findElement(elementLocator1),driver.findElement(elementLocator1)).build().perform();
            // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        public static void select (By elementLocator, String value){
            WebDriver driver = WebDriverFactory.getDriver();
            Select dropdown = new Select(driver.findElement(elementLocator));
            dropdown.selectByValue(value);

        }
        public static void refreshBrowser () {
            WebDriver driver = WebDriverFactory.getDriver();
            driver.navigate().refresh();
        }

    public static String getSRC (By elementLocator){
        WebDriver driver = WebDriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return driver.findElement(elementLocator).getAttribute("src");
    }

    public static void scrollBottom() {
        WebDriver driver = WebDriverFactory.getDriver();
        JavascriptExecutor jsExecuter = (JavascriptExecutor) driver;
        jsExecuter.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public static boolean isDisplayed(By elementLocator) {
        WebDriver driver = WebDriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return driver.findElement(elementLocator).isDisplayed();
    }

    public static boolean isEnabled(By elementLocator) {
        WebDriver driver = WebDriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return driver.findElement(elementLocator).isEnabled();
    }
    public static void setTextInIframe(By elementLocator, String text) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver();
        //verify(By.id("mce_0_ifr"));
        driver.switchTo().frame(0);
        click(By.xpath("//*[local-name()='svg' and @fill-rule='evenodd']/*[local-name()='path']"));
        setText(elementLocator, text);
        try {
            driver.switchTo().defaultContent();
        } catch (WebDriverException wde) {
        }
    }
    public static void mouseHoverTest(By elementLocator) {
        WebDriver driver = WebDriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(elementLocator)).build().perform();

    }



    }
