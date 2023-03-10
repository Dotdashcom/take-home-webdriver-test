package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicContentPage extends BasePage{

    protected WebDriver driver;
    By dynamicContentPage = By.cssSelector("[href='\\/dynamic_content']");
    By dynamicContents = By.xpath("//div[@class='large-10 columns']");

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

    public WebElement getDynamicContentPage(){
        return driver.findElement(dynamicContentPage);
    }

    public void verifyDynamicContent(){

        getDynamicContentPage().click();
        beforeChangeText1 = textRelatedToIndex(firstIndex);
        beforeChangeText2 = textRelatedToIndex(secondIndex);
        beforeChangeText3 = textRelatedToIndex(thirdIndex);

        driver.navigate().refresh();
        afterChangeText1 = textRelatedToIndex(firstIndex);
        afterChangeText2 = textRelatedToIndex(secondIndex);
        afterChangeText3 = textRelatedToIndex(thirdIndex);

    }

    public String textRelatedToIndex(int index) {
        List<WebElement> text = driver.findElements(dynamicContents);
        return text.get(index).getText();
    }
}
