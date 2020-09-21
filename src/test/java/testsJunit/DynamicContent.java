package testsJunit;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;



import utils.Driver;

public class DynamicContent extends BaseClass {
    //I am on the Dynacmic Content page
    //I varify the content changes on each refresh.
@Test
    public void i_varify_the_content_changes_on_each_refresh() throws InterruptedException {
        Driver.getDriver().get("http://localhost:7080/dynamic_content");
        Driver.getDriver().manage().window().maximize();
        Actions action = new Actions(Driver.getDriver());
        String actual = Driver.getDriver().findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
        for (int i = 0; i < 4; i++) {
            Thread.sleep(2000);
            System.out.println(actual);
            action.moveToElement(Driver.getDriver().findElement(By.xpath("//p/a"))).click().build().perform();
            String refreshedText = Driver.getDriver().findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
            assertNotEquals(refreshedText, actual);
            System.out.println(refreshedText);
            actual = refreshedText;

        }
    }
}
