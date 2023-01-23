package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import utils.Base_Page;

public class javascript_error_page extends Base_Page {
    WebDriver driver;

    public javascript_error_page(WebDriver driver) {
        this.driver = driver;
    }

    String ExpectedError = "Cannot read properties of undefined (reading 'xyz')";


    public void JavaScript_Error_meth() {
        LogEntries JSError = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry error : JSError) {
            System.out.println(error.getMessage());

            if (error.getMessage().contains(ExpectedError)) {
                Assert.assertTrue(true);

            }else
                break;

        }

    }
}
