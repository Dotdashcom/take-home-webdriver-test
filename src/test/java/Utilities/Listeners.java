package Utilities;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;

public class Listeners implements ITestListener, IReporter {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(":::::::test started::" + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(":::::::PASSED::" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(":::::::Failure::" + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(":::::::Start::" + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(":::::::Finish::" + context.getName());
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
    }

}
