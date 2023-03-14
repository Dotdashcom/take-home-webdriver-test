package testPackages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class CheckBoxesTest extends BaseTest {
  
  private WebDriver driver;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("http://localhost:7080/checkboxes");
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testCheckboxes() {
    WebElement checkbox1 = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));
    checkbox1.click();
    Assert.assertTrue(checkbox1.isSelected());
    WebElement checkbox2 = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));
    checkbox1.click();
    checkbox2.click();
    Assert.assertFalse(checkbox1.isSelected());
    Assert.assertTrue(checkbox2.isSelected());
  }
}
