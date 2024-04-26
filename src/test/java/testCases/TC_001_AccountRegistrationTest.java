package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"sanity", "master"})
	public void verify_account_registration() 
	{
		logger.info("***Starting of TC_001_AccountRegistrationTest***");
		logger.debug("Debugging of TC_001_AccountRegistrationTest****");
		try
		{
		HomePage hp= new HomePage(driver);
		
		logger.info("Click on Account");
		hp.clickAccount();
		
	    logger.info("Click on Register Link");
		hp.clickRegister();
		
		logger.info("Entering details on Registration Page");
		RegistrationPage rp= new RegistrationPage(driver);
		rp.FirstNameMethod(randomAlphabet());
		rp.LastNameMethod(randomAlphabet());
		rp.EmailMethod(randomAlphaNumeric()+"@gmail.com");
		rp.TeleMethod(randomNumber());
		
		String passwordVar= randomAlphaNumeric();
		rp.PasswordMethod(passwordVar);
		rp.ConfirmPasswordMethod(passwordVar);
		
		rp.AgreeMethod();
		rp.ContinueMethod();
		
		logger.info("Confirmation message");
		String confMsg=rp.ConfirmMsgMethod();
		Assert.assertEquals(confMsg, "Your Account Has Been Created!");
		}
		catch (Exception e) {
			Assert.fail();
			logger.info("Test Fail");
		}
		logger.info("Testing of TC_001_AccountRegistration is Finished");
		System.out.println("");
	}
}
