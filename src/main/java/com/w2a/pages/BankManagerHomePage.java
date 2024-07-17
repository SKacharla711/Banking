package com.w2a.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.w2a.base.Base;

public class BankManagerHomePage extends Base {

	@FindBy(xpath = "//button[@ng-click='addCust()']")
	private WebElement addCustomer;

	@FindBy(xpath = "//*[@ng-click='openAccount()']")
	private WebElement openAccount;

	@FindBy(xpath = "//*[@ng-click='showCust()']")
	private WebElement customers;

	public BankManagerHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void goToAddCustomer() {
		click(addCustomer, "Add Customer");
	}

	public void goToCustomers() {
		click(customers, "Show Customer");
	}

}
