package Pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Browser.browser;
import Locators.page2Objects;

public class page2 extends browser{
	
	
	public static void optionclick(String data) throws Exception {
		Thread.sleep(2000);

	List<WebElement> list =page2Objects.listBar();
	
	for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i).getText());
		if (list.get(i).getText().equalsIgnoreCase(data))
		{
			list.get(i).click();
			break;
		}
	}
		
	}	
}
		
 
	


