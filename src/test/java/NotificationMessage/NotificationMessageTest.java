package NotificationMessage;

import Pages.NotificationMessagePage;
import Pages.OpeninNewTabPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class NotificationMessageTest extends TestBase {
    @BeforeClass
    public void loginUrl() {
        driver.get(TestBase.BASEURL.concat("/notification_message_rendered"));
    }

    @Test
    public void OpeninNewTabest() {
        NotificationMessagePage np = new NotificationMessagePage();
         np.Clicklink.click();

         for(int i=0; i<5;i++){
             np.Clicklink.click();
             WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
             wait.until(ExpectedConditions.visibilityOf(np.Clicklink));
             String s = np.flashmesage.getText();
             System.out.println(s);
            Assert.assertTrue(np.flashmesage.getText().contains("Action unsuccesful, please try again")
                     ||
                     np.flashmesage.getText().contains("Action successful")
                     ||
                     np.flashmesage.getText().contains("Action Unsuccessful"));
         }

    }
}
