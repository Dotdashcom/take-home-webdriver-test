package assessmentMkaya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class MouseHoverTest {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/hovers");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }
//    Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.
    @Test
    public void mouseHover(){
        // Actions class that enables advanced interactions
        Actions actions = new Actions(Driver.get());

        WebElement elementFirst = Driver.get().findElement(By.xpath("(//img)[2]"));
        WebElement elementSecond = Driver.get().findElement(By.xpath("(//img)[3]"));
        WebElement elementThird = Driver.get().findElement(By.xpath("(//img)[4]"));

        actions.moveToElement(elementFirst).pause(1000).moveToElement(elementSecond).pause(1000).
                moveToElement(elementThird).build().perform();


    }
}
