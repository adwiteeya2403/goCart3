package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
     WebDriver driver;
     
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement emailElement;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement passwordElement;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginElement;
	
	public void emailMethod(String userEmail) {
		emailElement.sendKeys(userEmail);
	}
	
	public void passwordMethod(String userPAssword) {
		passwordElement.sendKeys(userPAssword);
	}
	
	public void loginMethod() {
		loginElement.click();
	}
}
