package OpenNewTabPack;
import Main.Package.OpenNewTabPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.UrlPath;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class OpenNewTabPageTest {
    private WebDriver driver;
    private OpenNewTabPage OpenNewTabPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/windows");
        OpenNewTabPage openNewTabPage = new OpenNewTabPage(driver);
    }

    @Test

    public void OpenNewTabTest() throws Exception {
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        String MainTab = driver.getWindowHandle();

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        Thread.sleep(5000);


        WebElement ElementOfNewTab = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]"));
        String NewTabText = ElementOfNewTab.getText();
        Assert.assertEquals("New Window", NewTabText);
        boolean NewTabElement = ElementOfNewTab.isDisplayed();
        if (NewTabElement) {
            System.out.println("New Tab is Opened and Elements are Displayed");

        } else {
            System.out.println("Sorry, Fail!");
        }

    }
    @After
        public void TearDown() {
            driver.quit();
        }
    }



