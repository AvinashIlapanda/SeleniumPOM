package Browser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class browser {
 public static WebDriver driver;
 public static WebDriverWait wait;
 public static Actions act;
 public static ExtentReports extent;
 public static ExtentSparkReporter reporter;
 public static ExtentTest logger1;
 
 public static void init(String reportname) {
	 extent=new ExtentReports();
	 reporter=new ExtentSparkReporter(System.getProperty("user dir")+"//target//Extentreport//"+reportname+".html");
 }
 
 /*
	 * Open the browser based on the choice
	 */
	public static void openBrowser() throws Exception {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Open Browser");
		logger1.log(Status.INFO,"Opening the Browser");
		
		extent.flush();
		try {
			
			String choice = Utility.properties("browser"); 
			if (choice.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				logger1.log(Status.INFO, "Browser Opens Successfully");}
			else if (choice.equalsIgnoreCase("Edge"))
				driver = new EdgeDriver();
			else if (choice.equalsIgnoreCase("Firefox"))
				driver = new FirefoxDriver();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Error in opening Browser");
			logger1.log(Status.FAIL, "Failed to open browser");
			System.out.println("Browser - openBrowser");
		}
		extent.flush();
	}

	/*
	 * Pauses the URL of the application
	 */
	public static void navigateToUrl() throws Exception {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Open The URL ");
		logger1.log(Status.INFO,"Opening the URL");
		
		try {
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
			driver.manage().window().maximize();
			act = new Actions(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleIs("OrangeHRM"));
			logger1.log(Status.INFO, "URL Opens Successfully");
		} catch (Exception e) {
			System.out.println("Browser - geturl"+e);
			System.out.println("Error in opening URL");
			logger1.log(Status.FAIL, "Failed to open URL");
		}
		extent.flush();
	}
	/*
	 * Closes the Browser
	 */
	public static void closeBrowser() {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Close Browser");
		logger1.log(Status.INFO,"Closeing the Browser");
		
		try {
			driver.quit();
			logger1.log(Status.INFO, "Browser Closes Successfully");
		} catch (Exception e) {
			System.out.println("Browser - closeBrowser"+e);
			System.out.println("Error in Closeing Browser");
			logger1.log(Status.FAIL, "Failed to Close the browser");
		}
		extent.flush();
		
	}
}
