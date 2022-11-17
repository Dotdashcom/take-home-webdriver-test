package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
    public static void main(String[] args) {

        System.out.println(System.getProperty("user.home"));
       // System.setProperty("webdriver.gecko.driver","D:\\mywork\\Johnson-daman\\geckodriver-v0.32.0-win32\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\mywork\\Johnson-daman\\chromedriver_win32\\chromedriver.exe");

       // WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        System.out.println("driver->"+ driver);

        String actualTitle = "";
        actualTitle = driver.getTitle();

        // get login page
        String loginUrl = "http://localhost:7080/login";
        driver.get(loginUrl);
        actualTitle = driver.getTitle();
        System.out.println("actualTitle->" + actualTitle);
        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        userName.sendKeys("tomsmith");
         password.sendKeys("SuperSecretPassword!");
        //WebElement login = driver.findElement(By.cssSelector("radius"));
        //login.click();
        driver.findElement(By.xpath("//input[@name='username']"));
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));

        login.click();
        //WebElement login = driver.findElement(By.xpath("//button[text()=' Login']"));

        //close Fire fox
        driver.close();
    }

}
