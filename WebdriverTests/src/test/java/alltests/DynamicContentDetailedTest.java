// More detailed version for test:
//        Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload.


package alltests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DynamicContentDetailedTest {
    String driverPath =  "./src/drivers/chromedriver.exe";
    //    String driverPath = ("user.dir" + "/drivers/chromedriver.exe");
    public WebDriver driver;

    @BeforeMethod
    public void launchBrowser() {
        System.out.println("launching browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.close();
    }

    @Test
    public void dynamicContentDetailed() throws IOException {
        System.out.println("Running Dynamic Content (Detailed) test method");
        //Open test page
        driver.get("http://localhost:7080/dynamic_content");

        // before refresh save texts of each paragraph
        String textBefore1 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[1]")).getText();
        String textBefore2 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[2]")).getText();
        String textBefore3 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();

        // before refresh wait and take screenshots of each image
        WebElement imageBefore1 = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "(//div[@class='large-2 columns'])[1]/img")));
        Screenshot screenshotBefore1 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).
                takeScreenshot(driver, imageBefore1);

        WebElement imageBefore2 = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "(//div[@class='large-2 columns'])[2]/img")));
        Screenshot screenshotBefore2 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).
                takeScreenshot(driver, imageBefore2);

        WebElement imageBefore3 = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "(//div[@class='large-2 columns'])[3]/img")));
        Screenshot screenshotBefore3 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).
                takeScreenshot(driver, imageBefore3);

        // save the screenshots to files
        try {
            ImageIO.write(screenshotBefore1.getImage(), "jpg", new File(
                    "./src/test/screenshots/screenshotBefore1.jpg"));
            ImageIO.write(screenshotBefore2.getImage(), "jpg", new File(
                    "./src/test/screenshots/screenshotBefore2.jpg"));
            ImageIO.write(screenshotBefore3.getImage(), "jpg", new File(
                    "./src/test/screenshots/screenshotBefore3.jpg"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int refreshCount;
        // refresh the page a couple of times
        for (int i = 1; i <= 2; i++) {

            refreshCount = i;
            driver.navigate().refresh();

            // after refresh save texts of each paragraph
            String textAfter1 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[1]"))
                    .getText();
            String textAfter2 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[2]"))
                    .getText();
            String textAfter3 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]"))
                    .getText();

            // asserts that the texts content changes on each refresh
            try {
                Assert.assertNotEquals(textBefore1, textAfter1);
            } catch (AssertionError error) {
                System.out.println("Text on top paragraph has not changed after refresh #" +refreshCount +" !");
            }

            try {
                Assert.assertNotEquals(textBefore2, textAfter2);
            } catch (AssertionError error) {
                System.out.println("Text in the middle paragraph has not changed after refresh #" + refreshCount + " !");
            }
            try {
                Assert.assertNotEquals(textBefore3, textAfter3);
            } catch (AssertionError error) {
                System.out.println("Text at the bottom paragraph has not changed after refresh #" +refreshCount +" !");
            }

            // after refresh, wait and take screenshots of each image
            WebElement imageAfter1 = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                            "(//div[@class='large-2 columns'])[1]/img")));
            Screenshot screenshotAfter1 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).
                    takeScreenshot(driver, imageAfter1);

            WebElement imageAfter2 = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                            "(//div[@class='large-2 columns'])[2]/img")));
            Screenshot screenshotAfter2 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).
                    takeScreenshot(driver, imageAfter2);

            WebElement imageAfter3 = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                            "(//div[@class='large-2 columns'])[3]/img")));
            Screenshot screenshotAfter3 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).
                    takeScreenshot(driver, imageAfter3);

            // save the screenshots to files
            try {
                ImageIO.write(screenshotAfter1.getImage(), "jpg", new File(
                        "./src/test/screenshots/screenshotAfter1.jpg"));
                ImageIO.write(screenshotAfter2.getImage(), "jpg", new File(
                        "./src/test/screenshots/screenshotAfter2.jpg"));
                ImageIO.write(screenshotAfter3.getImage(), "jpg", new File(
                        "./src/test/screenshots/screenshotAfter3.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // read saved screenshots of images
            BufferedImage buffBefore1 = ImageIO.read(new File(
                    "./src/test/screenshots/screenshotBefore1.jpg"));
            BufferedImage buffBefore2 = ImageIO.read(new File(
                    "./src/test/screenshots/screenshotBefore2.jpg"));
            BufferedImage buffBefore3 = ImageIO.read(new File(
                    "./src/test/screenshots/screenshotBefore3.jpg"));

            BufferedImage buffAfter1 = ImageIO.read(new File(
                    "./src/test/screenshots/screenshotAfter1.jpg"));
            BufferedImage buffAfter2 = ImageIO.read(new File(
                    "./src/test/screenshots/screenshotAfter2.jpg"));
            BufferedImage buffAfter3 = ImageIO.read(new File(
                    "./src/test/screenshots/screenshotAfter3.jpg"));

            // create ImageDiffer objects
            ImageDiffer imgDiff1 = new ImageDiffer();
            ImageDiffer imgDiff2 = new ImageDiffer();
            ImageDiffer imgDiff3 = new ImageDiffer();

            // get differences for images taken before and after refresh
            ImageDiff diff1 = imgDiff1.makeDiff(buffBefore1, buffAfter1);
            ImageDiff diff2 = imgDiff2.makeDiff(buffBefore1, buffAfter1);
            ImageDiff diff3 = imgDiff3.makeDiff(buffBefore1, buffAfter1);

            // asserts that the images content changes on each refresh
                try {
                    Assert.assertTrue(diff1.hasDiff());
                    } catch (AssertionError err) {
                    System.out.println("Top Image has not changed after refresh #" +refreshCount +" !");
                }

                try {
                    Assert.assertTrue(diff2.hasDiff());
                } catch (AssertionError err) {
                System.out.println("Middle Image has not changed after refresh #" +refreshCount +" !");
                }

                try {
                    Assert.assertTrue(diff3.hasDiff());
                } catch (AssertionError err) {
                System.out.println("Bottom Image has not changed after refresh #" +refreshCount +" !");
                }

            // rewrite texts saved in this refresh to be the texts before next refresh
            textBefore1 = textAfter1;
            textBefore2 = textAfter2;
            textBefore3 = textAfter3;

            // rewrite images saved in this refresh to be images before next refresh, excluding last refresh cycle
            if (i < 2) {
                try {
                    ImageIO.write(screenshotAfter1.getImage(), "jpg", new File(
                            "./src/test/screenshots/screenshotBefore1.jpg"));
                    ImageIO.write(screenshotAfter2.getImage(), "jpg", new File(
                            "./src/test/screenshots/screenshotBefore2.jpg"));
                    ImageIO.write(screenshotAfter3.getImage(), "jpg", new File(
                            "./src/test/screenshots/screenshotBefore3.jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }

}
