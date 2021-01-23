package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.company.util.ElementUtil;

public class ReservePage {
	
	private ElementUtil elementUtil;
	private WebDriver driver;

	public ReservePage(WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
		elementUtil.waitForPageToload();
	}

	private By chooseThisFlightBtn = By.cssSelector("input[type='submit']");
	
	
	/**
	 * select the first flight from the search result of fligts
	 * @return PurchasePage
	 */
	public PurchasePage selectFirstFlightFromSearchResult() {
		elementUtil.click(chooseThisFlightBtn);
		return new PurchasePage(driver);
	}

	
	
	
		
}
