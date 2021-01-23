package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.company.util.DropDown;
import com.company.util.ElementUtil;

public class HomePage {

	private ElementUtil elementUtil;
	private WebDriver driver;
	
	/**
	 * Constructor to inilized the member variables of the calls. for ex- driver instance
	 * @param driver
	 */
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
		/**
		 * you can create additional class for java script util and same can be inilized as part of the
		 * //constructor so that same driver instance id can be passed to jsutil 
		 */
		elementUtil.waitForPageToload();
		 
	}

	
	private By departuteCityDropDown = By.cssSelector("select[name='fromPort']");
	private By destinationCityDropDown = By.cssSelector("select[name='toPort']");
	private By locator=By.cssSelector("input[value='Find Flights']");
	
	
	/**
	 * search flight by providing the depature city and destination city
	 * @param departureCity
	 * @param destinationCity
	 * @return ReservePage
	 */
	public ReservePage searchFlights(String departureCity, String destinationCity) {
		this.selectDepartureCity(departureCity);
		this.selectDestinationCity(destinationCity);
		return this.clickOnFindFlights();
	}

	private ReservePage clickOnFindFlights() {
		elementUtil.click(locator);
		return new ReservePage(driver);
	}

	public HomePage selectDestinationCity(String destinationCity) {
		
		elementUtil.selectDropDownValue(destinationCityDropDown, DropDown.VALUE,destinationCity);
		return this;
	}

	public HomePage selectDepartureCity(String departureCity) {
		elementUtil.waitForVisibility(departuteCityDropDown);
		elementUtil.selectDropDownValue(departuteCityDropDown, DropDown.VALUE,departureCity);
		return this;
	}
	
	

}
