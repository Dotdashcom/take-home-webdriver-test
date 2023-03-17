package Tests;
import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotEquals;
public class DynamicContent {
    @BeforeTest
    public void setup(){
    }
    @AfterTest
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void DynamicContent() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Driver.getDriver().get("http://localhost:7080/dynamic_content");
        Actions action = new Actions(Driver.getDriver());
        String actual = Driver.getDriver().findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
        for (int i = 0; i < 4; i++) {
            action.moveToElement(Driver.getDriver().findElement(By.xpath("//p/a"))).click().build().perform();
            String refreshedText = Driver.getDriver().findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
            assertNotEquals(refreshedText, actual);
            actual = refreshedText;
        }
    }
}