package pages;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class CheckboxPage extends PageBase {
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


    }}