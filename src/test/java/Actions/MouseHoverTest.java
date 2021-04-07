package Actions;

import Pages.FloatingMenuPage;
import Pages.MouseHoverPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.util.concurrent.TimeUnit;

public class MouseHoverTest  extends TestBase {
    @BeforeClass
    public void loginUrl() {
        driver.get(TestBase.BASEURL.concat("/hovers"));
    }

    @Test
    public void MouseHovertest() {
        MouseHoverPage mp = new MouseHoverPage();
        Actions actions=new Actions(Driver.getDriver());
        WebElement image;

        for(int i=1; i<=3; i++){
            image=Driver.getDriver().findElement(By.xpath("//div[@class='figure']["+i+"]"));
            WebElement profile=Driver.getDriver().findElement(By.xpath("//div[@class='example']/div["+i+"]/div"));
            actions.moveToElement(image).perform();
            Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            Assert.assertTrue(profile.getText().contains("user"));
        }




    }
}