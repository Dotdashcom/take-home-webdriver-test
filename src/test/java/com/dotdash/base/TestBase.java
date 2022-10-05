package com.dotdash.base;

import com.dotdash.utilities.ConfigurationReaderFile;
import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    @BeforeEach
    public void setUp() {
        DriverUtils.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
DriverUtils.getDriver().manage().window().maximize();
 DriverUtils.getDriver().get(ConfigurationReaderFile.getProperty("baseUrl"));
    }

    @AfterEach
    public void teardown (){
        DriverUtils.closeDriver();
    }

}
