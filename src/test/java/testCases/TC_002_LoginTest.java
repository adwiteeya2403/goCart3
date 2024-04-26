package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups = {"regression", "master"})
	public void verify_login_test() 
	{
	  logger.info("***Starting of TC_002_LoginTest***");
	  logger.debug("Debugging of TC_002_LoginTest");
		try {
			
		HomePage hp= new HomePage(driver);
		hp.clickAccount();
		logger.info("Click on My Account");
		hp.clickLogin();
		logger.info("Click on Login link");
		
		LoginPage lp= new LoginPage(driver);
		logger.info("Login page is displayed");
		lp.emailMethod(p.getProperty("email"));
		logger.info("Enter user Email");
		lp.passwordMethod(p.getProperty("password"));
		logger.info("Enter user Password");
		lp.loginMethod();
		logger.info("Click on Login button");
		
		MyAccountPage map= new MyAccountPage(driver);
		boolean target= map.myAccount();
		
		if(target==true) {
			Assert.assertTrue(target);
			logger.info("my account is displayed");
		}
		else {
			Assert.fail();
			logger.info("test failed");
		}
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("Testing of TC_002_LoginTest is Finished");
	}
}
