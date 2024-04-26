
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
  
	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement eleFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") 
	WebElement eleLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement eleEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement eleTele;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement elePassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement eleConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement eleAgree;
	
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement eleContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement eleConfMsg;
	
	public void FirstNameMethod(String firstname) {
		eleFirstName.sendKeys(firstname);
	}
	
	public void LastNameMethod(String lastname) {
		eleLastName.sendKeys(lastname);
	}
	
	public void EmailMethod(String email) {
		eleEmail.sendKeys(email);
	}
	
	public void TeleMethod(String tele) {
		eleTele.sendKeys(tele);
	}
	
	public void PasswordMethod(String passwword) {
		elePassword.sendKeys(passwword);
	}
	
	public void ConfirmPasswordMethod(String confirmPass) {
		eleConfirmPassword.sendKeys(confirmPass);
	}
	
    public void AgreeMethod() {
    	eleAgree.click();
    }	
    
    public void ContinueMethod() {
		eleContinue.click();
	}
    
    public String ConfirmMsgMethod() {
    	try {
			return(eleConfMsg.getText());
		} catch (Exception e) {
			return(e.getMessage());
		}
    }
}
