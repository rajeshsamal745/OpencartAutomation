package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkMyaccount;
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegister;
	@FindBy(xpath="//a[text()='Login']")
	WebElement btnLogin;
	@FindBy(xpath="//input[@name='search']")
	WebElement txtSearchbox;
	@FindBy(xpath="//span[@class='input-group-btn']//button[@type='button']")
	WebElement btnSearch;
	
	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	public void clickRegister() {
		lnkRegister.click();
	}
	public void clickLogin() {
		btnLogin.click();
	}
	public void enterProductName(String pName) {
		txtSearchbox.sendKeys(pName);	
	}
	public void clickSearch() {
		btnSearch.click();
	}
}
