package testdata;

import java.io.IOException;

import base.TestBase;

public class BaseUrl extends TestBase {
	
	// All the WebURL to hit the website of given location are declare and store here 
	public BaseUrl() throws IOException {
		super();
		
	}
	public static String baseurl =  "http://localhost:7080";
	public static String url_login = "http://localhost:7080/login";
	public static String url_checkboxes = "http://localhost:7080/checkboxes" ;
	public static String url_ContextMenu = "http://localhost:7080/context_menu";
	public static String url_drag= "http://localhost:7080/drag_and_drop";
	public static String url_dropdown = "http://localhost:7080/dropdown";
	public static String url_dynamic = "http://localhost:7080/dynamic_content";
	public static String url_controls = "http://localhost:7080/dynamic_controls";
	public static String url_dynamicloading = "http://localhost:7080/dynamic_loading/2";
	public static String url_filedownload = "http://localhost:7080/download";
	public static String url_fileupload = "http://localhost:7080/upload";
	public static String url_floating = "http://localhost:7080/floating_menu";
	public static String url_iframe = "http://localhost:7080/iframe";
	public static String url_hover = "http://localhost:7080/hovers";
	public static String url_javascript = "http://localhost:7080/javascript_alerts";
	public static String url_javascripterror  = "http://localhost:7080/javascript_error";
	public static String url_newwindow = "http://localhost:7080/windows";
	public static String url_notificationEror = "http://localhost:7080/notification_message_rendered";
}
