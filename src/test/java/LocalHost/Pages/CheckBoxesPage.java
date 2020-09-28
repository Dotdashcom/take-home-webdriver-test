package LocalHost.Pages;

import LocalHost.Tests.TestingBase;
import LocalHost.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckBoxesPage {
    public CheckBoxesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//*[@type='checkbox'][1]")
    private WebElement checkbox_1;

    @FindBy(xpath ="//*[@type='checkbox'][2]")
    private WebElement checkbox_2;

    public void Select_Checkbox1() {
        if(checkbox_1.isSelected())
            return;
        else
            checkbox_1.click();
        Assert.assertTrue(checkbox_1.isSelected());
    }
    public void Select_Checkbox2() {
        if(checkbox_2.isSelected())
            return;
        else
            checkbox_2.click();
        Assert.assertTrue(checkbox_2.isSelected());
    }
    public void Unselect_Checkbox1(){
        if(checkbox_1.isSelected()) {
            checkbox_1.click();
        }else
            return;
        Assert.assertTrue(!checkbox_1.isSelected());
    }
    public void Unselect_Checkbox2(){
        if(checkbox_2.isSelected())
            checkbox_2.click();
        else
            return;
        Assert.assertTrue(!checkbox_2.isSelected());
    }


}
