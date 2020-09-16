package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import utils.ConfigurationReader;
import utils.Driver;

public abstract class TestBase {

    @BeforeEach
    public void setup() {
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        Driver.closeDriver();
    }
}
