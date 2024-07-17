package com.w2a.tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.w2a.base.Base;
import com.w2a.pages.AddCustomerPage;
import com.w2a.pages.BankManagerHomePage;
import com.w2a.pages.CustomersPage;
import com.w2a.pages.HomePage;
import com.w2a.utilities.ExcelUtililty;

public class HomeTest extends Base {

//	@Test(priority = 1)
	public void verifyCustomerLoginBtn() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.goToCustomerLogin();
	}

//	@Test(priority = 2)
	public void verifyManagerLoginBtn() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.goToManagerLogin();
	}

	@Test(priority = 1)
	public void addCustomer() throws InterruptedException, IOException {
		ExcelUtililty excel = new ExcelUtililty();
		HashMap<String, String> tcData = excel.getTCData("Banking", "Add Customer", "Add Customer");
		HomePage homePage = new HomePage();
		homePage.goToManagerLogin();

		BankManagerHomePage bmhPage = new BankManagerHomePage();
		bmhPage.goToAddCustomer();

		AddCustomerPage addCustomerPage = new AddCustomerPage();
		addCustomerPage.addCustomer(tcData.get("First Name"));
	}

	@Test(priority = 2)
	public void deleteCustomer() throws IOException {
		ExcelUtililty excel = new ExcelUtililty();
		HashMap<String, String> tcData = excel.getTCData("Banking", "Add Customer", "Add Customer");
		HomePage homePage = new HomePage();
		homePage.goToHome();
		homePage.goToManagerLogin();

		BankManagerHomePage bmhPage = new BankManagerHomePage();
		bmhPage.goToCustomers();

		CustomersPage customersPage = new CustomersPage();

		customersPage.searchCustomer(tcData.get("First Name"));
		customersPage.deleteCustomer(tcData.get("First Name"));

	}
}
