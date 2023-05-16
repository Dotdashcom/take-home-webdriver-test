package homework.pages;

import homework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage {

    public IframePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "mce_0_ifr")
    public WebElement iframe;


    @FindBy(id = "tinymce")
    public WebElement textArea;




}
