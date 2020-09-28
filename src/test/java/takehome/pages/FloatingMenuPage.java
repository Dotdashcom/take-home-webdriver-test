package takehome.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import takehome.utilities.Driver;

public class FloatingMenuPage {

    @FindBy(linkText = "Floating Menu")
    private WebElement floatingMenuLink;
    @FindBy(linkText = "Elemental Selenium")
    private WebElement elementalSeleniumLink;
    @FindBy(xpath = "//h3[text()='Floating Menu']")
    private WebElement floatingMenu;


    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();



public void scroll(){
    floatingMenuLink.click();
    js.executeScript("arguments[0].scrollIntoView();",elementalSeleniumLink );
}

public boolean checkFloatingMenu    (){
    if (floatingMenu.isDisplayed()  ){
        return true;
    }
    return false;
}




















    public FloatingMenuPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
