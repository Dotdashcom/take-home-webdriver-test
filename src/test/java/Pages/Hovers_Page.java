package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import wrapper.setWrapper;

public class Hovers_Page extends setWrapper {
    By imageUser1_loc= By.xpath("//*[@id=\"content\"]/div/div[1]/img");
    By imageUser2_loc= By.xpath("//*[@id=\"content\"]/div/div[2]/img");
    By imageUser3_loc= By.xpath("//*[@id=\"content\"]/div/div[3]/img");
    By hoverImageUser1_loc=By.xpath("//h5[text()='name: user1']");
    By hoverImageUser2_loc=By.xpath("//h5[text()='name: user2']");
    By hoverImageUser3_loc=By.xpath("//h5[text()='name: user3']");
    protected String User1Text="name: user1";
    protected String User2Text="name: user2";
    protected String User3Text="name: user3";
    public Hovers_Page (WebDriver driverDotDash){
        super(driverDotDash);
    }
    public void setChrome(){
        chromeDriverSetUp();
    }
    public void setUrl(String url){
        goToURL(UrlPref+url);
    }
    public void hoversNdAssert(){
        // Check hover mouse on Image Number 1
        waitFor(3,imageUser1_loc);
        hoverMouse(webelement_meth(imageUser1_loc));
        waitFor(3,hoverImageUser1_loc);
        myassertValidation(User1Text,getTextFromLocator(hoverImageUser1_loc),1);
        // Check hover mouse on Image Number 2
        waitFor(3,imageUser2_loc);
        hoverMouse(webelement_meth(imageUser2_loc));
        waitFor(3,hoverImageUser2_loc);
        myassertValidation(User2Text,getTextFromLocator(hoverImageUser2_loc),1);
        // Check hover mouse on Image Number 3
        waitFor(3,imageUser3_loc);
        hoverMouse(webelement_meth(imageUser3_loc));
        waitFor(3,hoverImageUser3_loc);
        myassertValidation(User3Text,getTextFromLocator(hoverImageUser3_loc),1);
    }
}
