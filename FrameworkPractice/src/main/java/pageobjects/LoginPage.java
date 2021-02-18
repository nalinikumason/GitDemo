package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}

	
	private By EmailID=By.cssSelector("input[type='email']");
	private By Submit=By.cssSelector("input#continue");
	//private By link=By.cssSelector("a[class='a-link-normal']");
	private By link=By.linkText("Conditions of Use");
	
	
	public WebElement getEmailID(){
		return driver.findElement(EmailID);
	}
	
	public WebElement SubmitButton()
	{
		return driver.findElement(Submit);
	}
	
	public CustomerServicePage getLink(){
		driver.findElement(link).click();
		CustomerServicePage CS=new CustomerServicePage(driver);
		return CS;
	}
}
