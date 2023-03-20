package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicContentPage extends Util{

    protected WebDriver driver;
    
    // selectors
  	private By dynamicContentPage = By.cssSelector("[href='\\/dynamic_content']");
 	private By content = By.xpath("//div[@class='large-10 columns']");

    final int firstIndex = 0;
    final int secondIndex = 1;
    final int thirdIndex = 2;
    String beforeChangeText1;
    String beforeChangeText2;
    String beforeChangeText3;
    String afterChangeText1;
    String afterChangeText2;
    String afterChangeText3;
    
    public DynamicContentPage(WebDriver driver){
        this.driver = driver;
    }

    public void getDynamicContentPage(){
        driver.findElement(dynamicContentPage).click();
    }

    public void verifyDynamicContent(){

        getDynamicContentPage();
        beforeChangeText1 = indexText(firstIndex);
        beforeChangeText2 = indexText(secondIndex);
        beforeChangeText3 = indexText(thirdIndex);

        driver.navigate().refresh();
        afterChangeText1 = indexText(firstIndex);
        afterChangeText2 = indexText(secondIndex);
        afterChangeText3 = indexText(thirdIndex);

    }

    public String indexText(int index) {
        List<WebElement> text = driver.findElements(content);
        return text.get(index).getText();
    }
}