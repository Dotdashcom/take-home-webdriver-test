package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.Log;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class DropDownPage extends BasePage {

    private final By dropDownList = By.id("dropdown");

    public DropDownPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("dropdown_url"));
    }

    public void dropdownSelection(){

        Select dropDown = new Select(getDriver().findElement(dropDownList));

        dropDown.selectByVisibleText("Option 1");
        WebElement selectedValue1= dropDown.getFirstSelectedOption();
        Assert.assertTrue(selectedValue1.getText().equals("Option 1"));
        Log.info("Option 1 selected successfully");

        dropDown.selectByVisibleText("Option 2");
        WebElement selectedValue2= dropDown.getFirstSelectedOption();
        Assert.assertTrue(selectedValue2.getText().equals("Option 2"));
        Log.info("Option 2 selected successfully");
    }
}
