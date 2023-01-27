package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CheckBoxes {
    private WebDriver driver;
    private SoftAssert softAssert;

    public CheckBoxes(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//input[@type='checkbox']")
    private List<WebElement> checkBoxes;

    public void checkAndUncheckBoxes(){
        navigateToCheckBoxPage();
        checkBoxes();
        uncheckBoxes();
    }

    private void checkBoxes(){
        checkBoxes.get(1).click();
        for (int i = 0; i < checkBoxes.size(); i++) {
            checkBoxes.get(i).click();
            softAssert.assertTrue(checkBoxes.get(i).isSelected(),"check box "+checkBoxes.get(i).getText()+" is not checked");
        }
    }
    private void uncheckBoxes(){
        for (int i = 0; i < checkBoxes.size(); i++) {
            checkBoxes.get(i).click();
            softAssert.assertTrue(!checkBoxes.get(i).isSelected(),"check box "+checkBoxes.get(i).getText()+" is not unchecked");
        }
    }
    private void navigateToCheckBoxPage(){
        driver.get(ConfigReader.getProperty("url")+"/checkboxes" );
    }



}
