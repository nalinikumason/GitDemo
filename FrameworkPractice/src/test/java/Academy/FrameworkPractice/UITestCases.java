package Academy.FrameworkPractice;

import org.testng.annotations.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.CustomerServicePage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class UITestCases extends Base {
	
	
	public WebDriver driver;

	
	@BeforeTest
	public void config() throws Exception{
		
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getdata")
	public void PageNavigation(String EmailID, String Text){
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		LandingPage L=new LandingPage(driver);
		LoginPage LP=L.getSignIn();
		LP.getEmailID().sendKeys(EmailID);
		LP.SubmitButton().click();
		CustomerServicePage CP=LP.getLink();
		CP.getSearchBox().sendKeys(Text);
		
		
		
	}
	
	@AfterTest
	public void TearDown(){
		driver.close();
	}
	@DataProvider
	public Object[][] getdata(){
		
		
		
		Object[][]data=new Object[1][2];
		data[0][0]="nalini@123";
		data[0][1]="Refund";
		return data;
		
		// if you want to verify two data in emailID field
		
		/*Object[][]data=new Object[2][1];
		data[0][0]="nalini@123";
		data[1][0]="Madhna@123"; */
		
		
		
		
		
	}
	
	
}
