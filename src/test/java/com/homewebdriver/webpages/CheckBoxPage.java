package com.homewebdriver.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {
    WebDriver driver;
    private static String CHECKBOX_URL="http://localhost:7080/checkboxes";

    // Locator for CheckBox 1
    By FirstCheckBox= By.xpath("//form[@id='checkboxes']/input[1]");

    // Locator for CheckBox 2
    By SecondCheckBox= By.xpath("//form[@id='checkboxes']/input[2]");
    public CheckBoxPage(WebDriver driver)
    {
        this.driver=driver;
        driver.get(CHECKBOX_URL);
        driver.manage().window().maximize();
        //Initialise Elements
        PageFactory.initElements(driver, this);

    }
    // Method to click checkboxes with specified input
    public void clickCheckBox(String CheckBoxNumber){
        if(CheckBoxNumber == "One") {
            driver.findElement(FirstCheckBox).click();
        }
        else if(CheckBoxNumber == "Two"){
            driver.findElement(SecondCheckBox).click();
        }
    }

    public boolean verifyCheckBoxStatus(String CheckBoxNumber){
        if(CheckBoxNumber == "One") {
           return driver.findElement(FirstCheckBox).isSelected();
        }
        else if(CheckBoxNumber == "Two"){
          return  driver.findElement(SecondCheckBox).isSelected();
        }
        return false;
    }
}
