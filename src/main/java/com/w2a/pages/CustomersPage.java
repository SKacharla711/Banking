package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.w2a.base.Base;

public class CustomersPage extends Base {

	@FindBy(css = "input[placeholder='Search Customer']")
	private WebElement searchCustomerTxt;

	@FindBy(css = "input[placeholder='Search Customer']")
	private WebElement deleteCustBtn;

	public CustomersPage() {
		PageFactory.initElements(driver, this);
	}

	public void searchCustomer(String customerName) {
		click(searchCustomerTxt, "Search Customer");
		sendKeys(searchCustomerTxt, "Seacrh Customer", customerName);
	}

	public void deleteCustomer(String customerName) {
		WebElement deleteCustomerBtn = driver
				.findElement(By.xpath("//tr[contains(@ng-repeat,'cust in Customers')]/td[text()='" + customerName
						+ "']//ancestor::tbody//button"));
		click(deleteCustomerBtn, "Delete");
		log.debug("Deleted " + customerName);
	}

}
