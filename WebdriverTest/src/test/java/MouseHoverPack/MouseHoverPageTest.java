package MouseHoverPack;
import Main.Package.MouseHoverPage;
import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.AbstractParallelWorker;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MouseHoverPageTest {
    private WebDriver driver;
    private MouseHoverPage mouseHoverPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/hovers");
        MouseHoverPage mouseHoverPage1 = new MouseHoverPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @Test

    public void MouseHoverTestUser1() throws Exception {

        WebElement User1Box = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/img[1]"));
        WebElement User2Box = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/img[1]"));
        WebElement User3Box = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[3]/img[1]"));
        WebElement PopUp1U1 = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
        WebElement PopUp2U1 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]"));
        WebElement PopUp1U2 = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]"));
        WebElement PopUp2U2 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]"));
        WebElement PopUp1U3 = driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]"));
        WebElement PopUp2U3 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[3]/div[1]/a[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(User1Box).perform();
        Thread.sleep(3000);

        boolean popUp1U1 = PopUp1U1.isDisplayed();
        boolean popUp2U1 = PopUp2U1.isDisplayed();
        boolean popUp1U2 = PopUp1U2.isDisplayed();
        boolean popUp2U2 = PopUp2U2.isDisplayed();
        boolean popUp1U3 = PopUp1U3.isDisplayed();
        boolean popUp2U3 = PopUp2U3.isDisplayed();


        if (popUp1U1) {
            System.out.println("User1: MouseHover PopUp1 is successfully functioning");
        } else {
            System.out.println("Fail");
        }
        if (popUp2U1) {
            System.out.println("User1: MouseHover PopUp2 is successfully functioning");
        } else {
            System.out.println("Fail");
        }

        if (popUp1U2) {
            System.out.println("User2: MouseHover PopUp1 is successfully functioning");
        } else {
            System.out.println("Fail");

        }
        if (popUp2U2) {
            System.out.println("User2: MouseHover PopUp2 is successfully functioning");
        } else {
            System.out.println("Fail");
        }
        if (popUp1U3) {
            System.out.println("User3: MouseHover PopUp1 is successfully functioning");
        } else {
            System.out.println("Fail");
        }
        if (popUp2U3) {
            System.out.println("User3: MouseHover PopUp2 is successfully functioning");
        } else {
            System.out.println("Fail");
        }

    }


@Test

public void PopUpTestUser2() throws Exception {

    WebElement User1Box = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/img[1]"));
    WebElement User2Box = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/img[1]"));
    WebElement User3Box = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[3]/img[1]"));
    WebElement PopUp1U1 = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
    WebElement PopUp2U1 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]"));
    WebElement PopUp1U2 = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]"));
    WebElement PopUp2U2 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]"));
    WebElement PopUp1U3 = driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]"));
    WebElement PopUp2U3 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[3]/div[1]/a[1]"));

    Actions actions = new Actions(driver);
    actions.moveToElement(User2Box).perform();
    Thread.sleep(3000);

    boolean popUp1U1 = PopUp1U1.isDisplayed();
    boolean popUp2U1 = PopUp2U1.isDisplayed();
    boolean popUp1U2 = PopUp1U2.isDisplayed();
    boolean popUp2U2 = PopUp2U2.isDisplayed();
    boolean popUp1U3 = PopUp1U3.isDisplayed();
    boolean popUp2U3 = PopUp2U3.isDisplayed();


    if (popUp1U1) {
        System.out.println("User1: MouseHover PopUp1 is successfully functioning");
    } else {
        System.out.println("Fail");
    }
    if (popUp2U1) {
        System.out.println("User1: MouseHover PopUp2 is successfully functioning");
    } else {
        System.out.println("Fail");
    }

    if (popUp1U2) {
        System.out.println("User2: MouseHover PopUp1 is successfully functioning");
    } else {
        System.out.println("Fail");

    }
    if (popUp2U2) {
        System.out.println("User2: MouseHover PopUp2 is successfully functioning");
    } else {
        System.out.println("Fail");
    }
    if (popUp1U3) {
        System.out.println("User3: MouseHover PopUp1 is successfully functioning");
    } else {
        System.out.println("Fail");
    }
    if (popUp2U3) {
        System.out.println("User3: MouseHover PopUp2 is successfully functioning");
    } else {
        System.out.println("Fail");
    }

}

    @Test

    public void PopUpTestUser3() throws Exception {

        WebElement User1Box = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/img[1]"));
        WebElement User2Box = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/img[1]"));
        WebElement User3Box = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[3]/img[1]"));
        WebElement PopUp1U1 = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
        WebElement PopUp2U1 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]"));
        WebElement PopUp1U2 = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]"));
        WebElement PopUp2U2 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]"));
        WebElement PopUp1U3 = driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]"));
        WebElement PopUp2U3 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[3]/div[1]/a[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(User3Box).perform();
        Thread.sleep(3000);

        boolean popUp1U1 = PopUp1U1.isDisplayed();
        boolean popUp2U1 = PopUp2U1.isDisplayed();
        boolean popUp1U2 = PopUp1U2.isDisplayed();
        boolean popUp2U2 = PopUp2U2.isDisplayed();
        boolean popUp1U3 = PopUp1U3.isDisplayed();
        boolean popUp2U3 = PopUp2U3.isDisplayed();


        if (popUp1U1) {
            System.out.println("User1: MouseHover PopUp1 is successfully functioning");
        } else {
            System.out.println("Fail");
        }
        if (popUp2U1) {
            System.out.println("User1: MouseHover PopUp2 is successfully functioning");
        } else {
            System.out.println("Fail");
        }

        if (popUp1U2) {
            System.out.println("User2: MouseHover PopUp1 is successfully functioning");
        } else {
            System.out.println("Fail");

        }
        if (popUp2U2) {
            System.out.println("User2: MouseHover PopUp2 is successfully functioning");
        } else {
            System.out.println("Fail");
        }
        if (popUp1U3) {
            System.out.println("User3: MouseHover PopUp1 is successfully functioning");
        } else {
            System.out.println("Fail");
        }
        if (popUp2U3) {
            System.out.println("User3: MouseHover PopUp2 is successfully functioning");
        } else {
            System.out.println("Fail");
        }

    }

    @After
    public void TearDown() {
        driver.quit();
    }
}


