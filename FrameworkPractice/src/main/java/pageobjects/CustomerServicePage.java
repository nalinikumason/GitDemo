package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerServicePage {
	
	WebDriver driver;
	
	public CustomerServicePage(WebDriver driver){
		this.driver=driver;
	}

	private By SearchBox=By.cssSelector("input#helpsearch");
	
	
	
	public WebElement getSearchBox(){
	return	driver.findElement(SearchBox);
		
	}
	
}
