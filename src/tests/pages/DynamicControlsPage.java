package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class DynamicControlsPage {

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"checkbox\"]/input")
    public WebElement checkBox_A;

    @FindBy(xpath = "//*[@id=\"checkbox-example\"]/button")
    public WebElement button_checkBox;

    @FindBy(xpath = "//*[@id=\"input-example\"]/button")
    public WebElement button_EnableDisable;

    @FindBy(xpath = "//*[@id=\"input-example\"]/input")
    public WebElement textBox_EnableDisable;


    public DynamicControlsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void verifyDynamicControls(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        if(button_checkBox.getAttribute("text").equalsIgnoreCase("Remove")) {
            checkBox_A.click();
            button_checkBox.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text()=\"It's gone!\"]")));
            Assert.assertFalse(checkBox_A.isDisplayed(), "checkbox is not removed");
        }
        if(button_checkBox.getAttribute("text").equalsIgnoreCase("Add")) {
            button_checkBox.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text()=\"It's back!\"]")));
            Assert.assertTrue(checkBox_A.isDisplayed(), "checkbox is not displayed");
        }
        if(button_EnableDisable.getAttribute("text").equalsIgnoreCase("Enable")) {
            button_EnableDisable.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text()=\"It's enabled!\"]")));
            Assert.assertTrue(textBox_EnableDisable.isEnabled(), "text box is not enabled");
        }
        if(button_EnableDisable.getAttribute("text").equalsIgnoreCase("Disable")) {
            button_EnableDisable.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text()=\"It's disabled!\"]")));
            Assert.assertTrue(!textBox_EnableDisable.isEnabled(), "text box is not disabled");
        }

    }

}


