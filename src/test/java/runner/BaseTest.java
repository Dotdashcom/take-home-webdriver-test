package runner;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class BaseTest {

    private WebDriver driver;
    @BeforeClass
    protected void beforeClass() {
        BaseUtils.log("                  ____      _                         \n" +
                "  ___ _ __ __ _  / __ \\  __| |_ __ ___ ___  _ __ ___  \n" +
                " / __| '__/ _` |/ / _` |/ _` | '__/ __/ _ \\| '_ ` _ \\ \n" +
                " \\ _\u001B[35m\u001b[1m3\u001B[0m\\ |" +
                "\u001B[35m\u001b[1m0\u001B[0m| (_|" +
                "\u001B[35m\u001b[1m5\u001B[0m| |" +
                "\u001B[35m\u001b[1m7\u001B[0m(_|" +
                "\u001B[35m\u001b[1m0\u001B[0m\u001B[0m| (_|" +
                "\u001B[35m\u001b[1m9\u001B[0m|.|_|" +
                "\u001B[35m\u001b[1m2\u001B[0m(_|" +
                "\u001B[35m\u001b[1m9\u001B[0m(_)" +
                "\u001B[35m\u001b[1m6\u001B[0m| | |" +
                "\u001B[35m\u001b[1m9\u001B[0m| | |\n" +
                " |" +
                "\u001B[35m\u001b[1ms\u001B[0m__/" +
                "\u001B[35m\u001b[1mr\u001B[0m|  \\_" +
                "\u001B[35m\u001b[1mg\u001B[0m, |\\ \\_" +
                "\u001B[35m\u001b[1m@\u001B[0m,_|\\_" +
                "\u001B[35m\u001b[1md\u001B[0m,_|" +
                "\u001B[35m\u001b[1mr\u001B[0m(" +
                "\u001B[35m\u001b[1m.\u001B[0m)\\_" +
                "\u001B[35m\u001b[1mc\u001B[0m_\\_" +
                "\u001B[35m\u001b[1mo\u001B[0m_/|_| |" +
                "\u001B[35m\u001b[1mm\u001B[0m| |_|\n" +
                "          |___/  \\____/   ");
    }

    @BeforeMethod
    protected void beforeMethod() {
        driver = BaseUtils.createDriver();
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult result) {
        Reporter.log(ReportUtils.getTestStatistics(method, result), true);

        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}