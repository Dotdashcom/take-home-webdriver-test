package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage extends BasePage{
    @FindBy(xpath = "//h3[contains(.,'Checkboxes')]")
    public WebElement checkboxPageHeader;
    @FindBy(xpath = "(//div[contains(.,'Powered by Elemental Selenium')])")
    public WebElement checkboxPageFooterText;
    @FindBy(xpath = "//a[contains(.,'Elemental Selenium')]")
    public WebElement checkboxPageFooterLink;
    @FindBy(xpath = "//form[contains(@id,'checkboxes')]")
    public WebElement checkboxPageCheckBoxesForm;
    @FindBy(xpath = "(//input[contains(@type,'checkbox')])[1]")
    public WebElement checkboxPageCheckbox1;
    @FindBy(xpath = "(//input[contains(@type,'checkbox')])[2]")
    public WebElement checkboxPageCheckbox2;

    public CheckboxPage() {
        PageFactory.initElements(driver, this);
    }
    public Boolean checkboxesPageLanding(){
        checkboxPageHeader.isDisplayed();
        checkboxPageFooterText.isDisplayed();
        checkboxPageFooterLink.isDisplayed();
        checkboxPageCheckBoxesForm.isDisplayed();
        checkboxPageCheckbox1.isDisplayed();
        checkboxPageCheckbox2.isDisplayed();

        return true;
    }

    public Boolean validateCheckbox1() throws InterruptedException {
        if(!checkboxPageCheckbox1.isSelected()){
            checkboxPageCheckbox1.click();
            Thread.sleep(2000);
            checkboxPageCheckbox1.isSelected();
        }else{
            checkboxPageCheckbox1.click();
            checkboxPageCheckbox1.isSelected();
            Thread.sleep(2000);
        }
        return true;
    }

    public Boolean validateCheckbox2() throws InterruptedException {

        if(!checkboxPageCheckbox2.isSelected())
        {
            checkboxPageCheckbox2.click();
            Thread.sleep(2000);
            checkboxPageCheckbox2.isSelected();
        }else{
            checkboxPageCheckbox2.click();
            checkboxPageCheckbox2.isSelected();
            Thread.sleep(2000);
        }
        return true;
    }
}
