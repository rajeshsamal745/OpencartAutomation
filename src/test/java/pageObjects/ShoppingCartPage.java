package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='cart']")
	WebElement btnItems;
	@FindBy(xpath = "//strong[text()=' View Cart']")
	WebElement lnkViewCart;
	@FindBy(xpath = "//table[@class='table table-bordered']//tr[4]//td[2]")
	WebElement lblTotalPrice;
	@FindBy(xpath = "//a[text()='Checkout']")
	WebElement btnCheckout;

	public void clickItemsToNavigateToCart() {
		btnItems.click();
	}

	public void clickViewCart() {
		lnkViewCart.click();
	}

	public String getTotalPrice() {
		return lblTotalPrice.getText();
	}

	public void clickOnCheckout() {
		btnCheckout.click();
	}
}
