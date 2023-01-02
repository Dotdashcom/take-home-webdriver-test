package com.assesment.tests.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage {
    WebDriver driver;

    public DropdownPage(WebDriver driver){
        this.driver=driver;
    }

    public enum Using {
        DROPDOWN_BUTTON(By.id("dropdown"));

        private final By selector;

        Using(By selector) {
            this.selector = selector;
        }

        public By selector() {
            return this.selector;
        }
    }

    /**
     *  selects random option under the dropdown button
     */
    public String selectRandomOption(){
        Select select = new Select(driver.findElement(Using.DROPDOWN_BUTTON.selector()));
        List<WebElement> allOptions = select.getOptions();
        int randomIndex = (int)(Math.random()*allOptions.size());
//        allOptions.get(randomIndex).click();

        String visibleText = allOptions.get(randomIndex).getText();
        System.out.println(visibleText);
        select.selectByVisibleText(visibleText);
        return visibleText;
    }

    public String selectVisibleOption(){
        Select select = new Select(driver.findElement(Using.DROPDOWN_BUTTON.selector()));
        return select.getFirstSelectedOption().getText();
    }



}
