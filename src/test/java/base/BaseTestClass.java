package base;

import manager.DriverManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        DriverManager.startDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        DriverManager.quitDriver();
    }


}
