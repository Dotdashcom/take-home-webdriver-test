package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class MouseHoverPage {
    WebDriver webDriver;
    String mouseHoverPageUrl = "http://localhost:7080/hovers";
    String imageXpath = "//img[@src='/img/avatar-blank.jpg']";
    String hiddenMessageXpath = "//h5[text()='name: user";

    public MouseHoverPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(mouseHoverPageUrl);
    }

    public List<WebElement> getImages(){
        return webDriver.findElements(By.xpath(imageXpath));
    }

    public boolean isithMessageDisplayed(int i){
        return webDriver.findElement(By.xpath(hiddenMessageXpath+i+"']")).isDisplayed();
    }
}
