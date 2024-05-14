package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"sanity","master"})
	public void verify_login() {
		try {
			logger.info("**** Starting TC_002_LoginTest  ****");

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on myaccount link on the home page..");
			hp.clickLogin();
			logger.info("clicked on login link under myaccount..");

			LoginPage login = new LoginPage(driver);
			logger.info("Entering valid email and password..");
			login.setEmail(prop.getProperty("email"));
			login.setPassword(prop.getProperty("password"));
			login.clickLoginBtn();
			logger.info("clicked on ligin button..");

			MyAccountPage myacc = new MyAccountPage(driver);
			boolean targetPage = myacc.isMyAccountPageExists();
			if (targetPage == true) {
				logger.info("Login Test Passed...");
				Assert.assertTrue(true);
			} else {
				logger.info("Login test Failed");
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC_002_LoginTest  ****");
	}
}
