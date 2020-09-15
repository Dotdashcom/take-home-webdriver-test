package webdrivertestcases;

import common.Base;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.DynamicControl;

public class DynamicControlTest extends Base {
    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/dynamic_controls");
    }

    @Test
    public void dynamicControlTest(){
        DynamicControl dc = new DynamicControl(driver);
        dc.dynamicControl();
//        Assert.assertEquals(dc.getRemove(), "It's gone!");
//        Assert.assertEquals(dc.getEnable(), "It's enabled!");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
