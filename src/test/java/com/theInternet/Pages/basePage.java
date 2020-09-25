package com.theInternet.Pages;

import com.theInternet.Utilities.Driver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basePage {
    public basePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    public static WebDriverWait webDriverWait;
    
    
}
