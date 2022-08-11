package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestNotificationMessage {

  WebDriver driver;

  @BeforeMethod
  public void initialize() {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void testNotificationMessage() throws InterruptedException {
    String url = "http://localhost:7080/notification_message_rendered";
    driver.get(url);

    String msg1 = "Action successful";
    String msg2 = "Action unsuccesful, please try again";
    String msg3 = "Action unsuccessful";


    for(int i=1;i<4;i++) {

      driver.findElement(By.xpath("//*[@id='content']/div/p/a")).click();
      String notificationMsg1 = driver.findElement(By.xpath("//*[@id='flash']")).getText();
      System.out.println(notificationMsg1);
      Thread.sleep(1000);
      assertTrue(notificationMsg1.contains(msg1) || notificationMsg1.contains(msg2) || notificationMsg1.contains(msg3));

    }


  }

  @AfterMethod
  public void  tearDown() {
    driver.close();
  }
}
