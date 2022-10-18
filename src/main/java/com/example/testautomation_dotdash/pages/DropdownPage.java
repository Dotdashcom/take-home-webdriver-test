package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class DropdownPage extends BasePage {

    public DropdownPage(WebDriver driver){
        super(driver);
        driver.get(prop.getProperty("baseurl") + "/dropdown");
    }

    @FindBy(id = "dropdown")
    private WebElement dropdownMenu;


    public void selectOptionDropdown(String dropdownOption) throws Exception{

        Select dropdown = new Select(dropdownMenu);

        try {
            dropdown.selectByVisibleText(dropdownOption);
            WebElement optionSelected = driver.findElement(By.cssSelector("select[id=\"dropdown\"] option[selected=\"selected\"]"));
            String optionSelectedText = optionSelected.getText();
            Assert.assertEquals(optionSelectedText, dropdownOption);
        }
        catch (Exception e){
            throw new Exception("This is not an option in the dropdown");
        }

    }
}
