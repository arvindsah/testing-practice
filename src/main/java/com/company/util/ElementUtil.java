package com.company.util;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private final WebDriver driver;
	private WebDriverWait wait;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIME_OUT);
	}
	
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}

	public void click(By locator) {
		this.getElement(locator).click();
	}

	public void selectDropDownValue(By locator, DropDown type, String value) {
		
		Select select = new Select(this.getElement(locator));
		
		switch(type) {
		case INDEX:
			select.selectByIndex(Integer.parseInt(value));
			break;
		case VALUE:
			select.selectByValue(value);
			break;
		case VISIBLETEXT:
			select.selectByVisibleText(value);
			break;
			
			default:
				System.out.println("Selection criteria isn't correct, please pass correct selection criteria");
				break;
		}
		
	}
	
	
	/**
	 * wait until page to completed loaded 
	 * @param 
	 */
	public void waitForPageToload() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			wait.until(expectation);
		} catch (Exception error) {
			fail("Timeout waiting for Page Load Request to complete. " + error.getCause()+ error.getStackTrace());
		}
	}

	public boolean waitForVisibility(By locator) {
		WebDriverWait wait= new WebDriverWait(driver, AppConstants.DEFAULT_TIME_OUT);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			throw new NoSuchElementException("Element not visible : " + locator );
		}
		return true;
	}

	public void sendKeys(By locator, String value) {
		this.getElement(locator).sendKeys(value);
		
	}

	public String getText(By locator) {
		return this.getElement(locator).getText().trim();
		
	}

}
