package TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtherObjects {
	

		 WebDriver driver;
		 
		 @FindBy(xpath ="(//input[@type='checkbox'])[1]")
		 WebElement checkbox1;
		 
		 @FindBy(xpath ="(//input[@type='checkbox'])[2]")
		 WebElement checkbox2;
		 
		@FindBy(xpath ="//*[@id=\"content\"]/div/ul/li[1]/button")
		WebElement JSAlert;
		
		@FindBy(xpath ="//*[@id=\"content\"]/div/ul/li[2]/button")
		WebElement JSconfirm;
		
		@FindBy(xpath="//*[@id=\"content\"]/div/ul/li[3]/button")
		WebElement JSprompt;
		
		@FindBy(xpath="//p[@id='result']")
		WebElement Result;
		
		@FindBy(xpath="//a[normalize-space()='Home']")
		WebElement Home;
		
		@FindBy(xpath="//div[@id='column-a']")
		WebElement ColumnA;
		
		@FindBy(xpath="//div[@id='column-b']")
		WebElement ColumnB;
		
		@FindBy(xpath="//*[@id=\"tinymce\"]/p")
		WebElement iFrame;
		
		String S = "This is Automation QA Mitali Bhavsar";
		
		@FindBy(xpath ="//*[@id=\"content\"]/div/a")
		WebElement clickHere;
		
		@FindBy(xpath = "/html/body/div/h3")
		WebElement newTabContent;
		
		String newTabBody = "New Window";
		
		@FindBy(xpath = "//*[@id=\"checkbox-example\"]/button")
		WebElement Remove;
		
		@FindBy(xpath = "//*[@id=\"checkbox\"]/input")
		WebElement checkBox;
		
		@FindBy(xpath = "//*[@id=\"checkbox-example\"]/button")
		WebElement Add;
		
		@FindBy(xpath = "//button[normalize-space()='Enable']")
		WebElement Enable;
		
		
		@FindBy(xpath = "//*[@id=\"input-example\"]/input")
		WebElement TextBox;
		
		@FindBy(xpath ="//button[normalize-space()='Disable']")
		WebElement Disable;
		
		@FindBy(xpath ="//button[normalize-space()='Start']")
		WebElement Start;
		
		@FindBy(xpath ="//h4[normalize-space()='Hello World!']")
		WebElement Hello;
		
		@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[2]")
		WebElement DynamicContent;
		
		@FindBy(xpath="//a[normalize-space()='Click here']")
		WebElement NotificationClick;
		
        @FindBy(xpath="//div[@id='flash']")	
        WebElement FlashMessage;
		
		 public OtherObjects(WebDriver d){
			  
			  driver =d;
			  PageFactory.initElements(d,this);
		  }

		
}
