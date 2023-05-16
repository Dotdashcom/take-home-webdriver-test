package homework.tests;

import homework.test.TestBase;
import homework.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicContentStepDefs extends TestBase {


    @Test
    public void verifyChangingAfterRefreshing(){

        Driver.getDriver().get("http://localhost:7080/dynamic_content");

        String textBeforeRefresh=Driver.getDriver().findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();

        for(int i=0; i<5; i++){

            Driver.getDriver().navigate().refresh();
            String refreshedContent=Driver.getDriver().findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();

            Assert.assertNotEquals(textBeforeRefresh,refreshedContent);
        }
    }
}
