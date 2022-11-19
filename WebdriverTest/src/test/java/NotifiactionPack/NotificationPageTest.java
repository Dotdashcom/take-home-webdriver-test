package NotifiactionPack;
import Main.Package.NotificationPage;
import Main.Package.OpenNewTabPage;
import bsh.Console;
import bsh.util.JConsole;
import com.google.common.util.concurrent.UncaughtExceptionHandlers;
import org.asynchttpclient.util.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.*;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.ErrorManager;
import java.util.logging.Level;

public class NotificationPageTest {
    private WebDriver driver;
    private NotificationPage notificationPage;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/notification_message_rendered");
        NotificationPage notificationPage = new NotificationPage(driver);

    }

    @Test

    public void NotificationTest() throws Exception {
        String Message1 = ("Action unsuccesful, please try again\n" +
                "×");
        String Message2 = ("Action successful\n" +
                "×");


        int i = 0;
        for (i = 0; i < 30; i++) {

            driver.findElement(By.xpath("//a[contains(text(),'Click here')]")).click();
            Thread.sleep(500);
            System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
            if (Message1.equals(driver.findElement(By.xpath("//div[@id='flash']")).getText())) {
                System.out.println("Text message 1 Asserted");
            } else {
                System.out.println("---------------");
                if (Message2.equals(driver.findElement(By.xpath("//div[@id='flash']")).getText())) {
                    System.out.println("Text message 2 Asserted");
                } else {
                }
                System.out.println("-----------");

            }

        }

    }

            @After
            public void TearDown() {
                driver.quit();
            }

        }

