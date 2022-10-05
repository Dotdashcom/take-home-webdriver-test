package com.dotdash.pages;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends BasePage{

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkboxes;

}
