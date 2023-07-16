package pageObject;

import base.CommonApi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage extends CommonApi  {

    WebDriver driver;
    public CheckboxesPage( WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//*[@type='checkbox'])[1]")
    WebElement checkbox1;

    @FindBy(xpath = "(//*[@type='checkbox'])[2]")
    WebElement checkbox2;
    public void checkCheckbox1(){

        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
    }
    public void uncheckCheckbox2(){
        if (checkbox2.isSelected()){
            checkbox2.click();
        }
    }
    public boolean isCheckbox1Selected() {

        return checkbox1.isSelected();
    }
    public boolean isCheckbox2Selected() {

        return checkbox2.isSelected();
    }


    public void goTo(){
        driver.get("http://localhost:7080/checkboxes");
    }
}
