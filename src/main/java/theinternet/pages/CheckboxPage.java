package theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage extends BasePage{
    public CheckboxPage(){
        PageFactory.initElements(driver, this);
    }
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
    public Boolean checkboxesPageLanding(){
        checkboxPageHeader.isDisplayed();
        checkboxPageFooterText.isDisplayed();
        checkboxPageFooterLink.isDisplayed();
        checkboxPageCheckBoxesForm.isDisplayed();
        checkboxPageCheckbox1.isDisplayed();
        checkboxPageCheckbox2.isDisplayed();
        return true;
    }

    public void selectCheckBox(String option) throws InterruptedException {
        switch (option){
            case "1":
                checkboxPageCheckbox1.click();
                Thread.sleep(2000);
                break;
            case "2":
                checkboxPageCheckbox2.click();
                Thread.sleep(2000);
                break;
        }
    }

    public boolean isCheckBoxSelected(String option){
        switch (option){
            case "1":
                return checkboxPageCheckbox1.isSelected();
            case "2":
                return checkboxPageCheckbox2.isSelected();
        }
        return false;
    }
}
