package com.company.tests;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.company.pages.HomePage;
import com.company.pages.PurchasePage;
import com.company.pages.ReservePage;
import com.company.util.AppConstants;

public class HomePageTest extends BaseTest{


	@Test
	public void checkUserAbleToSearchFlights() {
		HomePage homepage= new HomePage(getDriver());
		
		/*
		 * we can create additional enum for departure location and using that we can
		 * create additionl util method to get randome city name instead of hard coding
		 * it at the script level
		 */
		ReservePage reservePage=homepage.searchFlights("Boston", "Rome");
		
		
		
		/**
		 * we can create additional methods to select random flight from the list
		 */
		PurchasePage purchasePage=reservePage.selectFirstFlightFromSearchResult();
		
		
		String bookingId=purchasePage.enterUserDetails()
		.clickOnPurchaseFlight()
		.getBookingConfirmationId();
		
		System.out.println("Booking confirmation id " + bookingId);
		assertTrue(!bookingId.isEmpty(), "Booking id not found");
	}
	
	
	@Test
	public void checkFlightConfirmationMessage() {
		HomePage homepage= new HomePage(getDriver());
		ReservePage reservePage=homepage.searchFlights("Boston", "Rome");
		
		
		PurchasePage purchasePage=reservePage.selectFirstFlightFromSearchResult();
		
		String confirmationMessage=purchasePage.enterUserDetails()
		.clickOnPurchaseFlight()
		.getConfirmationMessage();
		
		System.out.println("Booking confirmation message " + confirmationMessage);
		assertTrue(confirmationMessage.equalsIgnoreCase(AppConstants.BOOKING_CONFIRMATION_MESSAGE), "Booking confirmation message isn't correct");
	}
	
	
	@Test
	public void checkBookingConfirmationAmountEqualToTotalAmount() {
		HomePage homepage= new HomePage(getDriver());
		ReservePage reservePage=homepage.searchFlights("Boston", "Rome");
		
		
		PurchasePage purchasePage=reservePage.selectFirstFlightFromSearchResult();
		
		String totalAmountShownAtPurchasePage=purchasePage.getTotalAmount();
		System.out.println("Total amount - " + totalAmountShownAtPurchasePage);
		
		String bookingConfimationAmount=purchasePage.enterUserDetails()
		.clickOnPurchaseFlight()
		.getAmount();
		
		System.out.println("Booking confirmation amount " + bookingConfimationAmount);
		Assert.assertEquals(bookingConfimationAmount, totalAmountShownAtPurchasePage, "booking amount at confirmation page isn't same");
	}

}
