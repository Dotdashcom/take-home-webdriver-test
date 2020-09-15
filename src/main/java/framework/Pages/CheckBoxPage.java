package framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckBoxPage {

    WebDriver driver;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='checkboxes']/input[1]")
    WebElement checkBoxOne;

    @FindBy(xpath = "//*[@id='checkboxes']/input[2]")
    WebElement checkBoxTwo;

    public void checkCheckBoxOne(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkBoxOne.click();
        Assert.assertEquals(true,checkBoxOne.isSelected());

    }

    public void uncheckCheckBoxTwo(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkBoxTwo.click();
        Assert.assertEquals(false,checkBoxTwo.isSelected());

    }

}
