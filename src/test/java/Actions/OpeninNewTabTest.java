package Actions;

import Pages.OpeninNewTabPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.util.Set;

public class OpeninNewTabTest extends TestBase {
    @BeforeClass
    public void loginUrl() {

        driver.get(TestBase.BASEURL.concat("/windows"));
    }

    @Test
    public void OpeninNewTabest() throws InterruptedException {

        OpeninNewTabPage op = new OpeninNewTabPage();
        op.clicknewtab.click();
        Thread.sleep(5000);
        String currentWindow = Driver.getDriver().getWindowHandle();
        Set<String> allWindow = Driver.getDriver().getWindowHandles();
        for (String w : allWindow) {
            if (!w.equals(currentWindow)) {
                Driver.getDriver().switchTo().window(w);
                Assert.assertEquals(Driver.getDriver().getTitle(), "New Window");
            }

        }
    }}

