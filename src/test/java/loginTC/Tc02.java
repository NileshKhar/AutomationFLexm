package loginTC;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import loginPOM.LoginPg01;
import loginUtility.Screenshots;

public class Tc02 
{
	@Test
	public void Tc02_VerifyLogin() throws InterruptedException, IOException 
	{
		// Valid mail Invalid Pass

		WebDriverManager.chromedriver().setup();
		
		Logger log = Logger.getLogger(Tc02.class);
		PropertyConfigurator.configure("log4j.properties");
		
		WebDriver driver = new ChromeDriver();
		log.info("Chrome Browser Opened");
		
	
		driver.manage().window().maximize();
		log.info("Browser maximised");

		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		driver.get("https://flexremit-dev.flexm.com/customer/#/login");
		log.info("Webpage opened");
		
		LoginPg01 lp = new LoginPg01(driver);
		
		lp.sendUsername("nilesh@flexm.com");
		log.info("Username Entered");
		
		lp.sendPassword("Nilesh@");
		log.info("Password Entered");
		
		lp.clickLoginBtn();
		log.info("Login Button clicked");
		
		Thread.sleep(5000);
		Screenshots.screenShot(driver,"Loginpg2");
		
		String expectedURL = "https://flexremit-dev.flexm.com/customer/#/dashboard";
		String actualURL = driver.getCurrentUrl();
		
		log.info("URL - "+actualURL);
		log.info("Expected URL - "+expectedURL);
		
		if(expectedURL.equals(actualURL))
		{
			log.info("Login test pass");
		}
		else
		{
			String errorPs = lp.passwordErrorMsg();
			log.info("Errror msg - "+ errorPs);
		}
		
		
		
		driver.quit();
}
}
