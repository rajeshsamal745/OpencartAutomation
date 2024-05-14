package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_005_AddToCartPageTest extends BaseClass {

	@Test(groups = { "master" })
	public void verify_addToCart() {
		logger.info("***Starting TC_005_AddToCartPageTest****");
		HomePage hp = new HomePage(driver);
		hp.enterProductName("iPhone");
		hp.clickSearch();

		SearchPage search = new SearchPage(driver);
		try {
			if (search.isProductExist("iPhone")) {
				search.selectProduct("iPhone");
				search.setQuantity("2");
				search.addToCart();
			}
			Assert.assertEquals(search.checkConfMsg(), true);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info(" Finished TC_004_SearchProductTest ");
	}
}
