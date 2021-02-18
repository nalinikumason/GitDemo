package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver InitializeDriver() throws Exception{
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		 prop=new Properties();
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		//String browserName=System.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contains("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless")){
			options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			
		}
		else if(browserName.equals("Firefox")){
			 driver=new FirefoxDriver();
		}
		
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   
	   return driver;
	}

  

public String getScreenshotPath(String testcasename, WebDriver driver) throws IOException{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File Source=ts.getScreenshotAs(OutputType.FILE);
	String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
	FileUtils.copyFile(Source, new File(destinationFile));
	return destinationFile;
}
}


