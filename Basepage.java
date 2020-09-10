package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import test_scripts.DriverWrapper;

public class BasePage {

    public void clickOn(By locator) {
        DriverWrapper.getDriver().findElement(locator).click();
    }

    public void setValue(By locator, String value) {
        DriverWrapper.getDriver().findElement(locator).sendKeys(value);
    }


    public String getValueFromElement(By locator) {
        return DriverWrapper.getDriver().findElement(locator).getText();  //still dont know how driver wrrap method is imported
    }

    public boolean isElementDisplayed(By locator){
        boolean isDisplayed;
        try{
            isDisplayed = DriverWrapper.getDriver().findElement(locator).isDisplayed();
        }
        catch(NoSuchElementException e){
            isDisplayed = false;
        }
        return isDisplayed;

    }

    public boolean isElementSelected(By locator){
        boolean isSelected;
        isSelected= DriverWrapper.getDriver().findElement(locator).isSelected();
        return isSelected;

    }

    public boolean isElementEnabled(By locator){
        boolean isEnabled;
        isEnabled = DriverWrapper.getDriver().findElement(locator).isEnabled();
        return isEnabled;
    }

    public void selectFromDropdown(By locator, String dropdownText){
        WebElement webElement = DriverWrapper.getDriver().findElement(locator);
        Select select = new Select(webElement);
        //select element by visible text
        select.selectByVisibleText(dropdownText);
    }

    public void rightClick(By locator) {
        Actions actions = new Actions(DriverWrapper.getDriver());
        WebElement webElement = DriverWrapper.getDriver().findElement(locator);
        actions.contextClick(webElement).perform();
    }


}
