package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrapper.setWrapper;

public class DropDown_Page extends setWrapper {

    By dropdownList_locator= By.xpath("//select[@id=\"dropdown\"]");
    By optionDropDownList_1=By.xpath("//option[@value=\"1\"]");
    By optionDropDownList_2=By.xpath("//option[@value=\"2\"]");
     String optionList_2="Option 2";
    String optionList_1="Option 1";
    public DropDown_Page (WebDriver driverDotDash){
        super(driverDotDash);
    }
    public void setChrome(){
        chromeDriverSetUp();
    }
    public void setUrl (String url){
        goToURL(UrlPref+url);
    }

    public void option1Selected(){
    SelectDropDownList(webelement_meth(dropdownList_locator),optionList_1);
    }
    public void option2Selected(){
        SelectDropDownList(webelement_meth(dropdownList_locator),optionList_2);
    }
    public void assertOptionsList(){
        if (webelement_meth(optionDropDownList_2).isSelected())
        myassertValidation("Option 2",getTextFromLocator(optionDropDownList_2),1);
        else myassertValidation("Option 1",getTextFromLocator(optionDropDownList_1),1);
    }
}
