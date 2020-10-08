package com.company.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseObjectClass {

	WebDriver driver;
	

	//CheckBox
	By check1=By.xpath("//*[@id=\"checkboxes\"]/input[1]");
	By check2=By.xpath("//*[@id=\"checkboxes\"]/input[2]");
	
	public BaseObjectClass(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public WebElement checkbox1()
	{
		return driver.findElement(check1);
		
	}
	public WebElement chekbox2()
	{
		return driver.findElement(check2);
		
	}
	
	//ContextMenu
	By contextmenu=By.xpath("//*[@id=\"hot-spot\"]");
	
	public WebElement contextmenu()
	{
		return driver.findElement(contextmenu);
	}
	
	// Drag and Drop
	By eleA=By.xpath("/html/body/div[2]/div/div/div/div[1]");
	By eleB=By.xpath("/html/body/div[2]/div/div/div/div[2]");
	public WebElement ElementA()
	{
		return driver.findElement(eleA);
	}
	public WebElement ElementB()
	{
		return driver.findElement(eleB);
	}
	
	//New tab
	
	By linkClick=By.xpath("//*[@id=\"content\"]/div/a");
	public WebElement linkC()
	{
		return driver.findElement(linkClick);
	}
	
	//DropDown
	
	By dropdown=By.xpath("//*[@id=\"dropdown\"]");
	public WebElement DropDown()
	{
		return driver.findElement(dropdown);
	}
	
	//FileUpload
	By fileup=By.xpath("//*[@id=\"file-upload\"]");
	By upload=By.xpath("//*[@id=\"file-submit\"]");
	By uploadtxt=By.xpath("//*[@id=\"drag-drop-upload\"]");
	
	public WebElement filen()
	{
		return driver.findElement(fileup);
	}
	public WebElement upload()
	{
		return driver.findElement(upload);
	}
	public WebElement uploadtxt()
	{
		return driver.findElement(uploadtxt);
	}
	
	//FileDownload
	By filedown=By.linkText("some-file.txt");
	public WebElement filedownload()
	{
		return driver.findElement(filedown);
	}
	
	//FloatingMenu
	By flotMenu=By.xpath("//*[@id=\"menu\"]");
	public WebElement floatingMenu()
	{
		return driver.findElement(flotMenu);
	}
	
	//IframeTest
	By iframetxt=By.xpath("//*[@id=\"tinymce\"]/p");
	public WebElement Iframe()
	{
		return driver.findElement(iframetxt);
	}
	
	//MouseHover
	
	By img1=By.xpath("//*[@id=\"content\"]/div/div[1]/img");
	By img1d=By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5");
	By img2=By.xpath("//*[@id=\"content\"]/div/div[2]/img");
	By img2d=By.xpath("//*[@id=\"content\"]/div/div[2]/div");
	By img3=By.xpath("//*[@id=\"content\"]/div/div[3]/img");
	By img3d=By.xpath("//*[@id=\"content\"]/div/div[3]/div");
	public WebElement img1()
	{
		return driver.findElement(img1);
	}
	public WebElement img2()
	{
		return driver.findElement(img2);
	}
	public WebElement img3()
	{
		return driver.findElement(img3);
	}
	public WebElement img1d()
	{
		return driver.findElement(img1d);
	}
	public WebElement img2d()
	{
		return driver.findElement(img2d);
	}
	public WebElement img3d()
	{
		return driver.findElement(img3d);
	}
	
	//JavascriptAlert
	
	By Jalert=By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
	By Jconfirm=By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button");
	By Jprompt=By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button");
	By Jtxt=By.xpath("//*[@id=\"result\"]");
	
	public WebElement Jalert()
	{
		return driver.findElement(Jalert);
	}
	public WebElement Jconfirm()
	{
		return driver.findElement(Jconfirm);
	}
	public WebElement Jprompt()
	{
		return driver.findElement(Jprompt);
	}
	public WebElement Jtxt()
	{
		return driver.findElement(Jtxt);
	}
	
	//NotificationMessage
	
	By message=By.xpath("//*[@id=\"flash\"]");
	By clickhere=By.linkText("Click here");
	public WebElement message()
	{
		return driver.findElement(message);
	}
	public WebElement clickhere()
	{
		return driver.findElement(clickhere);
	}
	
	//DynamicLoading
	
	By dynamicL=By.xpath("//*[@id=\"start\"]/button");
	By dynamicTxt=By.xpath("//*[@id=\"finish\"]/h4");
	public WebElement dynamicL()
	{
		return driver.findElement(dynamicL);
	}
	public WebElement dynamicTxt()
	{
		return driver.findElement(dynamicTxt);
	}
	
	//DynamicControl
	By dynamicBtnAR=By.xpath("//*[@id=\"checkbox-example\"]/button");
	By dynamicCheck=By.xpath("//*[@id=\"checkbox\"]");
	By DynamicText=By.xpath("//*[@id=\"message\"]");
	
	By DynamicTextBox=By.xpath("//*[@id=\"input-example\"]/input");
	By DynamicBtnED=By.xpath("//*[@id=\"input-example\"]/button");
	
	public WebElement dynamicAR()
	{
		return driver.findElement(dynamicBtnAR);
	}
	public WebElement DynamicTextBox()
	{
		return driver.findElement(DynamicTextBox);
	}
	public WebElement DynamicBtnED()
	{
		return driver.findElement(DynamicBtnED);
	}
	public WebElement dynamicCheck()
	{
		return driver.findElement(dynamicCheck);
	}
	public WebElement DynamicText()
	{
		return driver.findElement(DynamicText);
	}
	
	//Dynamic Content
	
	
	
	
	By contentOne=By.xpath("//*[@id=\"content\"]/div[1]");
	By contentTwo=By.xpath("//*[@id=\"content\"]/div[2]/div[2]");
	By contentThree=By.xpath("//*[@id=\"content\"]/div[3]/div[2]");
	public WebElement contentOne()
	{
		return driver.findElement(contentOne);
	}
	public WebElement contentTwo()
	{
		return driver.findElement(contentTwo);
	}
	public WebElement contentThree()
	{
		return driver.findElement(contentThree);
	}
	
}
