package webdrivertestpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckAndUncheck {
    WebDriver driver;

    public CheckAndUncheck  (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@type='checkbox'][1]")
    WebElement checkbox1;

    @FindBy(xpath = "//input[@type='checkbox'][2]")
            WebElement checkbox2;

    public void checkClick() {
        checkbox1.click();


    }

    public void uncheckClick(){
        checkbox2.click();
    }

    public Boolean isCheck() {
        if (checkbox1.isSelected()) {
            return true;
        }
        return false;
    }

    public Boolean isUncheck(){
        if(!checkbox2.isSelected()){
            return true;
        }
        return false;
    }






    /*public void checkUncheckBox(){


            *//* In order to do the checkbox first I had to find the locator I want to check
               and then I just to invoke the click() method
               Then, I have used isSelected method just to check if it is checked.
                *//*

            checkbox1.click();




        *//* In order to do the unchecked first I had to find the locator I want to check
           and then I just have to invoke the click() method.
           Then I have used isSelected method just to check if it is unchecked
         *//*
        WebElement unchecked = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        unchecked.click();

        if(!unchecked.isSelected()){
            System.out.println("CheckBox is now unchecked");
        }



    }*/

}
