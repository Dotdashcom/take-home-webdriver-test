package Dynamics;

import Pages.DynamicContentPage;
import Pages.DynamicLoadingPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class DynamicLoadingTest extends TestBase {
    WebDriverWait wait;
        @BeforeClass
        public void loginUrl(){
            driver.get(TestBase.BASEURL.concat("/dynamic_loading/2"));
        }
        @Test
        public void DynamicLoadingtest() {

            DynamicLoadingPage dl=new DynamicLoadingPage();
            dl.Start.click();
            wait=new WebDriverWait(Driver.getDriver(),30);
            wait.until(ExpectedConditions.visibilityOf(dl.hellotext));
            Assert.assertEquals(dl.hellotext.getText(),"Hello World!");



        }
    }
