package com.Pages;

import com.BaseTest.TestEngine;
import com.CommonMethods.SeleniumCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuRepository extends TestEngine {

    //parameterized constructor
    public FloatingMenuRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//h3[text()='Floating Menu']//following::div//ul")
    public WebElement _floatingMenuLocator;

    public static void GoToPageEnd(){
        SeleniumCommonMethods.ScrollDownTillPageEnd();
    }
}