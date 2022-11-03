package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class FloatingMenuPage extends BasePage {

    public FloatingMenuPage(WebDriver driver){
        super(driver);
        driver.get(prop.getProperty("baseurl") + "/floating_menu");
    }

    @FindBy(id = "menu")
    private WebElement floatingMenu;


    public void scrollDownAndAssertFloatingMenuIsDisplayed(){
        scrollDownWindow();
        Assert.assertTrue(floatingMenu.isDisplayed());
    }

}
