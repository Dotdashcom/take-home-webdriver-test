package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CheckboxesPage extends BasePage {

    public CheckboxesPage(WebDriver driver, SoftAssert softAssert){
        super(driver, softAssert);
    }

    @FindBy (xpath = "//input[@type='checkbox']")
    private static List<WebElement> checkboxes;

    public void selectAllCheckboxes(){
        for (WebElement checkbox:checkboxes) if (!checkbox.isSelected()) checkbox.click();
        for (int i = 0; i < checkboxes.size(); i++) {
            softAssert.assertTrue(checkboxes.get(i).isSelected(), "Checkbox " + i + " is not selected");
        }
    }

    public void unselectAllCheckboxes() {
        for (WebElement checkbox : checkboxes) if (checkbox.isSelected()) checkbox.click();
        for (int i = 0; i < checkboxes.size(); i++) {
            softAssert.assertTrue(!checkboxes.get(i).isSelected(), "Checkbox " + i + " is selected");
        }
    }

}
