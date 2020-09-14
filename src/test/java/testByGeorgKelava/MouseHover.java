package testByGeorgKelava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class MouseHover {
    public MouseHover() {
    }

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "hovers");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @Test
    public void mouseHover() {
        Actions actions = new Actions(Driver.get());

        WebElement firstElement = Driver.get().findElement(By.xpath("(//img)[2]"));
        WebElement secondElement = Driver.get().findElement(By.xpath("(//img)[3]"));
        WebElement thirdElement = Driver.get().findElement(By.xpath("(//img)[4]"));
        actions.moveToElement(firstElement).pause(2000).moveToElement(secondElement).pause(2000).moveToElement(thirdElement).build().perform();
    }
}
