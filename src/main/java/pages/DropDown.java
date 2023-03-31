package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class DropDown {
    public DropDown(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id=\"dropdown\"]")
    WebElement dropBox;
    @FindBy(xpath = "//option[.='Option 1']")
    WebElement option1;
    @FindBy(xpath = "//option[.='Option 2']")
    WebElement option2;

    public void optionsClick(WebDriver driver) {
        dropBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void opion1Click(WebDriver driver) {
        option1.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public boolean isOption1Selected() {
        return option1.isSelected();
    }

    public void opion2Click(WebDriver driver) {
        option2.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public boolean isOption2Selected() {
        return option2.isSelected();
    }

}
