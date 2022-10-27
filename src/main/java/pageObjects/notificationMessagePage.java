package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import utils.Baseclass;

public class notificationMessagePage 
{
	Baseclass bs;
	private final By button_ClickHere = By.xpath("//a[text()='Click here']");
	private final By message_Text = By.xpath("//div[@id='flash']");
	public notificationMessagePage(Baseclass bs)	
	{
		this.bs = bs;
	}
	
	public void clickOnClickHere()
	{
		bs.click(button_ClickHere);
	}
	
	public String getmessage()
	{
		String value = bs.getText(message_Text);
		String value2 = bs.getText(By.xpath("//a[@class='close']"));
		value =  value.replaceAll(value2, "").trim();
		System.out.println("value is: "+ value.trim());
		return value;
	}
	
	public ArrayList<String> actualMessages() {
		ArrayList<String> actualmessages = new ArrayList<String>();
		actualmessages.add("Action successful");
		actualmessages.add("Action unsuccesful, please try again");
		actualmessages.add("Action Unsuccessful");
		return actualmessages;
	}
	
}
