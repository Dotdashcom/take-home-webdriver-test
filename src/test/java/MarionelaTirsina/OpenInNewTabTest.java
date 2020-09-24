package MarionelaTirsina;

import MarionelaTirsina.pages.OpenInNewTab;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.junit.*;

import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OpenInNewTabTest {
    /**
     *   //Task: Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
     */
    OpenInNewTab openInNewTab= new OpenInNewTab();
    @Before
    public void setUp() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/windows");
        Driver.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }


    @Test
    public void openNewTab(){

        String currentWindowHandle = Driver.getDriver().getWindowHandle();
        String currentWindowTitle = Driver.getDriver().getTitle();

        System.out.println("currentWindowTitle = " + currentWindowTitle);

        WebElement link = openInNewTab.openNeWindowLink;
        link.click();
        Set<String> windowsHandles = Driver.getDriver().getWindowHandles();

        String newWindowTitle="";
        for (String eachWindow:windowsHandles){

            if (!eachWindow.equals(currentWindowHandle)){
                Driver.getDriver().switchTo().window(eachWindow);
                 newWindowTitle = Driver.getDriver().getTitle();
                System.out.println("newWindowTitle = " + newWindowTitle);
            }

        }
        Assert.assertNotEquals(currentWindowTitle, newWindowTitle, "false");
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

    }
}
