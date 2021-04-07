package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

public class CheckBoxesPage {

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input")
    public List<WebElement> checkboxes_List;

    public CheckBoxesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void verifyCheckBoxesSelection(){
        for(WebElement ele : checkboxes_List){
            boolean isSelected = ele.isSelected();// true if already checked else false if not  checked
            ele.click();
            Assert.assertTrue(isSelected!=ele.isSelected(),"check and uncheck not working properly");
        }

    }

}
