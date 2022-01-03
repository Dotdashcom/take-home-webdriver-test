package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicContentPage {
    
    WebDriver webDriver;
    String dynamicContentPageUrl = "http://localhost:7080/dynamic_content";
    String contentXpath = "//div[@id='content']//div[@class='large-10 columns']";

    public DynamicContentPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(dynamicContentPageUrl);
    }

    public String getContentByIndex(int index){
        return webDriver.findElements(By.xpath(contentXpath)).get(index).getText();
        
    }
    public void refresh(){
        webDriver.navigate().refresh();
    }

}
