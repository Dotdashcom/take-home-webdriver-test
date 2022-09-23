package com.dotdash.pages;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.junit.After;
import org.junit.Before;

public class TestBase {

    @Before
    public void setUpMethod() {

        Driver.getDriver().get(ConfigurationReader.getProperty("baseUrl"));
    }

    @After
    public void tearDown() {

        Driver.getDriver().quit();
    }


}
