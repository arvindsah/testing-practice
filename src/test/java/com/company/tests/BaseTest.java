package com.company.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	Properties prop;
	protected  String baseUrl;
	private String browser;
	private String url= null;
	
	
	private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public synchronized static WebDriver getDriver() {
		return tldriver.get();
	}
	
	public WebDriver init_driver(String browerName, String url)  {
		System.out.println("launch the "+ browerName + " browser" );
		
		
		switch(browerName.toLowerCase()) {
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
			break;

		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
			break;
			
		case "Edge" :
			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
			break;

		default: {
			System.out.println(("browser name : " + browerName + " not found"));
			throw new RuntimeException("Unsupported browser");
		}
		}
		
	
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
	
		baseUrl=url;
		getDriver().get(url);
		
		return getDriver();

	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void setup() {
		init_properties();
		browser = getBrowser();
		url = prop.getProperty("url");
		init_driver(browser, url);
	}

	

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		if (!getDriver().toString().contains("(null)")) {
				getDriver().quit();
				System.out.println("closed browser ");

			}
		}

	
	private Properties init_properties() {
		prop= new Properties();
		String env=null;
		String path=null;
		
		try {
			env = System.getProperty("env");
			if (env.equalsIgnoreCase("qa")) {
				path = ".\\src\\main\\resources\\config\\config.qa.properties";
			}
			if (env.equalsIgnoreCase("uat")) 
			{
				path = ".\\src\\main\\resources\\config\\config.uat.properties";
			}
			
		}
		catch(Exception e)
		{
			path=".\\src\\main\\resources\\config\\config.qa.properties";
			System.out.println(("Selecting default env as qa"));
		}
		
		try {
			FileInputStream fileInputStream= new FileInputStream(path);
			prop.load(fileInputStream);
		} catch (FileNotFoundException e) {
			System.out.println("unable to read config properies");
		} catch (IOException e) {
			System.out.println("unable to load properties file");
		}
		return prop;
	}

	private String getBrowser() {

		try {
			browser = System.getProperty("browser").toLowerCase();
			switch (browser) {

			case "chrome":
				browser = "chrome";
				break;

			case "firefox":
				browser = "firefox";
				break;

			case "edge":
				browser = "edge";
				break;
			default:
				browser = prop.getProperty("browser");
				break;
			}
		} catch (Exception e) {
			browser = prop.getProperty("browser");
		}
		System.out.println("Browser selected for execution - " + browser);
		return browser;
	}
	
	}
