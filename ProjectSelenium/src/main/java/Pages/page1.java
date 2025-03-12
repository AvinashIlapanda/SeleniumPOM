package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browser.browser;
import Locators.page1Objects;

public class page1 extends browser{
	public static String Title() {
		return driver.getTitle();
	}
	public static void userNameEnter(String data) throws Exception{
		 wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		 page1Objects.username().sendKeys(data);
			
		 
		
	}
	public static void passwordEnter(String data) throws Exception{
		page1Objects.password().sendKeys(data)	;
	}
	public static void clickLogin()throws Exception {
		page1Objects.login().click();
	}

}
