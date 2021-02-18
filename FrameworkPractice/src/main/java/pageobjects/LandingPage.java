package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		this.driver=driver;
	}
	
	
private	By signIn=By.cssSelector("div[class='nav-line-1-container']");
private By ValentineLink=By.cssSelector("a#swm-link");
private By ReturnsOrders=By.cssSelector("a#nav-orders");
	
	
	
	
	public LoginPage getSignIn(){
		//return driver.findElement(signIn);
		driver.findElement(signIn).click();
		LoginPage LP=new LoginPage(driver);
		return LP;
	}
	
	public WebElement getValentineLink(){
		return driver.findElement(ValentineLink);
	}
	
	public WebElement getReturnsOrders(){
		return driver.findElement(ReturnsOrders);
	}

}
