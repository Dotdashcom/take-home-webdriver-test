package support;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;

import static support.TestSetUp.getDriver;

public class Hooks {
    @Before
    public void scenarioStart() {
        TestSetUp.profileSetUp();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @After
    public void scenarioEnd() {
        TestSetUp.tearDown();
    }
}
