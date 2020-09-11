package webdrivertest;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



public class LoginFailure extends Base {
    WebDriver  driver;

    @Test
    public void loginTest() {

        driver = getDriver();

        driver.get("http://localhost:7080/login");

        WebElement username =  driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("WrongPassword!");
        WebElement login = driver.findElement(By.xpath("//button[@class='radius']"));
        login.click();
        String loginFailure = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        System.out.println(loginFailure);
    }
}
