package FloatingMenu;

import Pages.FileDownloadPage;
import Pages.FloatingMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class FloatingMenuTest extends TestBase {
    @BeforeClass
    public void loginUrl(){
        driver.get(TestBase.BASEURL.concat("/floating_menu"));
    }
    @Test
    public void FloatingMenutest() {

        FloatingMenuPage fm=new FloatingMenuPage();
        List<WebElement> lst=new ArrayList<>();
        for(int i=1; i<=4; i++){
            lst.add(fm.menu);
        }
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        for(WebElement i:lst){
            Assert.assertTrue(i.isDisplayed());
        }

    }
    }

