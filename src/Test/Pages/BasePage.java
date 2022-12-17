package Pages;

import Utils.Driver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class BasePage {

    @BeforeMethod
    public void setUp() {
        Driver.GetDriver().manage().window().maximize();
        Driver.GetDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void TearDown(){
        Driver.CloseDriver();
    }
}

