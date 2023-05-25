package loginPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPg01 
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='mat-input-0']")
	WebElement usernameInput;
	
	@FindBy(xpath="//input[@id='mat-input-1']")
	WebElement passwordInput;
	
	@FindBy(xpath="//button[contains(text(), 'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//mat-error[contains(text(), 'Email')]")
	WebElement usernameError;
	
	@FindBy(xpath="//mat-error[contains(text(), 'Password')]")
	WebElement passwordError;
	
	
	
	public void sendUsername(String username)
	{
		usernameInput.sendKeys(username);
	}

	public void sendPassword(String password)
	{
		passwordInput.sendKeys(password);
	}
	
	public void clickLoginBtn()
	{
		loginBtn.click();
	}
	
	public String passwordErrorMsg()
	{
		return passwordError.getText();
	}
	
	public String usernameErrorMsg() 
	{
		return usernameError.getText();
		
	}
	
	
	public LoginPg01(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
}
