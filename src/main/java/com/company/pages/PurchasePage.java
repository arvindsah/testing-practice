package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.company.util.DropDown;
import com.company.util.ElementUtil;

public class PurchasePage {
	
	private ElementUtil elementUtil;
	private WebDriver driver;

	/**
	 * 
	 * @param driver
	 */
	public PurchasePage(WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
	}

	
	
	private By addressInput = By.id("address");
	
	private By nameInputField = By.id("inputName");
	private By cityInputField = By.id("city");
	private By stateInputField = By.id("state");
	private By zipCodeInputField = By.id("zipCode");
	private By cardTypeDropdown= By.id("cardType");
	private By cardNumebrInputField= By.id("creditCardNumber");
	private By monthInputField= By.id("creditCardMonth");
	private By yearInputField= By.id("creditCardYear");
	private By nameOnCard= By.id("nameOnCard");
	private By purchaseFlightSubmitBtn = By.cssSelector("input[type='submit']");
	By totalCostValue=By.xpath("//p[contains(text(),'Total Cost:')]/em");
	
	
	/**
	 * as part of the below method values are hardcoded we can user faker class to generate the 
	 * random values at the run time 
	 * @return
	 */
	public PurchasePage enterUserDetails() {
		
		this.enterName("HeroMotoCorp");
		this.enterAddress("address");
		this.enterCity("bangalore");
		this.enterState("karnataka");
		this.enterZipCode("11111");
		this.selectCardType("amex");
		this.enterCardNumber("8234797123097");
		this.enterMonth("01");
		this.enterYear("2021");
		this.enterNameOnCard("HeroMotoCorp");
		return this;
	}
	
	
	

	public void enterNameOnCard(String NameOnCard) {
		elementUtil.sendKeys(nameOnCard, NameOnCard);
	}




	public void enterYear(String year) {
		elementUtil.sendKeys(yearInputField, year);
	}




	public void enterMonth(String month) {
		elementUtil.sendKeys(monthInputField, month);
	}




	public void enterCardNumber(String cardNumber) {
		elementUtil.sendKeys(cardNumebrInputField, cardNumber);
	}




	public void selectCardType(String cardTypeByValue) {
		elementUtil.selectDropDownValue(cardTypeDropdown, DropDown.VALUE, cardTypeByValue);
	}




	public void enterZipCode(String zipCode) {
		elementUtil.sendKeys(zipCodeInputField, zipCode);
	}




	public void enterState(String state) {
		elementUtil.sendKeys(stateInputField, state);
		
	}




	public void enterCity(String city) {
		elementUtil.sendKeys(cityInputField, city);
	}
	
	
	public void enterAddress(String address) {
		
		elementUtil.sendKeys(addressInput, address);
	}

	
	
	public void enterName(String name) {
		elementUtil.sendKeys(nameInputField, name);
	}



	
	public ConfirmationPage clickOnPurchaseFlight() {
		
		elementUtil.click(purchaseFlightSubmitBtn);
		return new ConfirmationPage(driver);
	}




	public String getTotalAmount() {
		return elementUtil.getText(totalCostValue);
	}



		
}
