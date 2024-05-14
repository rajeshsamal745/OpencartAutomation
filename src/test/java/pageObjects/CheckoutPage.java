package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	// Billing Details
	@FindBy(xpath = "//input[@value='new']")
	WebElement addressRadioBtn;
	@FindBy(xpath="//input[@id='input-payment-firstname']")
	WebElement txtfirstName;
	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastname;
	@FindBy(xpath = "//input[@name='address_1']")
	WebElement address;
	@FindBy(xpath = "//input[@name='city']")
	WebElement city;
	@FindBy(xpath = "//input[@name='postcode']")
	WebElement postcode;
	@FindBy(xpath = "//select[@id='input-payment-country']")
	WebElement drpCountry;
	@FindBy(xpath = "//select[@id='input-payment-zone']")
	WebElement drpState;
	@FindBy(xpath = "//input[@id='button-payment-address']")
	WebElement billingBtn;

	// Delivery Details
	@FindBy(xpath = "//input[@id='button-shipping-address']")
	WebElement deliveryBtn;
	// Delivery Method
	@FindBy(xpath = "//input[@id='button-shipping-method']")
	WebElement deliveryMethodBtn;
	// Payment Method
	@FindBy(xpath = "//input[@name='agree']")
	WebElement agreeCheckbox;
	@FindBy(xpath = "//input[@id='button-payment-method']")
	WebElement paymentMethodBtn;
	// Confirm Order
	@FindBy(xpath = "//strong[text()='Total:']//following::td")
	WebElement totalPrice;
	@FindBy(xpath = "//input[@value='Confirm Order']")
	WebElement confirmOrder;

	@FindBy(xpath = "//*[@id='content']/h1")
	WebElement lblOrderConMsg;

	public void clickAddressRadioBtn() {
		addressRadioBtn.click();
	}

	public void setFirstName(String firstName) {
		txtfirstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		lastname.sendKeys(lastName);
	}

	public void setAddress(String address1) {
		address.sendKeys(address1);
	}

	public void setPostalCode(String pcode) {
		city.sendKeys(pcode);
	}

	public void setCity(String cityinfo) {
		postcode.sendKeys(cityinfo);
	}

	public void setCountry(String country) {
		new Select(drpCountry).selectByVisibleText(country);
	}

	public void setState(String state) {
		new Select(drpState).selectByVisibleText(state);
	}

	public void clickBillingBtn() {
		billingBtn.click();
	}

	public void clickDeliveryBtn() {
		deliveryBtn.click();
	}

	public void clickDeliveryMethodBtn() {
		deliveryMethodBtn.click();
	}

	public void clickAgreeCheckbox() {
		agreeCheckbox.click();
	}

	public void clickpaymentMethod() {
		paymentMethodBtn.click();
	}

	public String getTotalPrice() {
		return totalPrice.getText();
	}

	public void clickConfirmOrder() {
		confirmOrder.click();
	}

	public boolean isOrderPlaced() {
		try {
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			confirmOrder.click();
			if (lblOrderConMsg.getText().equals("Your order has been placed!"))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

}
