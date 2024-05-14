package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_006_EndToEndTest extends BaseClass {

	@Test(groups = { "master" })
	public void endToendTest() throws InterruptedException {
		SoftAssert myassert = new SoftAssert();
		logger.info("*** Starting TC_006_EndToEndTest *****");

		System.out.println("Account Registration................");
		HomePage home = new HomePage(driver);
		home.clickMyAccount();
		home.clickRegister();

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
		Thread.sleep(3000);
		String confmsg = accreg.getConfirmationMsg();
		myassert.assertEquals(confmsg, "Your Account Has Been Created!");

		MyAccountPage myacc = new MyAccountPage(driver);
		myacc.clickLogout();
		Thread.sleep(3000);

		LogoutPage logout = new LogoutPage(driver);
		String logoutConfMsg = logout.isLogoutPageExists();
		Assert.assertEquals(logoutConfMsg, "Account Logout");
		logout.clickingContinueBtn();

		System.out.println("Login to application...............");
		home.clickMyAccount();
		home.clickLogin();
		LoginPage login = new LoginPage(driver);
		login.setEmail(prop.getProperty("email"));
		login.setPassword(prop.getProperty("password"));
		login.clickLoginBtn();
		System.out.println("Going to My Account Page? " + myacc.isMyAccountPageExists());
		myassert.assertEquals(myacc.isMyAccountPageExists(), "My Account");

		System.out.println("search & add product to cart...............");
		home.enterProductName(prop.getProperty("searchProductName"));
		home.clickSearch();

		SearchPage search = new SearchPage(driver);
		if (search.isProductExist(prop.getProperty("searchProductName"))) {
			search.selectProduct(prop.getProperty("searchProductName"));
			search.setQuantity("2");
			search.addToCart();
		}
		System.out.println("Added product to cart ? " + search.checkConfMsg());
		myassert.assertEquals(search.checkConfMsg(), "Success: You have added");

		System.out.println("Shopping cart...............");
		ShoppingCartPage cart = new ShoppingCartPage(driver);
		cart.clickItemsToNavigateToCart();
		cart.clickViewCart();
		String TotalPrice = cart.getTotalPrice();
		myassert.assertEquals(cart.getTotalPrice(), TotalPrice);
		cart.clickOnCheckout();
		Thread.sleep(3000);
		System.out.println("Checkout Product...............");
		CheckoutPage checkout = new CheckoutPage(driver);

		Thread.sleep(3000);
		checkout.clickAddressRadioBtn();
		Thread.sleep(3000);

		checkout.setFirstName(randomString());
		Thread.sleep(3000);
		checkout.setLastName(randomString());
		checkout.setAddress("Plot No L-264 , GGP Colony , Near Sai Temple , Rasulgarh");
		checkout.setCity("Bhubaneswar");
		checkout.setPostalCode("751010");
		checkout.setCountry("India");
		checkout.setState("Orissa");

		checkout.clickBillingBtn();
		Thread.sleep(3000);
		checkout.clickDeliveryBtn();
		Thread.sleep(3000);
		checkout.clickDeliveryMethodBtn();
		Thread.sleep(3000);
		checkout.clickAgreeCheckbox();
		Thread.sleep(3000);
		checkout.clickpaymentMethod();
		Thread.sleep(3000);
		String total_price_inOrderPage = checkout.getTotalPrice();
		myassert.assertEquals(total_price_inOrderPage, "$131.20");
		checkout.clickConfirmOrder();
		Thread.sleep(5000);
		boolean orderconf = checkout.isOrderPlaced();
		System.out.println("Is Order Placed? " + orderconf);
		myassert.assertEquals(checkout.isOrderPlaced(), true);

	}
}
