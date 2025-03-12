package TestCaseDemo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Browser.browser;
import Pages.page1;
import ScreenShot.capture;

public class Test1 {
	@BeforeMethod
	public void open() throws Exception {
		browser.init("Test1report");
		browser.openBrowser();
		browser.navigateToUrl();
	}
	@DataProvider(name="title")
	public Object[] data() {
		Object[] o= {"OrangeHRM"};
		return o;
	}
	@Test(dataProvider="title")
	public void title(String title) throws Exception {
		capture.screenShot("Title");
		Assert.assertEquals(page1.Title(),title);
		Reporter.log("Testcase1 pass");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void close() {
		browser.closeBrowser();
	}
	

}
