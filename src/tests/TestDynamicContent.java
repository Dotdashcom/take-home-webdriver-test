
package tests;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.Assert;
    import org.testng.annotations.AfterMethod;
    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.Test;

    import static org.testng.AssertJUnit.assertTrue;

public class TestDynamicContent {

  WebDriver driver;

  @BeforeMethod
  public void initialize() {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void testDynamicContent() throws InterruptedException {
    String url = "http://localhost:7080/dynamic_content";
    driver.get(url);


   //verify content of first paragraph after refresh
    String content1 = driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]")).getText();


    //*[@id="content"]/div[1]/div[2]
    driver.navigate().refresh();
    String content2 = driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]")).getText();
    System.out.println(content1);
    System.out.println(content2);
    Assert.assertNotEquals(content1,content2);

    //verify content of second paragraph after refresh
    String contentParagraph2 = driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]")).getText();
    Thread.sleep(1000);
    driver.navigate().refresh();
    String contentParagraph2AfterRefresh = driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]")).getText();
    Assert.assertNotEquals(contentParagraph2,contentParagraph2AfterRefresh);

   //verify content of third paragraph after refresh
    String contentParagraph3 = driver.findElement(By.xpath("//*[@id=\'content\']/div[3]/div[2]")).getText();
    driver.navigate().refresh();
    String contentParagraph3AfterRefresh = driver.findElement(By.xpath("//*[@id=\'content\']/div[3]/div[2]")).getText();
    Assert.assertNotEquals(contentParagraph3,contentParagraph3AfterRefresh);



  }


  @AfterMethod
  public void  tearDown() {
    driver.close();
  }
}
