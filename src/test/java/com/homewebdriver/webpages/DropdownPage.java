package com.homewebdriver.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage {
    WebDriver driver;
    private static String DROPDOWN_URL="http://localhost:7080/dropdown";

    public DropdownPage(WebDriver driver){
        this.driver=driver;
        driver.get(DROPDOWN_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);

    }
    public boolean selectValueFromDropdown(String Options){
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select objSelect =new Select(dropdown);
        List<WebElement> elementCount = objSelect.getOptions();
        System.out.println(elementCount.size());
        if(elementCount.get(0).isSelected() && elementCount.get(0).getText().equals("Please select an option")&& elementCount.get(1).isSelected()){
            return true;
        }
        if(Options.equals("Index")){
            objSelect.selectByIndex(1);
           if(elementCount.get(1).isSelected() && elementCount.get(1).getText().equals("Option 1")){
               return true;
           }
            objSelect.selectByIndex(2);
            if(elementCount.get(2).isSelected() && elementCount.get(2).getText().equals("Option 2")){
                return true;
            }
        }
       else if(Options.equals("Text")){
            objSelect.selectByVisibleText("Option 1");
            if(elementCount.get(1).isSelected() && elementCount.get(1).getText().equals("Option 1")){
                return true;
            }
            objSelect.selectByVisibleText("Option 2");
            if(elementCount.get(2).isSelected() && elementCount.get(2).getText().equals("Option 2")){
                return true;
            }
        }
        else if(Options.equals("Value")){
            objSelect.selectByValue("1");
            if(elementCount.get(1).isSelected() && elementCount.get(1).getText().equals("Option 1")){
                return true;
            }
            objSelect.selectByValue("2");
            if(elementCount.get(2).isSelected() && elementCount.get(2).getText().equals("Option 2")){
                return true;
            }
        }
        return false;
    }
}
