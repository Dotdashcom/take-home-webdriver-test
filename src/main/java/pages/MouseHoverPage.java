package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverPage {
    WebDriver driver;
    String mouseHoverUrl =("http://localhost:7080/hovers");

    public MouseHoverPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(mouseHoverUrl);
    }

    public void MouseHover(int index) {
        String imageXpath = String.format("//*[@id=\"content\"]/div/div[%d]/img", index);
        WebElement image = this.driver.findElement(By.xpath(imageXpath));
        Actions action = new Actions(driver);
        action.moveToElement(image).build().perform();
    }

    public boolean isDisplayed(int index){
        String addtionalInfoXpath = String.format("//*[@id=\"content\"]/div/div[%d]/div", index);
        return driver.findElement(By.xpath(addtionalInfoXpath)).isDisplayed();
    }

}
