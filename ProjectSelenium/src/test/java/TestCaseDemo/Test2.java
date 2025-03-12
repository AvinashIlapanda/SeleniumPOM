package TestCaseDemo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Browser.browser;
import Excel.datapass;
import Pages.page1;
import Pages.page2;
import ScreenShot.capture;

public class Test2 {
	@BeforeMethod
	public void open() throws Exception {
		browser.init("Test2report");
		browser.openBrowser();
		browser.navigateToUrl();
	}
	@DataProvider(name="dp")
	public Object[][] data() throws Exception{
		Object[][] o=datapass.readExcel(0);
		return o;
	}
//	@DataProvider(name="title")
//	public Object[] data() {
//		Object[] o= {"OrangeHRM"};
//		return o;
//	}
//	@Test(priority=1,dataProvider="title")
//	public void title(String title) throws Exception {
//		capture.screenShot("Title");
//		Assert.assertEquals(page1.Title(),title);
//		Reporter.log("Testcase1 pass");
//		Thread.sleep(2000);
//	}
	@Test(dataProvider="dp")
	public void testloginbutton(String name,String pass,String Expected) throws Exception {
		page1.userNameEnter(name);
		page1.passwordEnter(pass);
		page1.clickLogin();
		
		Reporter.log("Login successful");
		Thread.sleep(3000);
	}
//	@DataProvider(name="search")
//	public Object data1() {
//		Object[] o= {"My Info"};
//		return o;
//	}
//	@Test(priority=3,dataProvider="search")
//	public void testsearch(String search) throws Exception {
//		page2.optionclick(search);
//		Assert.assertTrue(true);
//		Reporter.log("Searching is done");
//	}
	@AfterMethod
	public void close() {
		browser.closeBrowser();
	}
	
	

}
