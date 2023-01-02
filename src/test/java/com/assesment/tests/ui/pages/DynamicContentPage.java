package com.assesment.tests.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DynamicContentPage {
    WebDriver driver;

    public DynamicContentPage(WebDriver driver){
        this.driver=driver;
    }

    public enum Using {
        CONTENTS(By.xpath("(//div[@class='row'])[3]")),
        EACH_CONTENT(By.xpath("(//div[@class='row'])[3]//div[@class='row']"));

        private final By selector;

        Using(By selector) {
            this.selector = selector;
        }

        public By selector() {
            return this.selector;
        }
    }

    public WebElement allContents(){
        return driver.findElement(Using.CONTENTS.selector);
    }

    public String getAllContents(){
        return allContents().findElement(Using.EACH_CONTENT.selector()).getText();
    }


}
