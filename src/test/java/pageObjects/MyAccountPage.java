package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myAccountElement;
	
	@FindBy(linkText="Logout")
	WebElement logoutElement;
	
	public boolean myAccount() {
      try {
		return(myAccountElement.isDisplayed());
	} catch (Exception e) {
		return(false);
	}
	}
	
	public void logoutMethod() {
		logoutElement.click();
	}
}
