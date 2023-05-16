package homework.test;

import homework.utilities.Driver;
import org.testng.annotations.AfterMethod;

public abstract class TestBase {

    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }
}
