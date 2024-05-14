package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(groups= {"regression","master"})
	public void verify_account_registration() {
		logger.info("*** Starting TC_001_AccountRegistrationTest *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***Clicked on My account Link***");
			hp.clickRegister();
			logger.info("***Clicked on My Registration Link***");

			logger.info("***Entering customer details ***");
			AccountRegistrationPage accreg = new AccountRegistrationPage(driver);
			accreg.setFirstName(randomString());
			accreg.setLastName(randomString());
			accreg.setEmail(randomString() + "@gmail.com");
			accreg.setTelephone(randomNumber());
			String password = alphaNumeric();
			accreg.setPassword(password);
			accreg.setConfirmPassword(password);
			accreg.setPrivacyPolicy();
			accreg.clickContinue();
			logger.info("***clicked on continue***");
			String confmsg = accreg.getConfirmationMsg();
			logger.info("***Validating expected Message***");
			if (confmsg.equals("Your Account Has Been Created!")) {
				logger.info("test passed");
				Assert.assertTrue(true);
			} else {
				logger.info("test failed");
				Assert.fail();
			}
		} catch (Exception e) {
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("*** End of TC_001_AccountRegistrationTest *****");
	}
}
