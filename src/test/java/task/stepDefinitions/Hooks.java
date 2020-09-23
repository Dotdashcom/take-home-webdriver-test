package task.stepDefinitions;

import org.junit.After;
import task.utilities.Driver;

public class Hooks {

    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
