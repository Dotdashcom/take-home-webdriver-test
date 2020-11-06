package Utils;

import Tests.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;

//Reference:
//https://github.com/swtestacademy/TestNGAllureReport/blob/master/src/test/java/utils/Listeners/TestListener.java

public class UITestListeners extends BaseTest implements ITestListener {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    // ITestResult iTestResult;
    public String getTestMethodName (ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log(ANSI_RED + "=======================================================================", true);
        Reporter.log(ANSI_YELLOW + "Starting to Execute Test:  " + ANSI_PURPLE + result.getName() + ANSI_RESET, true);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        printTestResults(result);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        //saveScreenshot(driver);
        saveScreenshotEntireScreen(driver);
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
        printTestResults(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        printTestResults(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotEntireScreen(WebDriver driver) {
        Screenshot entirePageScreenShot = new AShot().shootingStrategy(ShootingStrategies.viewportRetina(1000,0,0,2)).takeScreenshot(driver);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(entirePageScreenShot.getImage(), "PNG", baos);
        } catch (Exception e) {}
        try { baos.flush();} catch (Exception e) {}
        return  baos.toByteArray();
    }

    @Attachment(value = "Text Log", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    private void printTestResults(ITestResult result) {
        Reporter.log(ANSI_BLUE + "Test Method Resides In: " + ANSI_PURPLE + result.getTestClass().getName(), true);
        String status = null;
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                status = ANSI_RESET + ANSI_GREEN + "PASS";
                break;
            case ITestResult.FAILURE:
                status = ANSI_RESET + ANSI_RED+ "FAILED";
                break;
            case ITestResult.SKIP:
                status = "SKIPPED";
        }
        Reporter.log(ANSI_BLUE + "Test Status: " + status + ANSI_RESET, true);
    }
}
