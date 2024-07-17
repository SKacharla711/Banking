package com.w2a.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.w2a.base.Base;

public class AddCustomerPage extends Base{
	
	@FindBy(css = "input[placeholder='First Name']")
	private WebElement firstName;
	
	@FindBy(css = "input[placeholder='Last Name']")
	private WebElement lastName;
	
	@FindBy(css = "input[placeholder='Post Code']")
	private WebElement postalCode;

	@FindBy(css = "button[type='submit']")
	private WebElement addCustomerBtn;
	
	public AddCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addCustomer(String firstNameValue) {
		sendKeys(firstName, "First Name",firstNameValue);
		sendKeys(lastName, "Last Name", "Kacharla");
		sendKeys(postalCode, "Postal Code", "500050");
		click(addCustomerBtn, "Add Customer");
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
