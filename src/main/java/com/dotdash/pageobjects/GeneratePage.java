package com.dotdash.pageobjects;


import com.dotdash.utils.drivers.TLDriverFactory;
import org.openqa.selenium.support.PageFactory;

public class GeneratePage {

    private GeneratePage() {
        throw new IllegalStateException("GeneratePage cannot be instantiated");
    }

    private static synchronized <T extends BasePage> T instantiateNewPage(Class<T> tClass) {
        return PageFactory.initElements(TLDriverFactory.getTLDriver(), tClass);
    }

    public static LoginPage loginPage() {return instantiateNewPage(LoginPage.class);}
}
