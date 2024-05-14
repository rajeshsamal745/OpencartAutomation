package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {
	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[text()='Account Logout']")
	WebElement LogoutTxt;
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement ContinueBtn;

	public String isLogoutPageExists() {
		return LogoutTxt.getText();
	}

	public void clickingContinueBtn() {
		ContinueBtn.click();
	}
}
