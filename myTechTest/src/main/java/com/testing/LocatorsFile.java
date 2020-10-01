package com.testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocatorsFile {

	@FindBy(id = "username") public WebElement username;
	@FindBy(id = "password") public WebElement password;
	@FindBy(xpath = "//*[@id=\"login\"]/button") public WebElement loginButton;
	@FindBy(xpath = "//*[@id=\"flash\"]") public WebElement messageBox;
	
	@FindBy(id = "hot-spot") public WebElement contextMenuBox;
	
	@FindBy(id = "column-a") public WebElement dragAndDropBoxA;
	@FindBy(id = "column-b") public WebElement dragAndDropBoxB;
	
	@FindBy(id = "dropdown") public WebElement dropdownList;
	
	@FindBy(tagName = "a") public WebElement dynamicContent;
	
	@FindBy(xpath = "//*[@id=\"checkbox-example\"]/button") public WebElement dynamicControlButtonAddRemove;
	@FindBy(id = "message") public WebElement dynamicControlMsg;
	@FindBy(xpath = "//*[@id=\"input-example\"]/button") public WebElement dynamicControlButtonEnableDisable;
	
	@FindBy(xpath = "//*[@id=\"start\"]/button") public WebElement dynamicLoadingButton;
	@FindBy(xpath = "//*[@id=\"finish\"]/h4") public WebElement dynamicLoadingText;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/a") public WebElement downloadFile;
	
	@FindBy(xpath = "//*[@id=\"file-upload\"]") public WebElement chooseFile;
	@FindBy(xpath = "//*[@id=\"file-submit\"]") public WebElement uploadFile;
	@FindBy(xpath = "//*[@id=\"content\"]/div/h3") public WebElement uploadFileMsg;
	
	@FindBy(xpath = "//*[@id=\"menu\"]/ul/li[1]/a") public WebElement floatingMenuHome;
	
	@FindBy(xpath = "//*[@id=\"tinymce\"]/p") public WebElement iFrameText;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/img") public WebElement mouseHoverImage1;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/h5") public WebElement mouseHoverText1;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/img") public WebElement mouseHoverImage2;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/h5") public WebElement mouseHoverText2;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[3]/img") public WebElement mouseHoverImage3;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[3]/div/h5") public WebElement mouseHoverText3;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[1]/button") public WebElement jsAlertButton;
	@FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[2]/button") public WebElement jsConfirmButton;
	@FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[3]/button") public WebElement jsPromptButton;
	@FindBy(xpath = "//*[@id=\"result\"]") public WebElement jsResult;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/a") public WebElement newTabLink;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/p/a") public WebElement messageNotificationLink;
	@FindBy(xpath = "//*[@id=\"flash\"]") public WebElement messageNotification;
	
	
}
