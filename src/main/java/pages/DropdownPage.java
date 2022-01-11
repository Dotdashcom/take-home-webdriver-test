package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    WebDriver driver;
    String dropdownUrl = ("http://localhost:7080/dropdown");
    By dropdownMenu = By.id("dropdown");

    public DropdownPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(dropdownUrl);
    }

    public String selectOption(String value){
        WebElement options = driver.findElement(dropdownMenu);
        Select optionsSelect = new Select(options);
        optionsSelect.selectByValue(value);
        return optionsSelect.getFirstSelectedOption().getText();
    }

}

