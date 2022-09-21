package com.braziltest.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected static final String ANDROID = "android";
    protected static final String IOS = "ios";
    private static final String UNSUPPORTED_PLATFORM_ERROR = "Plataforma de desenvolvimento não suportada!";

    protected AppiumDriver<MobileElement> driver;

    protected WebDriverWait wait;

    //protected AppiumRobot appiumRobot;

    protected final String ACTIVE_PLATFORM;

    public BasePage(AppiumDriver<MobileElement> driver, WebDriverWait wait, String activePlatform) {
            this.wait = wait;
            this.driver = driver;

        switch (activePlatform) {
            case ANDROID:
                setAndroid();
                break;
            case IOS:
                setIOS();
                break;
            default:
                throw new UnsupportedOperationException(UNSUPPORTED_PLATFORM_ERROR);
        }
        ACTIVE_PLATFORM = activePlatform;
    }

    protected abstract void setIOS();

    protected abstract void setAndroid();

}
