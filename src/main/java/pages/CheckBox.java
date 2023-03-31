package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckBox {
    public CheckBox(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/div/div/form/input[@type=\"checkbox\"][1]")
    WebElement checkBox1;
    @FindBy(xpath = "//div/div/div/form/input[@type=\"checkbox\"][2]")
    WebElement checkBox2;

    public void clickCheckBox1(WebDriver driver) {
        checkBox1.click();


    }

    public boolean isSelected1() {
        return checkBox1.isSelected();
    }

    public void clickCheckBox2(WebDriver driver) {
        checkBox2.click();

    }

    public boolean isSelected2() {
        return checkBox2.isSelected();
    }

    public void clickUncheckBoxes(WebDriver driver) {
        checkBox1.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

}


