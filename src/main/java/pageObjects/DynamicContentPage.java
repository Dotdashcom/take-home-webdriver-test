package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicContentPage extends Base {
    WebDriver driver;

    By table = By.xpath(readValue("dynamicPage.tableXp"));

    public String[] imageArray() {
        String xpath = readValue("dynamicPage.tableXp");
        WebElement list = driver.findElement(table);
        List<WebElement> rows = list.findElements(By.xpath("//div/div/img"));
        String img[] = new String[rows.size()];
        for (int i = 0; i < rows.size(); i++) {
            img[i] = driver.findElement(By.xpath(xpath + "/div[" + (i + 1) + "]/div/img")).getAttribute("src");
        }
        return img;
    }

    public String[] textArray() {
        String xpath = readValue("dynamicPage.tableXp");
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='large-10 columns']"));
        String txt[] = new String[rows.size()];
        for (int i = 0; i < rows.size(); i++) {
            txt[i] = driver.findElement(By.xpath(xpath + "/div[" + (i + 1) + "]/div[2]")).getText();
        }
        return txt;
    }

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
    }
}
