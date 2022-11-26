package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends PageObjectBase {
    @FindBy(id = "dropdown")
    WebElement dropDown;

    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    public DropDownPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/dropdown");
        return this;
    }

    private WebElement getOptionElement(String optionName) {
        String optionXPath = "//option[text()='" + optionName + "']";
        WebElement optionElement = driver.findElement(By.xpath(optionXPath));
        return optionElement;
    }

    public void selectOption(String optionName) {
        Select dropDownOptions = new Select(dropDown);
        dropDownOptions.selectByValue(getOptionElement(optionName).getAttribute("value"));
    }

    public Boolean isOptionSelected(String optionName) {
        return getOptionElement(optionName).isSelected();
    }

}
