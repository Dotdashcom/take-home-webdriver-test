import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Internet_Test {

   public static WebDriver driver;

    @BeforeClass
    public void Setup() {
        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path + "\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:7080");
        driver.manage().window().maximize();
    }

    @Test
    public void login_success() {
        driver.get("http://localhost:7080/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String title = driver.getTitle();
        //System.out.println(title);
        Assert.assertEquals("The Internet", title);
        if (title.equals("The Internet")) {
            System.out.println("Login is successful");
        } else {
            System.out.println("Login Failed. Please enter the valid credentials");
        }

    }
    @Test
    public void login_failure(){
        driver.get("http://localhost:7080/login");
        driver.findElement(By.id("username")).sendKeys("xxxx");
        driver.findElement(By.id("password")).sendKeys("******");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String title = driver.getTitle();
        Assert.assertEquals("The Internet", title);
        if (title.equals("The Internet")) {
            System.out.println("Login is successful");
        } else {
            System.out.println("Login Failed. Please enter the valid credentials");
        }

    }
    @Test
    public void dragDrop() {
        driver.get("http://localhost:7080/drag_and_drop ");
        WebElement drag = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        Actions act = new Actions(driver);
        act.dragAndDrop(drag,target).build().perform();

    }

    @Test
    public void checkboxes(){
        driver.get("http://localhost:7080/checkboxes");
        WebElement chk1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        chk1.click();
        Assert.assertTrue(chk1.isSelected());
        //to uncheck the second checkbox
        WebElement chk2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        chk2.click();
        Assert.assertFalse(chk2.isSelected());
    }

    @Test
    public void contextMenu() {
        driver.get("http://localhost:7080/context_menu");
        WebElement context = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions act = new Actions(driver);
        act.contextClick(context).build().perform();
        String txt = driver.switchTo().alert().getText();
        System.out.println(txt);

    }

    @Test
    public void dropdown() throws InterruptedException {
        driver.get("http://localhost:7080/dropdown");
        driver.findElement(By.id("dropdown")).click();
        Thread.sleep(3000);
        //to select the first option
        driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='1']")).click();
        Thread.sleep(3000);
        //to select the 2nd option
        driver.findElement(By.xpath("//select[@id ='dropdown']/option[@value='2']")).click();

    }
    @Test
    public void dynamic_Content(){
        driver.get("http://localhost:7080/dynamic_content");
        driver.findElement(By.xpath("//*[@id='content']/div/p[2]/a")).click();
        WebElement content = driver.findElement(By.xpath("//div[@class='large-10 columns']"));
        System.out.println(content.getText());
        //driver.findElement(By.linkText("click here")).click();

    }
    @Test
    public void dynamic_Controls() {
        driver.get("http://localhost:7080/dynamic_controls");
        //driver.switchTo().frame("checkbox-example");
        driver.findElement(By.xpath("//button[@type='button']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String txt = driver.findElement(By.xpath("//p[@id='message']")).getText();
        System.out.println(txt);
        //driver.switchTo().frame("input-example");
        driver.findElement(By.xpath("//*[@id='input-example']/button")).click();
        //WebDriverWait wait1 = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        String msg = driver.findElement(By.xpath("//*[@id='message']")).getText();
        System.out.println(msg);
    }
    @Test
    public void dynamicLoading() throws InterruptedException {
        driver.get("http://localhost:7080/dynamic_loading/2");
        driver.findElement(By.xpath("//*[@id='start']/button")).click();
        WebDriverWait w = new WebDriverWait(driver,15);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']/h4")));
        String txt = driver.findElement(By.xpath("//*[@id='finish']/h4")).getText();
        System.out.println(txt);
    }
    @Test
    public void file_download() throws AWTException {
        driver.get(" http://localhost:7080/download");
        driver.findElement(By.linkText("some-file.txt"));
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
    @Test
    public void fileUpload(){
        driver.get("http://localhost:7080/upload");
        driver.findElement(By.xpath("//*[@id='file-upload']")).click();
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("lib/testImage.jpg");

        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
    }
    @Test
    public void floatingMenu(){
        driver.get("http://localhost:7080/floating_menu ");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,3000)", "");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='menu']")).isDisplayed());
        driver.findElement(By.xpath("//*[@id='menu']/ul/li[1]/a")).click();
    }
    @Test
    public void jsAlert() throws InterruptedException {
        driver.get("http://localhost:7080/javascript_alerts");
        driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String txt = driver.findElement(By.xpath("//*[@id='result']")).getText();
        System.out.println(txt);
    }
    @Test
    public void jsError(){
        driver.get("http://localhost:7080/javascript_error");
        driver.findElement(By.xpath("/html/body"));
    }
    @Test
    public void mouse_hover() throws InterruptedException {
        driver.get("http://localhost:7080/hovers ");
        Actions act =new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"))).build().perform();
        Thread.sleep(1000);
        act.moveToElement(driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"))).build().perform();
        Thread.sleep(1000);
        act.moveToElement(driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"))).build().perform();
    }
    @Test
    public void moveiFrame(){
        driver.get("http://localhost:7080/iframe");
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='mce_0_ifr']")));

        driver.findElement(By.xpath("//*[@id='tinymce']/p")).sendKeys("Hello");
    }
    @Test
    public void new_window() throws InterruptedException {
        driver.get("http://localhost:7080/windows ");
        String parent = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        String newWin = driver.getWindowHandle();
        Thread.sleep(1000);
        driver.switchTo().window(parent);

    }
    @Test
    public void notification_message(){
        driver.get("http://localhost:7080/notification_message_rendered");
        driver.findElement(By.xpath("//*[@id='content']/div/p/a")).click();
        String msg = driver.findElement(By.xpath("//*[@id='flash']")).getText();
        System.out.println(msg);
        Assert.assertEquals("Action unsuccesful, please try again",msg);
    }

    @AfterClass
    public void teardown(){
        driver.quit();

    }

    }
