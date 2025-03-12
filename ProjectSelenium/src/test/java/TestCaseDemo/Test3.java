package TestCaseDemo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Browser.browser;
import Pages.page1;
import Pages.page2;

public class Test3 {
	@BeforeMethod
	public void open() throws Exception {
		browser.init("test3report");
		browser.openBrowser();
		browser.navigateToUrl();
	}
//	@Test
//	public void testloginbutton() throws Exception {
//		page1.userNameEnter("Admin");
//		page1.passwordEnter("admin123");
//		page1.clickLogin();
//	
//		Reporter.log("Login successful");
//		Thread.sleep(3000);
//	}
	@DataProvider(name="search")
	public Object data1() {
		Object[] o= {"My Info"};
		return o;
	}
	@Test(dataProvider="search")
	public void testsearch(String search) throws Exception {
		page1.userNameEnter("Admin");
		page1.passwordEnter("admin123");
		page1.clickLogin();
		page2.optionclick(search);
		Reporter.log("Searching is done");
		Thread.sleep(2000);
	}
	@AfterMethod
	public void close() {
		browser.closeBrowser();
	}

}
