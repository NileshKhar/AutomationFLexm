package loginTC;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import loginPOM.LoginPg01;
import loginUtility.Screenshots;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tc01 
{

	@Test
	public void Tc01_VerifyLogin() throws InterruptedException, IOException 
	{
		//Valid Email and Pass
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		Logger log = Logger.getLogger(Tc01.class);
		PropertyConfigurator.configure("log4j.properties");
		
		log.info("Chrome Browser Opened");
		
		
		driver.manage().window().maximize();
		log.info("Browser maximised");

		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		driver.get("https://flexremit-dev.flexm.com/customer/#/login");
		log.info("Webpage opened");
		
		LoginPg01 lp = new LoginPg01(driver);
		
		lp.sendUsername("nilesh@flexm.com");
		log.info("Username Entered");
		
		lp.sendPassword("Nilesh@2023");
		log.info("Password Entered");
		
		lp.clickLoginBtn();
		log.info("Login Button clicked");
		
		Thread.sleep(6000);
		Screenshots.screenShot(driver,"Loginpg1");
		
		String expectedURL = "https://flexremit-dev.flexm.com/customer/#/dashboard";
		String actualURL = driver.getCurrentUrl();
		
		log.info("URL - "+actualURL);
		log.info("Expected URL - "+expectedURL);
		
		if(expectedURL.equals(actualURL))
		{
			log.info("Login Test Pass");
		}
		else
		{
			log.info("Login Test Failed");
		}
		
		driver.quit();
		
	}
	
}
