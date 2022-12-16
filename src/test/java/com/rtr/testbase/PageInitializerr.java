package com.rtr.testbase;

import com.rtr.Pages.CheckboxesPageElements;
import com.rtr.Pages.ContextManuElements;
import com.rtr.Pages.DragAndDropPageElements;
import com.rtr.Pages.DropdownPageElenments;
import com.rtr.Pages.DynamicContentPageElements;
import com.rtr.Pages.DynamicControlsElements;
import com.rtr.Pages.DynamicLoadingPageElements;
import com.rtr.Pages.FileDownloadPageElements;
import com.rtr.Pages.FileUploadPageElements;
import com.rtr.Pages.FloatingMenuPageElements;
import com.rtr.Pages.IframePageElements;
import com.rtr.Pages.JavaScriptAlertsPageElements;
import com.rtr.Pages.JavaScriptErrorPageElements;
import com.rtr.Pages.LoginPageElements;
import com.rtr.Pages.MouseHoverPageElements;
import com.rtr.Pages.NotificationMessagePageElements;
import com.rtr.Pages.OpenInNewTabPageElements;



public class PageInitializerr extends BaseClass {

	public static LoginPageElements login;
	public static CheckboxesPageElements checkbox;
	public static ContextManuElements context;
	public static DragAndDropPageElements dragAndDropPageElements;
	public static DropdownPageElenments dropdown;
	public static DynamicControlsElements dynamicctrl;
	public static DynamicLoadingPageElements dynamicload;
	public static DynamicContentPageElements dynamiccontent;
	public static FileDownloadPageElements filedownload;
	public static FileUploadPageElements fileupload;
	public static FloatingMenuPageElements floatingMenu;
	public static IframePageElements iframe;
	public static MouseHoverPageElements mousehover;
	public static JavaScriptAlertsPageElements jsalerts;
	public static OpenInNewTabPageElements newtab;
	public static NotificationMessagePageElements notification;
	public static JavaScriptErrorPageElements error;
	
	
	

	public static void initialize() {
		login = new LoginPageElements();
		checkbox = new CheckboxesPageElements();
		context = new ContextManuElements();
		dragAndDropPageElements = new DragAndDropPageElements();
		dropdown = new DropdownPageElenments();
		dynamicctrl = new DynamicControlsElements();
		dynamicload = new DynamicLoadingPageElements();
		dynamiccontent = new DynamicContentPageElements();
		filedownload = new FileDownloadPageElements();
		fileupload = new FileUploadPageElements();
		floatingMenu = new FloatingMenuPageElements();
		iframe = new IframePageElements(); 
		mousehover = new MouseHoverPageElements();
		jsalerts = new JavaScriptAlertsPageElements();
		newtab = new OpenInNewTabPageElements();
		notification = new NotificationMessagePageElements();
		error = new JavaScriptErrorPageElements();

	}

}