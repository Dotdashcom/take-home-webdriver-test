package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DrugAndDropPage {

    @FindBy(xpath="//header[.='A']")
    public WebElement FirstColumn;

    @FindBy(xpath="//header[.='B']")
    public WebElement SecondColumn;

    public  DrugAndDropPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}