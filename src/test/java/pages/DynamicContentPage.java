package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicContentPage extends BasePage {
    private By firstImage = By.xpath("//*[@id=\"content\"]/div[3]/div[1]/img");
    private By firstText = By.xpath("//*[@id=\"content\"]/div[1]/div[2]");
    private By secondImage = By.xpath("//*[@id=\"content\"]/div[2]/div[1]/img");
    private By secondText = By.xpath("//*[@id=\"content\"]/div[2]/div[2]");
    private By thirdImage = By.xpath("//*[@id=\"content\"]/div[3]/div[1]/img");
    private By thirdText = By.xpath("//*[@id=\"content\"]/div[3]/div[2]");

    public DynamicContentPage (WebDriver driver){
        super(driver);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public String getFirstImageSrc(){
        return getElement(firstImage).getAttribute("src");
    }

    public String getSecondImageSrc(){
        return getElement(secondImage).getAttribute("src");
    }

    public String getThirdImageSrc(){
        return getElement(thirdImage).getAttribute("src");
    }

    public String getFirstText(){
        return getMessage(firstText);
    }

    public String getSecondText(){
        return getMessage(secondText);
    }

    public String getThirdText(){
        return getMessage(thirdText);
    }

}
