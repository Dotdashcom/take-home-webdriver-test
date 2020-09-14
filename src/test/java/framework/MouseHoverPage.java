package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MouseHoverPage extends BasePage{

    public MouseHoverPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean testMouseHover(WebDriver driver) {
        ArrayList<String> results = new ArrayList<>();
        List<WebElement> list = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        int size = list.size();
        for (int i = 1; i <= size; i++) {
            String temp = "(//img[@alt='User Avatar'])["+ i +"]";
            WebElement element = driver.findElement(By.xpath(temp));
            mouseHover(driver, element);
            String temp2 = "//*[contains(text(), 'user"+ i +"')]//following-sibling::*[contains(text(), 'View profile')]";
            WebElement viewProf = driver.findElement(By.xpath(temp2));
            if (isElementPresent(driver, viewProf)) {
                results.add("true");
            }
        }
        if (!results.contains("false"))
            return true;
        return false;
    }
}
