package take.homw.script;

import org.testng.annotations.Test;

import com.library.pitias.Base;

import gmail.pitias4work.com.CheckBox;
import gmail.pitias4work.com.Context_Menu;
import gmail.pitias4work.com.DragandDrop;
import gmail.pitias4work.com.DropDown;
import gmail.pitias4work.com.DynamicContent;
import gmail.pitias4work.com.DynamicControls;
import gmail.pitias4work.com.DynamicLoading;
import gmail.pitias4work.com.FileDownload;
import gmail.pitias4work.com.FloatingMenu;
import gmail.pitias4work.com.Iframe;
import gmail.pitias4work.com.JavaAlert;
import gmail.pitias4work.com.JavaScript_Error;
import gmail.pitias4work.com.Login_Success;
import gmail.pitias4work.com.Login_failer;
import gmail.pitias4work.com.MouseHover;
import gmail.pitias4work.com.Notification_Msg;
import gmail.pitias4work.com.OpenNewTab;
import gmail.pitias4work.com.Upload;

public class Script extends Base{

	@Test
	public void login_Success() {
		Login_Success log = new Login_Success();
		log.logger();
	}
	@Test
	public void login_fail() {
		Login_failer fail = new Login_failer();
		fail.login_fail();;
	}
	@Test
	public void checkbox() {
		CheckBox box =new CheckBox();
		box.box();
	}
	@Test
	public void context_menu() {
		Context_Menu menu = new Context_Menu();
		menu.context();
	}
	@Test
	public void dragandDrop() {
	DragandDrop dr = new DragandDrop();	
	dr.dragandDrop();
	}
	@Test
	public void dropDown() {
		DropDown drop = new DropDown();
		drop.dropDown();
	}
	@Test
	public void dynamic_Content() {
		DynamicContent dyn =new DynamicContent();
		dyn.dynamic_Content();
	}
	@Test
	public void dynamic_Control() {
		DynamicControls  con = new DynamicControls();
		con.dynamic_Control();
	}
	@Test
	public void dynamic_Loading() {
		DynamicLoading load =new DynamicLoading();
		load.dynamic_Loading();
	}
	@Test
	public void fileDownload() {
		FileDownload download =new FileDownload();
		download.download();
	}
	@Test
	public void fileUpload() {
		Upload data =new Upload();
		data.upload();
	}
	@Test
	public void floating_Menu() {
		FloatingMenu fl =new FloatingMenu();
		fl.Floater();
	}
	@Test
	public void iframe() {
		Iframe frame = new Iframe();
		frame.frame();
	}
	@Test
	public void mouse_Hover() {
		MouseHover m =new MouseHover();
		m.mouse();
	}
	@Test
	public void javaScriptAlerts() {
		JavaAlert js =new JavaAlert();
		js.alert();
	}
	@Test
	public void JavaScriptError() {
		JavaScript_Error er = new JavaScript_Error();
		er.jse();
	}
	@Test
	public void openNewTab() {
		OpenNewTab tab = new OpenNewTab();
		tab.newTab();
	}
	@Test
	public void notification_Msg() {
	Notification_Msg msg = new Notification_Msg();
	msg.notification_message();
	}
}
