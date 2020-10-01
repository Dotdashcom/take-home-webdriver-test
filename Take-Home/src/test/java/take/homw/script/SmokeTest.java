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

public class SmokeTest extends Base {

	@Test(priority = 1)
	public void login_Success() {
		Login_Success log = new Login_Success();
		log.logger();
	}

	@Test(priority = 2)
	public void login_fail() {
		Login_failer fail = new Login_failer();
		fail.login_fail();
		;
	}

	@Test(priority = 3)
	public void checkbox() {
		CheckBox box = new CheckBox();
		box.box();
	}

	@Test(priority = 4)
	public void context_menu() {
		Context_Menu menu = new Context_Menu();
		menu.context();
	}

	@Test(priority = 5)
	public void dragandDrop() {
		DragandDrop dr = new DragandDrop();
		dr.dragandDrop();
	}

	@Test(priority = 6)
	public void dropDown() {
		DropDown drop = new DropDown();
		drop.dropDown();
	}

	@Test(priority = 7)
	public void dynamic_Content() {
		DynamicContent dyn = new DynamicContent();
		dyn.dynamic_Content();
	}

	@Test(priority = 8)
	public void dynamic_Control() {
		DynamicControls con = new DynamicControls();
		con.dynamic_Control();
	}

	@Test(priority = 9)
	public void dynamic_Loading() {
		DynamicLoading load = new DynamicLoading();
		load.dynamic_Loading();
	}

	@Test(priority = 10)
	public void fileDownload() {
		FileDownload download = new FileDownload();
		download.download();
	}

	@Test(priority = 11)
	public void fileUpload() {
		Upload data = new Upload();
		data.upload();
	}

	@Test(priority = 12)
	public void floating_Menu() {
		FloatingMenu fl = new FloatingMenu();
		fl.Floater();
	}

	@Test(priority = 13)
	public void iframe() {
		Iframe frame = new Iframe();
		frame.frame();
	}

	@Test(priority = 14)
	public void mouse_Hover() {
		MouseHover m = new MouseHover();
		m.mouse();
	}

	@Test(priority = 15)
	public void javaScriptAlerts() {
		JavaAlert js = new JavaAlert();
		js.alert();
	}

	@Test(priority = 16)
	public void JavaScriptError() {
		JavaScript_Error er = new JavaScript_Error();
		er.jse();
	}

	@Test(priority = 17)
	public void openNewTab() {
		OpenNewTab tab = new OpenNewTab();
		tab.newTab();
	}

	@Test(priority = 18)
	public void notification_Msg() {
		Notification_Msg msg = new Notification_Msg();
		msg.notification_message();
	}
}
