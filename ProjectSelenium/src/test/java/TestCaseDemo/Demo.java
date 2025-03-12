package TestCaseDemo;

import Browser.browser;
import Pages.page1;
import Pages.page2;
import ScreenShot.capture;

public class Demo {
	public static void main(String arg[]) throws Exception {
		browser.openBrowser();
		browser.navigateToUrl();
		Thread.sleep(2000);
		//browser.closeBrowser();
		page1.userNameEnter("Admin");
		page1.passwordEnter("admin123");
	  // page1.clickLogin();
		if(page1.Title().equals("OrangeHRM")) {
			System.out.println("Title Matches");
		}
		else {
			System.out.println("Title is not Match");
		}
		  page1.clickLogin();
	   Thread.sleep(2000);
	   page2.optionclick("My Info");
	   capture.screenShot("photo");
	  
	   
	}

}
