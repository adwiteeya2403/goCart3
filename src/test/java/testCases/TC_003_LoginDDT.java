package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{

   @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"master"})
   public void verify_Login_DDT(String email, String password, String exp){
	   
	   HomePage hp= new HomePage(driver);
	   hp.clickAccount();
	   hp.clickLogin();
	   
	   LoginPage lp= new LoginPage(driver);
	   lp.emailMethod(email);
	   lp.passwordMethod(password);
	   lp.loginMethod();
	   
	   MyAccountPage map= new MyAccountPage(driver);
	   boolean target= map.myAccount();
	   if(exp.equalsIgnoreCase("Valid")) {
		   if(target==true) {
			   map.logoutMethod();
			   Assert.assertTrue(true);
		   }
		   else {
			   Assert.assertTrue(false);
		   }
	   }
	   else if(exp.equalsIgnoreCase("Invalid")){
		   if(target==true) {
			   map.logoutMethod();
			   Assert.assertTrue(false);
		   }
		   else {
			   Assert.assertTrue(true);
		   }
	   }
   }
	
}
