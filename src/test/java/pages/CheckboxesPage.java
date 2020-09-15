package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class CheckboxesPage extends PageBase {

    WebDriver driver;
    @FindBy(xpath = "//*[text()='Checkboxes']/..//input[1]")
    private WebElement checkBox1;

    @FindBy(xpath = "//*[text()='Checkboxes']/..//input[2]")
    private WebElement checkBox2;

    public void logInCheckboxPage(){
        NavigateTo("Checkboxes");
    }

    public void verifyCheckBoxes(){

            if(!checkBox1.isSelected()){
                checkBox1.click();
                Assert.assertTrue(checkBox1.isSelected());
            }else {
                checkBox1.click();
                Assert.assertTrue(!checkBox1.isSelected());
            }
        if(!checkBox2.isSelected()){
            checkBox2.click();
            Assert.assertTrue(checkBox2.isSelected());
        }else {
            checkBox2.click();
            Assert.assertTrue(!checkBox2.isSelected());
        }


        }

//    public WebElement checkBox(String str) {
//        WebElement checkBox = driver.findElement(By.xpath("//*[text()='Checkboxes']/..//input[" + str + "]"));
//        return checkBox;
//    }
}
