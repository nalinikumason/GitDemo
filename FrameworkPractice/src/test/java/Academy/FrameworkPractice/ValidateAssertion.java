package Academy.FrameworkPractice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.LandingPage;
import resources.Base;

public class ValidateAssertion extends Base {
	
	LandingPage L;

	public WebDriver driver;
	@BeforeTest
	public void Config() throws Exception{
		
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test(priority=1)
	public void ValidateText(){
		 L=new LandingPage(driver);
		//L.getValentineLink().getText();
		Assert.assertEquals("Valentine's Day Gift Shop", L.getValentineLink().getText());
	    System.out.println("Text is matching");
	    System.out.println("Text is perfect");
	    System.out.println("Text is displaying");
		
	}
	
	@Test(priority=2)
	public void ValidateTextField(){
		//L.getReturnsOrders().isDisplayed();
		Assert.assertTrue(L.getReturnsOrders().isDisplayed());
	}
	
	@Test(priority=3)
	public void ValidateTextbox(){
		
		System.out.println("TextBox is displaying");
		
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
	}
	
	
}
