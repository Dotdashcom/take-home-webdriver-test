package utils;

import org.testng.annotations.AfterTest;

public class TestBase {


    @AfterTest
    public void tearDown(){
        Driver.closeDriver();
    }
}
