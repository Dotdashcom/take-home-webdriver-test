package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import utilities.Utilities;

public class DropDown {
    private WebDriver driver;
    private SoftAssert softAssert;

    public DropDown(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="dropdown")
    private WebElement dropDownMenu;

    public void verifyDropDownMenu(){
        navigateToDropDown();
        Select select=new Select(dropDownMenu);
        softAssert.assertTrue(dropDownMenu.isEnabled(),"dropDown menu is not enabled");
        select.selectByIndex(Utilities.generalRandomNumber(1,2));

    }
    private void navigateToDropDown(){
        driver.get(ConfigReader.getProperty("url")+"/dropdown ");
    }
}
