package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrapper.setWrapper;

public class IFramePage extends setWrapper {
   By iFrame_loc= By.id("mce_0_ifr");
   By textBox_loc=By.xpath("//*[@id=\"tinymce\"]/p");
   By CloseMsg_loc=By.xpath("//button/div[@aria-label='Close']");//div[@aria-label='Close']
   protected String TextSent="This is my Test";

   public IFramePage(WebDriver driverDotDash) {
      super(driverDotDash);
   }
   public void setChrome(){
      chromeDriverSetUp();
   }
   public void setUrl(String url){
      goToURL(UrlPref+url);
   }
   public void waitIFrame(){
      waitFor(3,iFrame_loc);
   }
   public void switchToFrameNdwrite (){
      switchotherFrame(webelement_meth(iFrame_loc));
      webelement_meth(textBox_loc).clear();

   }
   public void typeIntoTextBox(){
      sendKeys(textBox_loc,TextSent);
   }
   public void assertIFrame(){
      myassertValidation(TextSent,getTextFromLocator(textBox_loc),1);
   }

}
