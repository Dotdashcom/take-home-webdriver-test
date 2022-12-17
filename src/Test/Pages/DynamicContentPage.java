package Pages;

import Utils.Driver;
import Utils.HelpfulMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage {
    public DynamicContentPage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(xpath = "(//div[@id='content'])[2]")
    private WebElement content;

    public void DynamicContent() {
        Driver.GetDriver().navigate().refresh();
        String text = Driver.GetDriver().findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]")).getText();
        System.out.println(text);
        HelpfulMethods.staticWait(10);
        Driver.GetDriver().navigate().refresh();
        String text2 = Driver.GetDriver().findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]")).getText();
        System.out.println(text2);


}
}
