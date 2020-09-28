package takehome.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.BrowserUtilities;
import takehome.utilities.Driver;

public class Checkbox {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    @FindBy(linkText = "Checkboxes")
    private WebElement checkboxLink;
    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    public WebElement firstCheckbox;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    protected WebElement secondCheckbox;

    public String putCheckMarks(){

        BrowserUtilities.wait(5);
        wait.until(ExpectedConditions.elementToBeClickable(firstCheckbox)).click();
        String value ="";

       if (firstCheckbox.isSelected()&& secondCheckbox.isSelected()){
          value="both checkbox work";

       } else {
           value="both checkboxes do not work";
       }
       return value;
    }
    public void clickOnCheckBox(){
        wait.until(ExpectedConditions.elementToBeClickable(checkboxLink)).click();

    }


    public String un_clickCheckbox(){
        String uncheck="";
        wait.until(ExpectedConditions.elementToBeClickable(firstCheckbox));
        firstCheckbox.click();
        firstCheckbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(secondCheckbox)).click();
        if (!firstCheckbox.isSelected()&& secondCheckbox.isSelected()){
            uncheck ="uncheck successfully";

        } else {
            uncheck="failed";
        }
        return  uncheck;

    }




    public Checkbox() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

}
