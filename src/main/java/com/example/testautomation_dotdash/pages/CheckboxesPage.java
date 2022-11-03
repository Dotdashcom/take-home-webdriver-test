package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class CheckboxesPage extends BasePage {

    public CheckboxesPage(WebDriver driver)
    {
        super(driver);
        driver.get(prop.getProperty("baseurl") + "/checkboxes");
    }

    @FindBy(css = "form[id='checkboxes'] input:nth-child(1)")
    private WebElement checkbox1;


    @FindBy(css = "form[id='checkboxes'] input:nth-child(3)")
    private WebElement checkbox2;


    public void clickCheckbox1(){
        checkbox1.click();
    }

    public void clickCheckbox2(){
        checkbox2.click();
    }

    public void verifyCheckboxIsSelected(String checkbox, boolean checked){
        switch (checkbox) {
            case "checkbox1":
                if (checked) {
                    Assert.assertTrue(checkbox1.isSelected());
                } else {
                    Assert.assertFalse(checkbox1.isSelected());
                }
                break;

            case "checkbox2":
                if (checked) {
                    Assert.assertTrue(checkbox2.isSelected());
                } else {
                    Assert.assertFalse(checkbox2.isSelected());
                }
                break;
        }

    }
}
