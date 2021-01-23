package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.company.util.ElementUtil;

public class ConfirmationPage {
	private ElementUtil elementUtil;
	private WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
		elementUtil.waitForPageToload();
	}

	private By bookingId = By.xpath("//tbody//td[contains(text(),'Id')]/../td[2]");
	private By amount = By.xpath("//tbody//td[contains(text(),'Amount')]/../td[2]");
	private By confirmationMessage = By.xpath("//div/h1");
	
	
	public String getBookingConfirmationId() {
		
		return elementUtil.getText(bookingId);
	}

	public String getConfirmationMessage() {
		return elementUtil.getText(confirmationMessage);
	}

	public String getAmount() {
		return elementUtil.getText(amount).split(" ")[0];
	}
}
