package com.w2a.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.w2a.base.Base;

public class HomePage extends Base {

	@FindBy(xpath = "button[ng-click='customer()']")
	private WebElement customerBtn;

	@FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
	private WebElement managerBtn;

	@FindBy(xpath = "//button[normalize-space()='Home']")
	private WebElement homeBtn;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void goToCustomerLogin() {
		click(customerBtn, "Customer button");
	}

	public void goToManagerLogin() {
		click(managerBtn, "Bank Manager button");
//		test.log(Status.INFO, "Clicking on Bank Manager Button");
	}

	public void goToHome() {
		click(homeBtn, "Home Button");
//		test.log(Status.INFO, "Clicking on Home Button");
	}

}
