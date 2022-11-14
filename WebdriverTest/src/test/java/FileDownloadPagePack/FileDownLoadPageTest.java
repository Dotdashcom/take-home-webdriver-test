package FileDownloadPagePack;
import Main.Package.FileDownloadPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FileDownLoadPageTest {
    private WebDriver driver;
    private FileDownloadPage fileDownloadPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/download");
        FileDownloadPage fileDownloadPage1 = new FileDownloadPage(driver);
    }

    @Test

    public void FileDownloadTest() throws Exception {
        driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]")).click();

Thread.sleep(5000);
        File fileLocation = new File("C:\\Users\\kurdb\\Downloads\\");
        File[] totalFiles = fileLocation.listFiles();

        for (File file : totalFiles) {
            if (file.getName().equals("some-file.txt")) {
                System.out.println("File is Downloaded");
            } else {
                System.out.println("Fail");
            }

        }

    }

@After
public void TearDown() {
    driver.quit();
}
}

