package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CheckBoxesPage extends BasePage {

    @FindBy(xpath = "//a[@href='/checkboxes']")
    WebElement checkBoxesLink;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkboxes;


    public void clickOnCheckBoxesLink() {
        checkBoxesLink.click();
    }

    public void selectAndDeselectCheckBoxes() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }
        WebElement selected = driver.findElement(By.xpath("//input[@type='checkbox']"));
        Assert.assertTrue(selected.isSelected());

        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }
        Assert.assertTrue(!selected.isSelected());
    }


}
