
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class DynamicLoadingTest {

  private WebDriver driver;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
  }

  @Test
  public void testDynamicLoading() {
    driver.get("http://localhost:7080/dynamic_loading/2");

    WebElement startButton = driver.findElement(By.cssSelector("#start button"));
    startButton.click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

    WebElement helloWorldText = driver.findElement(By.cssSelector("#finish h4"));

    Assert.assertTrue(helloWorldText.isDisplayed());
  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
