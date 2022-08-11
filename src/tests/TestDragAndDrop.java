
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;

public class TestDragAndDrop {

  WebDriver driver;

  @BeforeSuite
  public void initialize() {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void testDragAndDrop() throws InterruptedException, AWTException {
    String url = "http://localhost:7080/drag_and_drop";
    driver.get(url);

    WebElement boxA = driver.findElement(By.xpath("//*[@id=\'column-a\']"));
    WebElement boxB = driver.findElement(By.xpath("//*[@id=\'column-b\']"));


    Point p = MouseInfo.getPointerInfo().getLocation();
    int x = p.x;
    int y = p.y;
    System.out.println(x);
    System.out.println(x);
    Thread.sleep(2000);
    Actions dragDropAction= new Actions(driver);

    Robot robot = new Robot();

    //drag

    robot.mouseMove(357, 357);


    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    dragDropAction.dragAndDrop(boxA, boxB).perform();

    Thread.sleep(2000);
    System.out.println(boxA.getText());

  }

  @AfterMethod
  public void  tearDown() {
    driver.quit();
  }

}
