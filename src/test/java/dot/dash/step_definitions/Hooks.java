package dot.dash.step_definitions;

import dot.dash.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before("@withOption")
    public void setUpWithOptions() {
        // driver will be instantiated in step_definition
    }

    @Before("@nor")
    public void setUp() {
        Driver.getDriver();
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}
