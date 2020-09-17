package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.TestBase;
import java.util.concurrent.TimeUnit;

public class MouseHoverTests extends TestBase {
    String url="hovers";

    @Test
    public void hover() throws InterruptedException {
        Driver.setUp(url);
        WebElement img;
        Actions actions=new Actions(Driver.getDriver());

        for(int i=1; i<=3; i++){
            img=Driver.getDriver().findElement(By.xpath("//div[@class='figure']["+i+"]"));
            WebElement info=Driver.getDriver().findElement(By.xpath("//div[@class='example']/div["+i+"]/div"));
            actions.moveToElement(img).perform();
            Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            Assert.assertTrue(info.getText().contains("user"));
        }

    }
}
