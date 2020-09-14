package webdrivertestpages;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FloatingMenu extends Base {
    WebDriver driver;
    @FindBy(xpath = "//a[contains(text(), 'News')]")
    WebElement menu;
    String getCurrentURL;

    public FloatingMenu (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void floatingMenu(){

        /*
        * Here I was basically checking the css floating meny which basically
        * float on top of pages as I scrolled down.
        * So in order to test if it really works I have used javascript executor
        * to scroll all the way down to the page.
        *
        * */

        // Created object of javascript executor and I had to downcast driver to JavaScriptExecutor type
        JavascriptExecutor js = ( JavascriptExecutor)driver;

        /*
        Now To scroll to the Bottom of the Web Page using Selenium WebDriver:
        We get the height of the Body element from the DOM (Document Object Model)
        and we use the scrollTo() method to scroll to the maximum height of the page:*/
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // checking if the floating menu works by clicking on "News" menu after scrolling down

        menu.click();
    }

    public String getCurrentURlAfterScrollDown(){
        getCurrentURL = driver.getCurrentUrl();
        return getCurrentURL;
    }




}
