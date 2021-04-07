package Actions;

import Pages.DragandDropPage;
import Pages.FloatingMenuPage;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.util.concurrent.TimeUnit;

public class DragandDropTest   extends TestBase {
    @BeforeClass
    public void loginUrl() {
        driver.get(TestBase.BASEURL.concat("/drag_and_drop"));
    }

    @Test
    public void DragandDrop() {
        DragandDropPage dp = new DragandDropPage();
        Actions actions=new Actions(Driver.getDriver());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       // actions.dragAndDropBy(dp.box1, 250, 0).build().perform();
        //Building a drag and drop action
        Action dragAndDrop = actions.clickAndHold(dp.box1)
                .moveToElement(dp.box2)
                .release(dp.box2)
                .build();
        dragAndDrop.perform();

       // actions.dragAndDrop(dp.box1, dp.box2).build().perform();
//        actions.clickAndHold(dp.box1).
//                moveToElement(dp.box2).release().perform();
     //   Assert.assertTrue(dp.box1.getText().equals("B"));
    }
    }

