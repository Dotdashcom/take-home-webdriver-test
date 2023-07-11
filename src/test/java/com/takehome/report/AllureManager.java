package com.takehome.report;

import com.takehome.driver.DriverManager;
import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;

import java.util.HashMap;
import java.util.Map;

import static com.takehome.config.ConfigurationManager.configuration;
import static org.openqa.selenium.OutputType.BYTES;

public class AllureManager {

    private AllureManager() {
    }

    public static void setAllureEnvironmentInformation() {
        var basicInfo = new HashMap<>(Map.of(
                "Test URL", configuration().url(),
                "Global timeout", String.valueOf(configuration().timeout()),
                "Headless mode", String.valueOf(configuration().headless()),
                "Local browser", configuration().browser()
        ));
        AllureEnvironmentWriter.allureEnvironmentWriter(ImmutableMap.copyOf(basicInfo));
    }

    @Attachment(value = "Failed test screenshot", type = "image/png")
    public static byte[] takeScreenshotToAttachOnAllureReport() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
    }

    @Attachment(value = "Browser information", type = "text/plain")
    public static String addBrowserInformationOnAllureReport() {
        return DriverManager.getInfo();
    }
}
