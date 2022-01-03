package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
    
    WebDriver webDriver;
    String dropDownPageUrl = "http://localhost:7080/dropdown";

    String dropdownXpath = "//select[@id='dropdown']";
    String optionXpath = "//select[@id='dropdown']/option[@value='";

    public DropDownPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(dropDownPageUrl);
    }

    public void setOption(int option){
        Select dropdown = new Select(webDriver.findElement(By.xpath(dropdownXpath)));
        dropdown.selectByVisibleText("Option "+option);
    }

    public boolean isOptionSelected(int option){
        return webDriver.findElement(By.xpath(optionXpath+option+"']")).getAttribute("selected") != null;
    }
}
