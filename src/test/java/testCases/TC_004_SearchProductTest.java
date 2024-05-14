package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass {
	@Test(groups = { "master" })
	public void verify_pruductSearch() {
		try {
			logger.info("***Starting TC_004_SearchProductTest****");
			HomePage hp = new HomePage(driver);
			hp.enterProductName("mac");
			hp.clickSearch();
			SearchPage search = new SearchPage(driver);
			search.isProductExist("MacBook");
			Assert.assertEquals(search.isProductExist("MacBook"), true);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info(" Finished TC_004_SearchProductTest ");
	}
}
