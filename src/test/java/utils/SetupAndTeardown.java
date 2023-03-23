package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.getUserAgent;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.isHeadless;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class SetupAndTeardown {

    Utils utils = new Utils();

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        Configuration.baseUrl = utils.getDataFromConfig("BASE_URL");
        Configuration.browser = "chrome";
        Configuration.timeout = 7000;
        Configuration.headless = true;
        Configuration.browserSize = "1800x1400";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @AfterMethod
    public void tearDown() throws IOException {
        screenshot();
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("BASE_URL", Configuration.baseUrl)
                        .put("WebDriver", String.valueOf(getWebDriver()))
                        .put("UserAgent", getUserAgent())
                        .put("isHeadless", String.valueOf(isHeadless()))
                        .build(), System.getProperty("user.dir") + "/allure-results/");
        Selenide.closeWebDriver();
    }


    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }
}
