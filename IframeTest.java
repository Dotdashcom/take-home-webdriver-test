package testPackages;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeTest {

  private WebDriver driver;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    driver = new ChromeDriver();
  }

  @Test
  public void testIframe() {
    driver.get("http://localhost:7080/iframe");

    WebElement iframe = driver.findElement(By.tagName("iframe"));
    driver.switchTo().frame(iframe);

    WebElement textField = driver.findElement(By.id("tinymce"));
    textField.clear();
    textField.sendKeys("Hello, World!");

    driver.switchTo().defaultContent();

    driver.switchTo().frame(iframe);

    String typedText = textField.getText();
    Assert.assertEquals("Hello, World!", typedText);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
